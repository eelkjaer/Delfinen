package Data.Mapper;

import Model.*;
import Util.DBConnector;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PaymentMapper {
    /**
     * @param members En liste over medlemmer
     * @return En liste med alle betalinger
     */
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

    public String getMissingPayments(){
        StringBuilder str = new StringBuilder();
        Connection connection = DBConnector.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();

            String query = "SELECT\n" +
                    "	Members.ID AS \"MemberID\",\n" +
                    "	Members.NAME,\n" +
                    "	sum( Payments.Paid ) - Memberships.Price AS \"Restance\" \n" +
                    "FROM\n" +
                    "	Members\n" +
                    "	INNER JOIN Payments ON Members.ID = Payments.MemberID\n" +
                    "	INNER JOIN Memberships ON Members.Membership = Memberships.ID \n" +
                    "GROUP BY\n" +
                    "	Members.ID \n" +
                    "HAVING\n" +
                    "	Restance < 0 OR Restance > 0 \n" +
                    "ORDER BY\n" +
                    "	Restance ASC";

            ResultSet resultset = statement.executeQuery(query);

            while(resultset.next()) {
                String memberName = resultset.getString("Name");
                int memberID = resultset.getInt("MemberID");
                double restance = resultset.getDouble("Restance");

                if(restance>0){
                    str.append("\n").append(memberName).append(" (ID: ").append(memberID).append(") har ").append(restance).append(" kr til gode\n");
                } else {
                    str.append("\n").append(memberName).append(" (ID: ").append(memberID).append(") skylder ").append(restance).append(" kr\n");
                }

            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return str.toString();
    }

    /**
     * @param member Medlemmet som har betalt
     * @param paid Hvor meget medlemmet har betalt
     * @return Betalingsobjektet
     */
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

            return new Payment(id,member,paid,timestamp);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}