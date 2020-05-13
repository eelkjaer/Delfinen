/**
 @author Mohammed Hadra (cph-mh879@cphbusiness.dk)
 **/
package Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Payment {
    private int id;
    private Member member;
    private double paid;
    private LocalDate timestamp;

    public Payment(int id, Member member, double paid, LocalDate timestamp) {
        this.id = id;
        this.member = member;
        this.paid = paid;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", member=" + member +
                ", paid=" + paid +
                ", timestamp=" + timestamp +
                '}';
    }
}
