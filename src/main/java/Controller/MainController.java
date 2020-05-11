package Controller;
import Data.*;
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
    public ArrayList<Member> members;
    public ArrayList<Membership> memberships;
    public ArrayList<Result> results;
    public ArrayList<Payment> payments;
    public ArrayList<Competition> competitions;
    public ArrayList<Team> teams;



    //Klasser til brug i controlleren
    MemberHandler memberHandler = new MemberHandler();

    protected UI ui = new UI();
    protected UserMapper userMapper = new UserMapper();
    protected MembershipMapper membershipMapper = new MembershipMapper();
    protected MemberMapper memberMapper = new MemberMapper();
    protected PaymentMapper paymentMapper = new PaymentMapper();
    protected CompetitionMapper competitionMapper = new CompetitionMapper();
    protected ResultMapper resultMapper = new ResultMapper();
    protected TeamMapper teamMapper = new TeamMapper();

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
     * Viser en lister over restancer
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
        memberships = membershipMapper.getMemberships();
        members = memberMapper.getAllMembers(memberships);
        payments = paymentMapper.getAllPayments(members);
        competitions = competitionMapper.getCompetitions();
        results = resultMapper.getResults(members,competitions);
        teams = teamMapper.getTeams(members, users);
        memberHandler.setMembers(members);
        memberHandler.setMemberships(memberships);
        memberHandler.setResults(results);
    }

}
