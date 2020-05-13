package Data.Handler;

import Data.Mapper.*;
import Model.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MemberHandler {
    private final MemberMapper memberMapper = new MemberMapper();
    private ArrayList<Membership> memberships;
    private ArrayList<Member> members;
    private ArrayList<Result> results;

    public MemberHandler(){

    }

    public Member getMemberById(int id){
        for(Member m:members){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public void updateMembers(ArrayList<Membership> memberships){
        this.memberships = memberships;
        this.members = memberMapper.getAllMembers(this.memberships);
    }

    public void setMemberships(ArrayList<Membership> memberships) {
        this.memberships = memberships;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public boolean addMember(Member member){
        if(!this.members.contains(member) || member != null){
            this.members.add(member);
            return true;
        }
        return false;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }


    public void updateMember(Member member){
        members.set(members.indexOf(member),memberMapper.editMember(member));
    }

    /**
     * @param id Medlemsnummer
     * @return true if deleted from list and DB
     */
    public boolean deleteMember(int id){
        return memberMapper.deleteMember(id) && members.removeIf(m -> m.getId() == id);
    }

    /**
     * @param name Members full name
     * @param birthday Format: dd-mm-yyyy (ex. 30-12-2020)
     * @param email Members email
     * @param phone Members phone number
     * @param membership Desired memberships ID
     * @return membership number
     */
    public int registerMember(String name, String birthday, String email, int phone, int membership){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate bday = LocalDate.parse(birthday,formatter);

        Membership selectedMembership = null;
        for(Membership ms: memberships){
            if(ms.getId() == membership){
                selectedMembership = ms;
            }
        }
        if(selectedMembership == null){
            assert selectedMembership != null;
            selectedMembership.setId(3);
        }

        Member tmpMember = memberMapper.createNewMember(name, bday,email,phone,selectedMembership);
        addMember(tmpMember);
        return tmpMember.getId();
    }

    /**
     * @param filter "junior" or "senior"
     * @return string with top swimmers
     */
    public String showTopSwimmers(String filter){
        HashMap<Result,Member> tmpMap = getTopSwimmers(filter);
        StringBuilder printStr = new StringBuilder();

        for(Result r: tmpMap.keySet()){
            printStr.append(r.toString());
        }
        return printStr.toString();
    }

    private HashMap<Result,Member> getTopSwimmers(String filter){
        HashMap<Result,Member> tmpMap = new LinkedHashMap<>();
        int[] resultids = memberMapper.getTopFive(filter);
        for (int resultid : resultids) {
            for (Result r : results) {
                if (r.getId() == resultid) {
                    tmpMap.put(r, r.getMember());
                }
            }
        }
        return tmpMap;
    }


}
