package Controller;
import Model.*;
import View.UI;

public class UserController extends MainController {
    BaseController base;
    public UserController(BaseController base){
        this.base = base;
    }
    @Override
    public void showMenu() {
        ui.printToConsole("Velkommen træner!\n");
        ui.printMenu("Se Top 5 - Junior;Se Top 5 - Senior;Log ud");
        int select = ui.getIntInput();
        switch (select){
            case 1:
                // Se top 5 junior
                showMenu();
            case 2:
                // Se top 5 senior
                showMenu();
            case 3:
                base.logout();
                break;
            default:
                ui.printToConsole(select + " findes ikke!\n");
                showMenu();
        }
    }
}
