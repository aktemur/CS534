package payroll;

import java.util.Date;

public class ServiceCharge {
    Date date;
    double amount;

    public ServiceCharge(Date date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ServiceCharge(" + date + ", " + amount + ")";
    }
}
