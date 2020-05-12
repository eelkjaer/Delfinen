package Controller;
import Data.Handler.*;
import Model.*;
import View.*;


abstract public class MainController {
    //Abstrakte ting til nedarvning
    /**
     * Viser menuen vha. UI til brugeren
     **/
    public abstract void showMenu();


    //Klasser til brug i controlleren
    protected UI ui = new UI();
    protected  UserHandler userHandler = new UserHandler();
    protected MemberHandler memberHandler = new MemberHandler();
    protected MembershipHandler membershipHandler = new MembershipHandler();
    protected PaymentHandler paymentHandler = new PaymentHandler();
    protected CompetitionHandler competitionHandler = new CompetitionHandler();
    protected ResultHandler resultHandler = new ResultHandler();
    protected TeamHandler teamHandler = new TeamHandler();

    //Fælles metoder

    public void objectTesting(){
        /* FOR DEVELOPMENT PURPOSES */
        for(Competition c: competitionHandler.getCompetitions()){
            System.out.println(c);
        }

        for(Member m: memberHandler.getMembers()){
            System.out.println(m);
        }

        for(Membership ms: membershipHandler.getMemberships()){
            System.out.println(ms);
        }

        for(Payment p: paymentHandler.getPayments()){
            System.out.println(p);
        }

        for(Result r: resultHandler.getResults()){
            System.out.println(r);
        }

        for(Team t: teamHandler.getTeams()){
            System.out.println(t);
        }

        for(User u: userHandler.getUsers()){
            System.out.println(u);
        }
        /* END TEST */
    }


    /**
     * @param filter Viser top 5 under følgende filtre: "junior" eller "senior"
     */
    public void showTop(String filter){
        ui.printMessage("Show top 5 " + filter);
        ui.printMessage(memberHandler.showTopSwimmers(filter));
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
     * Ændre kontingentsatserne
     **/
    public void changeContingents(){
        //TODO: Kode

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
