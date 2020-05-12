package Data;

import Model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class MemberMapperTest {
    public ArrayList<User> users;
    public ArrayList<Member> members;
    public ArrayList<Membership> memberships;
    public ArrayList<Result> results;
    public ArrayList<Payment> payments;
    public ArrayList<Competition> competitions;
    public ArrayList<Team> teams;
    MemberMapper memberMapper = new MemberMapper();
    MembershipMapper membershipMapper = new MembershipMapper();
    Member actualMember;
    //ArrayList<Member> members;
   // ArrayList<Membership> memberships;
    @BeforeEach
    public void setUp(){
        users = new UserMapper().getUsers();
        memberships = new MembershipMapper().getMemberships();
        members = new MemberMapper().getAllMembers(memberships);
        payments = new PaymentMapper().getAllPayments(members);
        competitions = new CompetitionMapper().getCompetitions();
        results = new ResultMapper().getResults(members,competitions);
        teams = new TeamMapper().getTeams(members, users);
        memberships = membershipMapper.getMemberships();
        members = memberMapper.getAllMembers(memberships);
    }

    @Test
    public void getID(){
        System.out.println(memberships);
        /*
        int expected = 90631;
        actualMember = members.get(90631);
        assertEquals(expected, members);
        */
    }
}
