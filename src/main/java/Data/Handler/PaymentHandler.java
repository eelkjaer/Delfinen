package Data.Handler;

import Data.Mapper.PaymentMapper;
import Model.*;

import java.util.ArrayList;

public class PaymentHandler {
    private final PaymentMapper paymentMapper = new PaymentMapper();
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

    public void updatePayments(ArrayList<Member> members){
        this.members = members;
        this.payments = paymentMapper.getAllPayments(this.members);
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public String showMissingPayments(){
        return paymentMapper.getMissingPayments();
    }
}
