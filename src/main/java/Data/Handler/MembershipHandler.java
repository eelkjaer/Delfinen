/**
 @author Mohammed Hadra (cph-mh879@cphbusiness.dk)
 @author Andreas Bergmann (cph-ab435@cphbusiness.dk)
 **/
package Data.Handler;

import Data.Mapper.*;
import Model.Membership;

import java.util.ArrayList;

public class MembershipHandler {
    private final MembershipMapper memberMapper = new MembershipMapper();
    private ArrayList<Membership> memberships;

    public ArrayList<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(ArrayList<Membership> memberships) {
        this.memberships = memberships;
    }

    public void updateMemberships(){
        this.memberships = memberMapper.getMemberships();
    }

    public String showMemberships() {
        StringBuilder str = new StringBuilder();
        for(Membership m: memberships){
            str.append("\n Kontigentets navn: ").append(m.getName()).append("\n Kontigentets pris: ").append(m.getPrice()).append(" kr pr. År\n");
        }
        return str.toString();
    }
}
