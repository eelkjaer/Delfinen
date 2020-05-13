/**
 @author Emil Elkjær Nielsen (cph-en93@cphbusiness.dk)
 **/
package Data.Mapper;

import Model.*;
import Util.DBConnector;

import java.sql.*;
import java.util.ArrayList;

public class UserMapper {
    private final Connection connection = DBConnector.getInstance().getConnection();

    public ArrayList<User> getUsers(){
        ArrayList<User> tmpUsers = new ArrayList<>();


        try {
            Statement statement = connection.createStatement();

            String query = "SELECT Users.ID, Users.Username, Users.Name FROM Users;";

            ResultSet resultset = statement.executeQuery(query);

            while(resultset.next()) {
                int id = resultset.getInt("ID");
                String username = resultset.getString("Username");
                String name = resultset.getString("Name");

                User tmpUser = new User(id,username,name);

                tmpUsers.add(tmpUser);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return tmpUsers;
    }

    public User checkLogin(String username, String password){
        User tmpUser = null;
        try {
            String query = "SELECT * FROM Users WHERE Username=? AND Password=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet result = statement.executeQuery();

            if(result.next()){
                //korrekt login
                tmpUser = new User(result.getInt("ID"),username,password,result.getString("Name"),result.getInt("permissions"));
                return tmpUser;
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }
}
