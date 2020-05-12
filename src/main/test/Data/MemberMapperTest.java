package Data;

import Data.Handler.*;
import Model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class MemberMapperTest {
    protected UserHandler userHandler = new UserHandler();
    protected MemberHandler memberHandler = new MemberHandler();
    protected MembershipHandler membershipHandler = new MembershipHandler();
    protected PaymentHandler paymentHandler = new PaymentHandler();
    protected CompetitionHandler competitionHandler = new CompetitionHandler();
    protected ResultHandler resultHandler = new ResultHandler();
    protected TeamHandler teamHandler = new TeamHandler();
    Member actualMember;
    //ArrayList<Member> members;
   // ArrayList<Membership> memberships;
    @BeforeEach
    public void setUp(){
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

    @Test
    public void getID(){
        System.out.println(membershipHandler.getMemberships());
        /*
        int expected = 90631;
        actualMember = members.get(90631);
        assertEquals(expected, members);
        */
    }
}
