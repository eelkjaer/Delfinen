/**
 @author Emil Elkjær Nielsen (cph-en93@cphbusiness.dk)
 **/
package Model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Member {
    private int id;
    private String name;
    private LocalDate birthday;
    private String email;
    private int phone;
    private Membership membership;

    public Member(int id, String name, LocalDate birthday, String email, int phone, Membership membership) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.phone = phone;
        this.membership = membership;
    }

    public Member getMemberByID(int id, ArrayList<Member> list){
        for(Member m:list){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public int calculateAge() {
        if (this.birthday != null) {
            return Period.between(this.birthday, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
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
                '}';
    }
}
