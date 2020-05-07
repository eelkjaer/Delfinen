package Data;

import Model.Member;
import Model.Payment;
import Util.DBConnector;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PaymentMapper {
    public ArrayList<Payment> getAllPayments(ArrayList<Member> members){
        ArrayList<Payment> tmpPayments = new ArrayList<>();

        Connection connection = DBConnector.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM Payments;";

            ResultSet resultset = statement.executeQuery(query);

            while(resultset.next()) {
                int paymentId = resultset.getInt("ID");
                int memberID = resultset.getInt("MemberID");
                double paid = resultset.getDouble("Paid");
                LocalDateTime paymentDate = resultset.getTimestamp("Timestamp").toLocalDateTime();

                Member tmpMember = null;
                for(Member m:members){
                        if(m.getId() == memberID){
                            tmpMember = m;
                        }
                    }

                Payment tmpPayment = new Payment(paymentId,tmpMember,paid,paymentDate);

                tmpPayments.add(tmpPayment);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return tmpPayments;
    }

    public Payment createNewPayment(Member member, double paid){
        int memberId = member.getId();

        Connection connection = DBConnector.getInstance().getConnection();
        try {
            String query = "INSERT INTO Payments(MemberID,Paid) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1,memberId);
            statement.setDouble(2,paid);
            statement.executeUpdate();
            ResultSet tableKeys = statement.getGeneratedKeys();
            tableKeys.next();
            int id = tableKeys.getInt(1);
            LocalDateTime timestamp = tableKeys.getTimestamp("Timestamp").toLocalDateTime();

            Payment tmpPayment = new Payment(id,member,paid,timestamp);

            return tmpPayment;

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
