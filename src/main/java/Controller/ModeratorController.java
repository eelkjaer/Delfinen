package Controller;
import Model.*;

public class ModeratorController extends MainController {
    BaseController base;
    public ModeratorController(BaseController base){
        this.base = base;
    }
    @Override
    public void showMenu() {
        refreshData();
        ui.printMenu("Se restancer;Se kontigenter;Log ud");
        int select = ui.getIntInput();
        switch (select){
            case 1:
                //Se restance
                showMissingPayments();
            case 2:
                showContingents();
            case 3:
                base.logout();
                break;
            default:
                ui.printMessage(select + " findes ikke!\n");
                showMenu();
        }
    }
}
