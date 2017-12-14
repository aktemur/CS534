package payroll;

import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private String address;
    private PaymentClassification paymentClassification;
    private PaymentMethod paymentMethod;
    private Affiliation affiliation;

    public Employee(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.affiliation = new NoAffiliation();
    }

    public void pay(Date date) {
        if (paymentClassification.isPayDate(date)) {
            double grossPay = paymentClassification.calculatePay(date);
            double deductions = affiliation.calculateDeductions(date);
            double netPay = grossPay - deductions;
            Payment payment = new Payment(this, netPay);
            paymentMethod.sendPayment(payment);
        }
    }

    public PaymentClassification getPaymentClassification() {
        return paymentClassification;
    }

    public void setPaymentClassification(PaymentClassification paymentClassification) {
        this.paymentClassification = paymentClassification;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return  "Id: " + id + "\n" +
                "Name: " + name + "\n" +
                "Classification: " + paymentClassification + "\n" +
                "Method: " + paymentMethod + "\n" +
                "Affiliation: " + affiliation;
    }
}
