package Controller;
import Data.Handler.*;
import Model.*;
import View.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


abstract public class MainController {
    //Abstrakte ting til nedarvning
    /**
     * Viser menuen vha. UI til brugeren
     **/
    public abstract void showMenu();


    //Klasser til brug i controlleren
    protected UI ui = new UI();
    protected UserHandler userHandler = new UserHandler();
    protected MemberHandler memberHandler = new MemberHandler();
    protected MembershipHandler membershipHandler = new MembershipHandler();
    protected PaymentHandler paymentHandler = new PaymentHandler();
    protected CompetitionHandler competitionHandler = new CompetitionHandler();
    protected ResultHandler resultHandler = new ResultHandler();
    protected TeamHandler teamHandler = new TeamHandler();

    //Fælles metoder
    /**
     * @param filter Viser top 5 under følgende filtre: "junior" eller "senior"
     */
    public void showTop(String filter){
        ui.printMessage("Show top 5 " + filter);
        ui.printMessage(memberHandler.showTopSwimmers(filter));
        showMenu();
    }

    /**
     *
     */
    public void addNewPayment(){
        ui.printMessage("Tilføj ny betaling\n");

        ui.printMessage("\nIndtast medlemmets id: ");
        int id = ui.getIntInput();
        Member paymentMember = memberHandler.getMemberById(id);

        ui.printMessage("\nIndtast det indbetalte beløb (decimaltal): ");
        double paid = ui.getDoubleInput();


        Payment tmpPayment = paymentHandler.addNewPayment(paymentMember,paid);
        paymentHandler.addPayment(tmpPayment);

        ui.printMessage("\nNyt resultat tilføjet! Betalings-ID: " + tmpPayment.getId() + "\n\n");

        showMenu();
    }

    /**
     * Viser en lister over restancer
     */
    public void showMissingPayments(){
        ui.printMessage(paymentHandler.showMissingPayments());
        showMenu();
    }

    /**
     * Viser de nuværende kontigentsatser
     **/
    public void showContingents(){
        ui.printMessage(membershipHandler.showMemberships());

        showMenu();
    }

    /**
     * Tilføjer nyt resultat
     **/

    public void addResult(){
        ui.printMessage("Tilføj nyt resultat\n");

        ui.printMessage("\nIndtast medlemmets id: ");
        int id = ui.getIntInput();
        Member resultMember = memberHandler.getMemberById(id);

        ui.printMessage("\nVælg en af følgende dicipliner: ");
        ui.printMessage("\n1) Crawl");
        ui.printMessage("\n2) Butterfly");
        ui.printMessage("\n3) Rygcrawl");
        ui.printMessage("\n4) Brystsvømning");
        ui.printMessage("\n Indtast dit valg: ");
        int diciplin = ui.getIntInput();

        ui.printMessage("\nDer er følgende stævner:");

        for(Competition c: competitionHandler.getCompetitions()){
            ui.printMessage("\n\nID: " + c.getId() + "\nNavn: " + c.getName()+"\n");
        }

        ui.printMessage("\nIndtast stævne ID: ");
        int competitionid = ui.getIntInput();
        Competition resultCompetition = competitionHandler.getCompetitionById(competitionid);

        ui.printMessage("\nIndtast svømmetiden i sekunder (decimaltal): ");
        double resulttime = ui.getDoubleInput();

        ui.printMessage("\nVar det en træningstid? (ja/nej): ");
        String training = ui.getStrInput().toLowerCase();


        Result tmpResult = resultHandler.registerResult(resultMember,diciplin,resultCompetition,resulttime,training);
        resultHandler.addResult(tmpResult);

        ui.printMessage("\nNyt resultat tilføjet!\n\n");

        showMenu();
    }

    public void refreshData(){
        userHandler.updateUsers();
        membershipHandler.updateMemberships();
        memberHandler.updateMembers(membershipHandler.getMemberships());
        paymentHandler.updatePayments(memberHandler.getMembers());
        competitionHandler.updateCompetitions();
        resultHandler.updateResults(memberHandler.getMembers(),competitionHandler.getCompetitions());
        teamHandler.updateResults(memberHandler.getMembers(),userHandler.getUsers());
        memberHandler.setMembers(memberHandler.getMembers());
        memberHandler.setMemberships(membershipHandler.getMemberships());
        memberHandler.setResults(resultHandler.getResults());
    }

}
