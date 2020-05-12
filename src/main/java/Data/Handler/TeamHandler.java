package Data.Handler;

import Data.Mapper.*;
import Model.*;

import java.util.ArrayList;

public class TeamHandler {
    private final TeamMapper teamMapper = new TeamMapper();
    private ArrayList<Team> teams;

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void updateResults(ArrayList<Member> members, ArrayList<User> users) {
        this.teams = teamMapper.getTeams(members,users);
    }
}
