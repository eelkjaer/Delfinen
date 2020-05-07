package Model;

import java.util.Date;

public class Member {
    private int id;
    private String name;
    private Date birthyear;
    private String email;
    private int phone;
    private boolean active;
    private Membership membership;
    private Team team;

    public Member(int id, String name, Date birthyear, String email, int phone, boolean active, Membership membership, Team team) {
        this.id = id;
        this.name = name;
        this.birthyear = birthyear;
        this.email = email;
        this.phone = phone;
        this.active = active;
        this.membership = membership;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthyear() {
        return birthyear;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
