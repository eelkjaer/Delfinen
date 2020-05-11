package Data;

import Model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class PaymentHandler {
    private PaymentMapper paymentMapper = new PaymentMapper();
    private ArrayList<Member> members;
    private ArrayList<Payment> payments;

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public String showMissingPayments(){
        return paymentMapper.getMissingPayments();
    }
}
