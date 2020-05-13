/**
 @author Emil Elkjær Nielsen (cph-en93@cphbusiness.dk)
 @author Jacob Lange Nielsen (cph-jn352@cphbusiness.dk)
 **/
package Controller;

public class UserController extends MainController {
    private final BaseController base;
    public UserController(BaseController base){
        this.base = base;
    }
    @Override
    public void showMenu() {
        refreshData();
        ui.printMenu("Tilføj Resultat;Tilføj stævne;Se Top 5 - Junior;Se Top 5 - Senior;Log ud");
        int select = ui.getIntInput();
        switch (select){
            case 1:
                //Tilføj resultat
                addResult();
            case 2:
                // Tilføj nyt stævne
                addNewCompetition();
            case 3:
                // Se top 5 junior
                showTop("junior");
            case 4:
                // Se top 5 senior
                showTop("senior");
            case 5:
                base.logout();
                break;
            default:
                ui.printMessage(select + " findes ikke!\n");
                showMenu();
        }
    }
}
