package Data.Handler;

import Data.Mapper.UserMapper;
import Model.User;
import View.*;

import java.util.ArrayList;

public class UserHandler {
    private ArrayList<User> users;
    
    UI ui = new UI();
    UserMapper userMapper = new UserMapper();

    public User checkLogin(){
        boolean isloggedin = false;
        int counter = 5;
        User tmpUser = null;
        while(!isloggedin) {
            ui.printMessage("Velkommen til Delfinen svømmeklub!\n");
            ui.printMessage("Indtast brugernavn: ");
            String username = ui.getStrInput();
            ui.printMessage("Indtast kodeord: ");
            String password = ui.getStrInput();

            tmpUser = userMapper.checkLogin(username, password);

            if (tmpUser == null) {
                counter--;
                if (counter <= 0) {
                    ui.printMessage("Farvel...");
                    System.exit(0);
                } else if (counter <= 3) {
                    ui.printMessage("Forkert login! Du har " + counter + " forsøg tilbage!\nPrøv igen!\n");
                } else {
                    ui.printMessage("Forkert login! Prøv igen!\n");
                }
            } else {
                isloggedin = true;
            }
        }
            return tmpUser;
    }
}
