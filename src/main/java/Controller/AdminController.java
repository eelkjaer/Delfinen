package Controller;

import Model.Member;
import Model.Membership;

public class AdminController extends MainController {
    BaseController base;
    public AdminController(BaseController base){
        this.base = base;
    }
    @Override
    public void showMenu() {
        refreshData();
        ui.printMenu("Tilmeld medlem;Rediger medlem;Slet medlem;Se restancer;Se kontigenter;Ændre kontigenter;Se Top 5 - Junior;Se Top 5 - Senior;Log ud");
        int select = ui.getIntInput();
        switch (select){
            case 1:
                //tilmeld
                registerNewMember();
            case 2:
                //rediger
                changeMember();
            case 3:
                //slet
                deleteMember();
            case 4:
                //Se restance
                showMissingPayments();
            case 5:
                //Se kontigenter
                showContingents();
            case 6:
                //Ændre kontingenter
                changeContingents();
            case 7:
                // Se top 5 junior
                showTop("junior");
            case 8:
                // Se top 5 senior
                showTop("senior");
            case 9:
                base.logout();
                break;
            default:
                ui.printMessage(select + " findes ikke!\n");
                showMenu();
        }
    }

    /**
     * Opretter nyt medlem
     **/
    private void registerNewMember(){
        //TODO: Kode

    }

    /**
     * Ændre attributter på eksisterende medlem
     **/
    private void changeMember(){
            ui.printMessage("Indtast medlemsnummer: ");
            int memNo = ui.getIntInput();
            Member selectedMember = null;

            for (Member m : members) {
                if (m.getId() == memNo) {
                    selectedMember = m;
                }
            }
            ui.printMessage(selectedMember.toString());
            ui.printMenu("Ændre E-mail;Ændre telefonnummer;Ændre medlemskab");
            int select = ui.getIntInput();
            switch (select){
                case 1:
                    ui.printMessage("Indtast ny email: ");
                    String newMail = ui.getStrInput();
                    selectedMember.setEmail(newMail);
                    break;
                case 2:
                    ui.printMessage("Indtast nyt telefonnummer: ");
                    int newNo = ui.getIntInput();
                    selectedMember.setPhone(newNo);
                    break;
                case 3:
                    ui.printMessage("Vælg nyt medlemsskab (id): ");
                    int msNo = ui.getIntInput();
                    Membership tmpMembership = selectedMember.getMembership();
                    for(Membership ms: memberships){
                        if(ms.getId() == msNo){
                            tmpMembership = ms;
                        }
                    }
                    selectedMember.setMembership(tmpMembership);
                    ui.printMessage(tmpMembership.getName() + " er valgt som nyt medlemsskab!\n");
                    break;
                default:
                    ui.printMenu("Ændre E-mail;Ændre telefonnummer;Ændre medlemskab");
                    select = ui.getIntInput();
            }
        //TODO: Kode
    }

    /**
     * Ændre attributter på eksisterende medlem
     **/
    private void deleteMember(){
        //TODO: Kode
    }


}
