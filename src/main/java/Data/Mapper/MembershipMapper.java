/**
 @author Emil Elkjær Nielsen (cph-en93@cphbusiness.dk)
 @author Andreas Bergmann (cph-ab435@cphbusiness.dk)
 **/
package Data.Mapper;

import Model.*;
import Util.DBConnector;

import java.sql.*;
import java.util.ArrayList;

public class MembershipMapper {
    private final Connection connection = DBConnector.getInstance().getConnection();
    public ArrayList<Membership> getMemberships(){
        ArrayList<Membership> tmpMemberships = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM Memberships;";

            ResultSet resultset = statement.executeQuery(query);

            while(resultset.next()) {
                int id = resultset.getInt("ID");
                String name = resultset.getString("Name");
                double price = resultset.getDouble("Price");

                Membership tmpMembership = new Membership(id,name,price);

                tmpMemberships.add(tmpMembership);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return tmpMemberships;
    }
}
