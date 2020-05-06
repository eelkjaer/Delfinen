import Controller.*;
import Data.UserHandler;
import Model.User;

public class Main {

    public static void main(String[] args) {
        MainController ctrl;
        UserHandler userHandler = new UserHandler();
        User user = userHandler.checkLogin();

        switch (user.getUserPermissions()){
            case 1:
                ctrl = new UserController();
                break;
            case 2:
                ctrl = new ModeratorController();
                break;
            case 3:
                ctrl = new AdminController();
                break;
            default:
                ctrl = new UserController();
                break;
        }
        ctrl.showMenu();
    }
}
