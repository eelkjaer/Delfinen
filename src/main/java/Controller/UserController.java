package Controller;
import Model.*;
import View.UI;

public class UserController extends MainController {
    @Override
    public void showMenu() {
        //TODO: Menu layout
        ui.printToConsole("Velkommen træner!\n");
        ui.printMenu("Se Top 5 - Junior;Se Top 5 - Senior;Log ud");
    }
}
