/**
 @author Emil Elkjær Nielsen (cph-en93@cphbusiness.dk)
 **/
package Controller;
import Data.Handler.*;
import Model.*;
import View.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract public class MainController {
    //Abstrakte ting til nedarvning
    public abstract void showMenu();


    //Klasser til brug i controlleren
    protected final UI ui = new UI();
    protected final UserHandler userHandler = new UserHandler();
    protected final MemberHandler memberHandler = new MemberHandler();
    protected final MembershipHandler membershipHandler = new MembershipHandler();
    protected final PaymentHandler paymentHandler = new PaymentHandler();
    protected final CompetitionHandler competitionHandler = new CompetitionHandler();
    protected final ResultHandler resultHandler = new ResultHandler();
    protected final TeamHandler teamHandler = new TeamHandler();

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

    public void addNewCompetition() {

        String pattern = "yyyy-MM-dd";

        ui.printMessage("Opret nyt stævne\n");

        ui.printMessage("\nIndtast stævnets navn");
        String name = ui.getStrInput();

        ui.printMessage("\nIndtast placering");
        String location = ui.getStrInput();

        ui.printMessage("\nIndtast dato for stævnet (som her: 2020-06-19)");
        String datetime = ui.getStrInput();
        String stringtest = "2020-06-19";
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        LocalDate newdate = LocalDate.parse(datetime,df);

        competitionHandler.addToCompetitions(competitionHandler.addNewCompetition(name,location,newdate));

        ui.printMessage(String.format("%nNyt stævne tilføjet!" +
                "Stævnets navn: %s%n" +
                "Stævnets placering: %s%n" +
                "Stævnets start: %s%n",  name, location, datetime));

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
