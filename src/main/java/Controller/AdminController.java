package Controller;
import Model.*;

public class AdminController extends MainController {
    @Override
    public void showMenu() {
        ui.printToConsole("Velkommen admin!\n");
        ui.printMenu("Tilmeld medlem;Rediger medlem;Slet medlem;Se restancer;Se kontigenter;Ændre kontigenter;Se Top 5 - Junior;Se Top 5 - Senior;Log ud");
        int select = ui.getIntInput();
        switch (select){
            case 1:
                //tilmeld
                break;
            case 2:
                //rediger
                break;
            case 3:
                //slet
                break;
                //todo: tilføj resten
            default:
                showMenu();
        }
    }

    /*
     * Opretter nyt medlem
     */
    private void registerNewMember(){
        //TODO: Kode
    }

    /*
     * Ændre attributter på eksisterende medlem
     */
    private void changeMember(){
        //TODO: Kode
    }

    /*
     * Ændre attributter på eksisterende medlem
     */
    private void deleteMember(){
        //TODO: Kode
    }


}
