package Model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

public class Member {
    private int id;
    private String name;
    private LocalDate birthday;
    private String email;
    private int phone;
    private Membership membership;
    private Team team;

    public Member(int id, String name, LocalDate birthday, String email, int phone, Membership membership, Team team) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.membership = membership;
        this.team = team;
    }

    public Member(int id, String name, LocalDate birthday, String email, int phone, Membership membership) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.membership = membership;
    }

    public int getId() {
        return id;
    }

    public Member getMemberByID(int id, ArrayList<Member> list){
        for(Member m:list){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int calculateAge() {
        if (this.birthday != null) {
            return Period.between(this.birthday, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", membership=" + membership +
                ", team=" + team +
                '}';
    }
}
