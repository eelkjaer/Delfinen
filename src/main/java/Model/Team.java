/**
 @author Andreas Bergmann (cph-ab435@cphbusiness.dk)
 **/
package Model;

import java.util.ArrayList;

public class Team {
    private final int id;
    private final String name;
    private final User coach;
    private ArrayList<Member> teamMembers;

    public Team(int id, String name, User coach, ArrayList<Member> teamMembers) {
        this.id = id;
        this.name = name;
        this.coach = coach;
        this.teamMembers = teamMembers;
    }

    public Team(int id, String name, User coach) {
        this.id = id;
        this.name = name;
        this.coach = coach;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coach=" + coach +
                ", teamMembers=" + teamMembers +
                '}';
    }
}
