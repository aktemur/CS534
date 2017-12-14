package payroll;

import java.util.Date;

public class TimeCard {
    Date date;
    double hours;

    public TimeCard(Date date, double hours) {
        this.date = date;
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "TimeCard(" + date + ", " + hours + ")";
    }
}
