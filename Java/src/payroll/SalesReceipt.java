package payroll;

import java.util.Date;

public class SalesReceipt {
    Date date;
    double amount;

    public SalesReceipt(Date date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SalesReceipt(" + date + ", " + amount + ")";
    }
}
