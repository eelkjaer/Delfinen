package Data;

import Model.Member;
import java.util.ArrayList;

public class MemberMapper {
    /*
     * Henter alle medlemmer fra SQL
     * Opretter Member objekter
     * Tilføjer dem til en midlertidig ArrayList som bliver retuneret
     */
    protected ArrayList<Member> getAllMembers(){
        ArrayList<Member> tmpMembers = new ArrayList<>();

        return tmpMembers;
    }

    /*
     * Indsætter nyt Member objekt i SQL og retunerer dette med korrekt id
     */
    protected Member createNewMember(Member member){
        Member tmpMember = member;

        return tmpMember;
    }

    /*
     * Ændre data i SQL på medlemmet.
     */
    protected Member editMember(int id){

        return null;
    }

    /*
     * Sletter valgt medlem fra SQL
     */
    protected boolean deleteMember(int id){
        return false;
    }
}
