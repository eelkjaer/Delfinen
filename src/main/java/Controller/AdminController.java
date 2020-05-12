package Controller;

import Model.Member;
import Model.Membership;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class AdminController extends MainController {
    BaseController base;
    public AdminController(BaseController base){
        this.base = base;
    }
    @Override
    public void showMenu() {
        refreshData();
        ui.printMenu("Tilmeld medlem;Rediger medlem;Slet medlem;Se restancer;Se kontigenter;Ændre kontigenter;Se Top 5 - Junior;Se Top 5 - Senior;Log ud;Print alle objekter");
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
            case 10: //ONLY FOR DEVELOPMENT
                objectTesting();
                showMenu();
            default:
                ui.printMessage(select + " findes ikke!\n");
                showMenu();
        }
    }

    /**
     * Opretter nyt medlem
     **/
    private void registerNewMember(){
        ui.printMessage("Opret nyt medlem\n");

        ui.printMessage("\nIndtast medlemmets fulde navn: ");
        String name = ui.getStrInput();

        ui.printMessage("\nIndtast medlemmets fødselsdag (Format: dag-måned-år, ex. 30-12-2020): ");
        String birthday = ui.getStrInput();

        ui.printMessage("\nIndtast medlemmets e-mail: ");
        String email = ui.getStrInput();

        ui.printMessage("\nIndtast medlemmets telefonnummer: ");
        int phone = ui.getIntInput();

        int age = Period.between(LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd-MM-yyyy")), LocalDate.now()).getYears();

        ui.printMessage("\nMulige kontigenter: ");
        for(Membership ms: membershipHandler.getMemberships()){
            if(age <= 18 && !ms.getName().equals("Senior")){
                ui.printMessage("\n"+ms.getId() + ") " + ms.getName() + " - pris pr. år: " + ms.getPrice());
            } else if (age >= 18 && !ms.getName().equals("Junior")){
                ui.printMessage("\n"+ms.getId() + ") " + ms.getName() + " - pris pr. år: " + ms.getPrice());
            }
        }
        ui.printMessage("\nVælg hvilket kontigent brugeren ønsker: ");
        int membership = ui.getIntInput();

        int memberNumber = memberHandler.registerMember(name, birthday, email, phone, membership);

        ui.printMessage(String.format("%nNew member created!" +
                "%nMember number: %s%n" +
                "Member name: %s%n" +
                "Member email: %s%n" +
                "Member phone: %d%n", memberNumber, name,email,phone));

        showMenu();
    }

    /**
     * Ændre attributter på eksisterende medlem
     **/
    private void changeMember(){
            ui.printMessage("Indtast medlemsnummer: ");
            int memNo = ui.getIntInput();
            Member selectedMember = null;

            for (Member m : memberHandler.getMembers()) {
                if (m.getId() == memNo) {
                    selectedMember = m;
                }
            }
        assert selectedMember != null;
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
                    for(Membership ms: membershipHandler.getMemberships()){
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
            showMenu();
        //TODO: Kode
    }

    /**
     * Ændre attributter på eksisterende medlem
     **/
    private void deleteMember(){
        ui.printMessage("Indtast medlemsnummer: ");
        int memNo = ui.getIntInput();
        Member selectedMember = null;

        for (Member m : memberHandler.getMembers()) {
            if (m.getId() == memNo) {
                selectedMember = m;
            }
        }
        ui.printMessage("Er du sikker på at du vil slette følgende: \n");
        assert selectedMember != null;
        ui.printMessage(String.format("%nMember number: %s%nMember name: %s%n", selectedMember.getId(),selectedMember.getName()));
        System.out.println("Skriv Y/y for JA eller N/n for NEJ: ");
        String confirmInput = ui.getStrInput();
        if(confirmInput.toLowerCase().equals("y")){
            if(memberHandler.deleteMember(selectedMember.getId())){
                ui.printMessage("Medlemmet blev slettet!\n");
                showMenu();
            } else {
                ui.printMessage("Der opstod en fejl!\n");
                deleteMember();
            }
        } else {
            ui.printMessage("Handlingen blev stoppet!\n");
            showMenu();
        }
    }


}
