package Data;

import Model.*;
import Util.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    /**
     * Indsætter nyt Member objekt i SQL og retunerer dette med korrekt id
     * @param member Memberobjekt som skal indsættes i databasen
     **/
    protected Member createNewMember(Member member){
        Member tmpMember = member;

        return tmpMember;
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
