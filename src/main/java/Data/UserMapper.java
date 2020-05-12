package Data;

import Model.*;
import Util.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserMapper {
    public ArrayList<User> getUsers(){
        ArrayList<User> tmpUsers = new ArrayList<>();

        Connection connection = DBConnector.getInstance().getConnection();
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


}
