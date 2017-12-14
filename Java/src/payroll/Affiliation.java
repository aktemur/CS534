package payroll;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public interface Affiliation {
    double calculateDeductions(Date date);
}

class UnionAffiliation implements Affiliation {
    int memberId;
    double rate;
    List<ServiceCharge> serviceCharges;

    public UnionAffiliation(int memberId, double rate) {
        this.memberId = memberId;
        this.rate = rate;
        serviceCharges = new LinkedList<ServiceCharge>();
    }

    @Override
    public double calculateDeductions(Date date) {
        return 0; // TODO
    }

    public void addServiceCharge(ServiceCharge serviceCharge) {
        serviceCharges.add(serviceCharge);
    }

    public int getMemberId() {
        return memberId;
    }

    public double getRate() {
        return rate;
    }

    public List<ServiceCharge> getServiceCharges() {
        return serviceCharges;
    }

    @Override
    public String toString() {
        String result = "UnionMember(" + memberId + ", " + rate + ")";
        for (ServiceCharge charge: serviceCharges) {
            result += "\n   " + charge;
        }
        return result;
    }
}

class NoAffiliation implements Affiliation {
    @Override
    public String toString() {
        return "NoMember";
    }

    @Override
    public double calculateDeductions(Date date) {
        return 0;
    }
}
