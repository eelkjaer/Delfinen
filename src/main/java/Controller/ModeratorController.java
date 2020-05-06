package Controller;
import Model.*;

public class ModeratorController extends MainController {
    @Override
    protected void showMenu() {
        int select = 0;
        switch (select){
            case 1:
                System.out.println("valg 1");
                break;
            case 2:
                System.out.println("valg 2");
                break;
            default:
                System.out.println("intet valgt");
                showMenu();
        }
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
