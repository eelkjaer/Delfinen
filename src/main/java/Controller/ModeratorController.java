package Controller;
import Model.*;
import View.UI;

public class ModeratorController extends MainController {
    BaseController base;
    public ModeratorController(BaseController base){
        this.base = base;
    }
    @Override
    public void showMenu() {
        super.refreshData();
        ui.printMessage("Velkommen kassere!\n");
        ui.printMenu("Se restancer;Se kontigenter;Ændre kontigenter;Log ud");
        int select = ui.getIntInput();
        switch (select){
            case 1:
                //Se restance
                showMissingPayments();
                showMenu();
            case 2:
                //Se kontigenter
                showMenu();
            case 3:
                //Ændre kontingenter
                showMenu();
            case 4:
                base.logout();
                break;
            default:
                ui.printMessage(select + " findes ikke!\n");
                showMenu();
        }
    }

    /*
     * Viser en liste over medlemmer med restance
     */
    public void showMissingPayments(){
        //TODO: Kode

        /* FOR DEVELOPMENT PURPOSES */
        for(Membership ms:super.memberships){
            System.out.println(ms);
        }

        for(Member m:super.members)
        {
            System.out.println(m);
        }

        for(Payment p: super.payments){
            System.out.println(p);
        }
        /* END TEST */

        String query = "SELECT Members.Name AS \"Swimmer\", Memberships.Name AS \"Membership\", (Payments.Paid - Memberships.Price) AS \"Restance\"\n" +
                "FROM Members\n" +
                "INNER JOIN Memberships ON Memberships.ID = Members.Membership\n" +
                "INNER JOIN Payments ON Payments.MemberID = Members.ID\n" +
                "WHERE (Payments.Paid - Memberships.Price) < 0 OR (Payments.Paid - Memberships.Price) > 0";

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
