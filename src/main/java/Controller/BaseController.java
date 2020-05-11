package Controller;

import Data.UserHandler;
import Model.User;
import View.UI;

public class BaseController {
    UI ui = new UI();
    MainController ctrl;
    UserHandler userHandler;
    public void login(){
         userHandler = new UserHandler();
         User user = userHandler.checkLogin();

        switch (user.getUserPermissions()){
            case 1:
                ctrl = new UserController(this);
                break;
            case 2:
                ctrl = new ModeratorController(this);
                break;
            case 3:
                ctrl = new AdminController(this);
                break;
            default:
                break;
        }
        ctrl.showMenu();
    }

    public void logout(){
        ctrl = null;
        userHandler = null;
        ui.printMessage("Du er nu logget ud!\n\n");
        login();
    }

    private void exitApplication(){
        ui.printMessage("Farvel !");
        System.exit(0);
    }
}
