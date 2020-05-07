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
        for(Competition c: competitions){
            System.out.println(c);
        }

        for(Member m: members){
            System.out.println(m);
        }

        for(Membership ms: memberships){
            System.out.println(ms);
        }

        for(Payment p: payments){
            System.out.println(p);
        }

        for(Result r: results){
            System.out.println(r);
        }

        for(Team t: teams){
            System.out.println(t);
        }

        for(User u: users){
            System.out.println(u);
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
