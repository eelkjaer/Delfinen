package Controller;
import Model.*;
import View.UI;

public class ModeratorController extends MainController {
    @Override
    public void showMenu() {
        ui.printToConsole("Velkommen kassere!\n");
        ui.printMenu("Se restancer;Se kontigenter;Ændre kontigenter;Log ud");
        //TODO: Menu layout
    }

    /*
     * Viser en liste over medlemmer med restance
     */
    public void showMissingPayments(){
        //TODO: Kode
    }

    /*
     * Viser de nuværende kontigentsatser
     */
    public void showContingents(){
        //TODO: Kode
    }

    /*
     * Ændre kontingentsatserne
     */
    public void changeContingents(){
        //TODO: Kode
    }
}
