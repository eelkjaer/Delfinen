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
}
