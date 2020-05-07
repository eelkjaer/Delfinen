package Controller;
import Data.*;
import Model.*;
import View.*;

import java.util.ArrayList;

abstract public class MainController {
    //Abstrakte ting til nedarvning
    /*
     * Viser menuen vha. UI til brugeren
     */
    public abstract void showMenu();

    //Variabler til controlleren
    public ArrayList<User> users;
    public ArrayList<Member> members;
    public ArrayList<Membership> memberships;
    public ArrayList<Result> results;
    public ArrayList<Payment> payments;
    public ArrayList<Competition> competitions;
    public ArrayList<Team> teams;

    UI ui = new UI();

    //Fælles metoder

    /**
     * Viser top 5 svømmere indenfor hver kategori
     */
    public void showTop(){

    }

    public void refreshData(){
        users = new UserMapper().getUsers();
        memberships = new MembershipMapper().getMemberships();
        members = new MemberMapper().getAllMembers(memberships);
        payments = new PaymentMapper().getAllPayments(members);
        competitions = new CompetitionMapper().getCompetitions();
        results = new ResultMapper().getResults(members,competitions);
        teams = new TeamMapper().getTeams(members, users);
    }

    public void logout(){
        System.out.println("Du er logget ud!");
        System.exit(0);
    }



}
