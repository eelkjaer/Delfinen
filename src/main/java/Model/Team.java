package Model;

import java.util.ArrayList;

public class Team {
    private int id;
    private String name;
    private User coach;
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
}
