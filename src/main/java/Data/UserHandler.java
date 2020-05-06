package Data;

import Model.User;
import Util.DBConnector;
import View.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserHandler {
    UI ui = new UI();
    public User checkLogin(){
        boolean isloggedin = false;
        int counter = 5;
        while(!isloggedin){
        User tmpUser;
        Connection connection = DBConnector.getInstance().getConnection();
        ui.printToConsole("Velkommen til Delfinen svømmeklub!\n");
        ui.printToConsole("Indtast brugernavn: ");
        String username = ui.getStrInput();
        ui.printToConsole("Indtast kodeord: ");
        String password = ui.getStrInput();


        try {
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet result = statement.executeQuery();

            if(result.next()){
                //korrekt login
                tmpUser = new User(username,password,result.getInt("permissions"));
                return tmpUser;
            } else {
                counter--;
                if(counter <= 0){
                    ui.printToConsole("Farvel...");
                    System.exit(0);
                } else if(counter <= 3){
                    ui.printToConsole("Forkert login! Du har " + counter + " forsøg tilbage!\nPrøv igen!\n");
                } else {
                    ui.printToConsole("Forkert login! Prøv igen!\n");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        }

        return null;
    }
}
