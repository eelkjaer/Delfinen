import Controller.*;
import Model.User;

public class Main {

    public static void main(String[] args) {
        MainController ctrl;
        User user = new User("admin","admin",3);

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
