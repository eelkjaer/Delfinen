package Data;

import Model.Member;
import Model.Membership;
import Model.Result;

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

    public ArrayList<Membership> getMemberships() {
        return memberships;
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

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public String showTopSwimmers(String filter){
        HashMap<Result,Member> tmpMap = getTopSwimmers(filter);
        String printStr = "";

        for(Result r: tmpMap.keySet()){
            printStr += r.toString();
        }
        return printStr;
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
