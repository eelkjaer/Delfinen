/**
 @author Emil Elkjær Nielsen (cph-en93@cphbusiness.dk)
 @author Mohammed Hadra (cph-mh879@cphbusiness.dk)
 @author Jacob Lange Nielsen (cph-jn352@cphbusiness.dk)
 **/
package Controller;

public class ModeratorController extends MainController {
    BaseController base;
    public ModeratorController(BaseController base){
        this.base = base;
    }
    @Override
    public void showMenu() {
        refreshData();
        ui.printMenu("Se restancer;Se kontigenter;Tilføj betaling;Log ud");
        int select = ui.getIntInput();
        switch (select){
            case 1:
                //Se restance
                showMissingPayments();
            case 2:
                showContingents();
            case 3:
                //Tilføj betaling
                addNewPayment();
            case 4:
                base.logout();
                break;
            default:
                ui.printMessage(select + " findes ikke!\n");
                showMenu();
        }
    }
}
