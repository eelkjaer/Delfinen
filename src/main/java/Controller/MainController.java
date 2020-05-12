package Controller;
import Data.Handler.*;
import Data.Mapper.*;
import Model.*;
import View.*;

import java.util.ArrayList;

abstract public class MainController {
    //Abstrakte ting til nedarvning
    /**
     * Viser menuen vha. UI til brugeren
     **/
    public abstract void showMenu();

    //Variabler til controlleren
    public ArrayList<User> users;



    //Klasser til brug i controlleren
    protected MemberHandler memberHandler = new MemberHandler();
    protected MembershipHandler membershipHandler = new MembershipHandler();
    protected PaymentHandler paymentHandler = new PaymentHandler();
    protected CompetitionHandler competitionHandler = new CompetitionHandler();
    protected ResultHandler resultHandler = new ResultHandler();
    protected TeamHandler teamHandler = new TeamHandler();

    protected UI ui = new UI();
    protected UserMapper userMapper = new UserMapper();

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

        for(User u: users){
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
        //TODO: Kode

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
        users = userMapper.getUsers();
        membershipHandler.updateMemberships();
        memberHandler.updateMembers(membershipHandler.getMemberships());
        paymentHandler.updatePayments(memberHandler.getMembers());
        competitionHandler.updateCompetitions();
        resultHandler.updateResults(memberHandler.getMembers(),competitionHandler.getCompetitions());
        teamHandler.updateResults(memberHandler.getMembers(),users);
        memberHandler.setMembers(memberHandler.getMembers());
        memberHandler.setMemberships(membershipHandler.getMemberships());
        memberHandler.setResults(resultHandler.getResults());
    }

}
