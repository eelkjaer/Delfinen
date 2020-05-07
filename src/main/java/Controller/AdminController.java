package Controller;

public class AdminController extends MainController {
    BaseController base;
    public AdminController(BaseController base){
        this.base = base;
    }
    @Override
    public void showMenu() {
        ui.printMessage("Velkommen admin!\n");
        ui.printMenu("Tilmeld medlem;Rediger medlem;Slet medlem;Se restancer;Se kontigenter;Ændre kontigenter;Se Top 5 - Junior;Se Top 5 - Senior;Log ud");
        int select = ui.getIntInput();
        switch (select){
            case 1:
                //tilmeld
                showMenu();
            case 2:
                //rediger
                showMenu();
            case 3:
                //slet
                showMenu();
            case 4:
                //Se restance
                showMenu();
            case 5:
                //Se kontigenter
                showMenu();
            case 6:
                //Ændre kontingenter
                showMenu();
            case 7:
                // Se top 5 junior
                showMenu();
            case 8:
                // Se top 5 senior
                showMenu();
            case 9:
                base.logout();
                break;
            default:
                ui.printMessage(select + " findes ikke!\n");
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
