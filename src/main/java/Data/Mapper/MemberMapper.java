/**
 @author Emil Elkjær Nielsen (cph-en93@cphbusiness.dk)
 **/
package Data.Mapper;

import Model.*;
import Util.DBConnector;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MemberMapper {
    private final Connection connection = DBConnector.getInstance().getConnection();
    /**
     * Henter alle medlemmer fra SQL
     * Opretter Member objekter
     * Tilføjer dem til en midlertidig ArrayList som bliver retuneret
     * @param memberships ArrayListe med mulige memberships.
     **/
    public ArrayList<Member> getAllMembers(ArrayList<Membership> memberships){
        ArrayList<Member> tmpMembers = new ArrayList<>();

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

    public int[] getTopFive(String filter){
        String query = "";
        int[] result = new int[20];

        switch(filter){
            case "junior":
                query = "SELECT Members.ID AS \"MemberID\", Results.ID AS \"ResultID\"\n" +
                        "FROM Members\n" +
                        "INNER JOIN Results ON Results.MemberID = Members.ID\n" +
                        "INNER JOIN Memberships ON Memberships.ID = Members.Membership\n" +
                        "WHERE Results.Training = 0 AND Memberships.Name != \"Passiv\" AND Memberships.`Name` = \"Junior\"\n" +
                        "ORDER BY ResultTime, Results.Disciplin ASC LIMIT 20";
            case "senior":
                query = "SELECT Members.ID AS \"MemberID\", Results.ID AS \"ResultID\"\n" +
                        "FROM Members\n" +
                        "INNER JOIN Results ON Results.MemberID = Members.ID\n" +
                        "INNER JOIN Memberships ON Memberships.ID = Members.Membership\n" +
                        "WHERE Results.Training = 0 AND Memberships.Name != \"Passiv\" AND Memberships.`Name` = \"Senior\"\n" +
                        "ORDER BY ResultTime, Results.Disciplin ASC LIMIT 20";

        }

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

    /**
     * @param name Members full name
     * @param birthday Birthday
     * @param email E-mail for contact
     * @param phone Phone no. For Member (Format: 8 digits)
     * @param membership Membership object for the member
     * @return workable Member object
     */
    public Member createNewMember(String name, LocalDate birthday, String email, int phone, Membership membership) {

        try {
            String query = "INSERT INTO Members(Name, Birthday, Email, PhoneNo, Membership) VALUES (?,?,?,?,?)";
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
            int memberID = tableKeys.getInt(1);

            return new Member(memberID, name, birthday, email, phone, membership);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * Ændre data i SQL på medlemmet.
     * @param member Medlemsobjekt med ændringer
     **/
    public Member editMember(Member member){

        try {
            String query = "UPDATE Members SET Email=?, PhoneNo=?, Membership=? WHERE ID=? AND Name=? ";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,member.getEmail());
            statement.setInt(2,member.getPhone());
            statement.setInt(3,member.getMembership().getId());
            statement.setInt(4,member.getId());
            statement.setString(5,member.getName());
            statement.executeUpdate();

            return member;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return member;
    }

    /**
     * Sletter valgt medlem fra SQL
     * @param id Medlemsnummer som skal slettes i databasen
     **/
    public boolean deleteMember(int id) {

        try {
            String query = "DELETE FROM Members WHERE Members.ID = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);
            statement.executeUpdate();

            String confirmQuery = "SELECT * FROM Members WHERE Members.ID=?";
            statement = connection.prepareStatement(confirmQuery);

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (!result.next()) {
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
        }
    }
