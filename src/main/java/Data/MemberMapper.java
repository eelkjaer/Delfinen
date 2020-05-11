package Data;

import Model.*;
import Util.DBConnector;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MemberMapper {
    /**
     * Henter alle medlemmer fra SQL
     * Opretter Member objekter
     * Tilføjer dem til en midlertidig ArrayList som bliver retuneret
     * @param memberships ArrayListe med mulige memberships.
     **/
    public ArrayList<Member> getAllMembers(ArrayList<Membership> memberships){
        ArrayList<Member> tmpMembers = new ArrayList<>();

        Connection connection = DBConnector.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM Members;";

            ResultSet resultset = statement.executeQuery(query);

            while(resultset.next()) {
                int id = resultset.getInt("ID");
                String name = resultset.getString("Name");
                LocalDate birthday = resultset.getDate("Birthday").toLocalDate();
                String email = resultset.getString("Email");
                int phone = resultset.getInt("PhoneNo");
                int membershipId = resultset.getInt("Membership");
                Membership tmpMembership = null;

                for(Membership m:memberships){
                    if(m.getId() == membershipId){
                        tmpMembership = m;
                    }
                }

                Member tmpMember = new Member(id,name,birthday,email,phone,tmpMembership);

                tmpMembers.add(tmpMember);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return tmpMembers;
    }

    protected int[] getTopFive (String filter){
        String query = "";
        int[] result = new int[5];

        switch(filter){
            case "junior":
                query = "SELECT Members.ID AS \"MemberID\", Results.ID AS \"ResultID\"\n" +
                        "FROM Members\n" +
                        "INNER JOIN Results ON Results.MemberID = Members.ID\n" +
                        "INNER JOIN Memberships ON Memberships.ID = Members.Membership\n" +
                        "WHERE Results.Training = 0 AND Memberships.Name != \"Passiv\" AND Memberships.`Name` = \"Junior\"\n" +
                        "ORDER BY ResultTime ASC LIMIT 5";
            case "senior":
                query = "SELECT Members.ID AS \"MemberID\", Results.ID AS \"ResultID\"\n" +
                        "FROM Members\n" +
                        "INNER JOIN Results ON Results.MemberID = Members.ID\n" +
                        "INNER JOIN Memberships ON Memberships.ID = Members.Membership\n" +
                        "WHERE Results.Training = 0 AND Memberships.Name != \"Passiv\" AND Memberships.`Name` = \"Senior\"\n" +
                        "ORDER BY ResultTime ASC LIMIT 5";

        }

        Connection connection = DBConnector.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery(query);
            int counter = 0;

            while(resultset.next()) {
                int memberID = resultset.getInt("MemberID");
                int resultID = resultset.getInt("ResultID");

                //String str = memberID + "#" + resultID;
                //result[counter] = str;
                result[counter] = resultID;
                counter++;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return result;

    }

    protected Member createNewMember(String name, LocalDate birthday, String email, int phone, Membership membership) {
        Connection connection = DBConnector.getInstance().getConnection();

        try {
            String query = "INSERT INTO members(Name, Birthday, Email, PhoneNo, Membership) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

            Date ltd = Date.valueOf(birthday);


            statement.setString(1,name);
            statement.setDate(2,ltd);
            statement.setString(3,email);
            statement.setInt(4,phone);
            statement.setInt(5,membership.getId());
            statement.executeUpdate();
            ResultSet tableKeys = statement.getGeneratedKeys();
            tableKeys.next();
            int member_id = tableKeys.getInt(1);

            Member tmpMember = new Member(member_id, name, birthday, email, phone,membership);

            return tmpMember;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Ændre data i SQL på medlemmet.
     * @param id Medlemsnummer som skal ændres i databasen
     **/
    protected Member editMember(int id){

        return null;
    }

    /**
     * Sletter valgt medlem fra SQL
     * @param id Medlemsnummer som skal slettes i databasen
     **/
    protected boolean deleteMember(int id){
        return false;
    }
}
