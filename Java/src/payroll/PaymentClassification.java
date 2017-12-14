package payroll;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class PaymentClassification {
    public abstract double calculatePay(Date date);

    public abstract boolean isPayDate(Date date);
}

class HourlyClassification extends PaymentClassification {
    double hourlyRate;
    List<TimeCard> timeCards;

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
        timeCards = new LinkedList<TimeCard>();
    }

    @Override
    public boolean isPayDate(Date date) {
        return isFriday(date);
    }

    private boolean isFriday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DAY_OF_WEEK);
        return day == Calendar.FRIDAY;
    }

    @Override
    public double calculatePay(Date date) {
        return 0; // TODO
    }

    public void addTimeCard(TimeCard card) {
        timeCards.add(card);
    }

    @Override
    public String toString() {
        String result = "H(" + hourlyRate + ")";
        for (TimeCard card: timeCards) {
            result += "\n   " + card;
        }
        return result;
    }
}

class SalariedClassification extends PaymentClassification {
    double salary;

    public SalariedClassification(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean isPayDate(Date date) {
        return isLastDayOfMonth(date);
    }

    @Override
    public double calculatePay(Date date) {
        return salary;
    }

    private boolean isLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        c.add(Calendar.DATE, 1);
        Date nextDay = c.getTime();
        int nextDaysMonth = c.get(Calendar.MONTH);

        return month != nextDaysMonth;
    }

    @Override
    public String toString() {
        return "S(" + salary + ")";
    }
}

class CommissionedClassification extends PaymentClassification {
    double salary;
    double commissionRate;
    List<SalesReceipt> salesReceipts;

    public CommissionedClassification(double salary, double commissionRate) {
        this.salary = salary;
        this.commissionRate = commissionRate;
        salesReceipts = new LinkedList<SalesReceipt>();
    }

    @Override
    public boolean isPayDate(Date date) {
        return isBiweeklyFriday(date);
    }

    private boolean isBiweeklyFriday(Date date) {
        Calendar c = Calendar.getInstance();
        c.set(2001, 11, 9);
        Date firstPayableFriday = c.getTime();
        long days = TimeUnit.DAYS.toDays(date.getTime() - firstPayableFriday.getTime());

        return days % 14 == 0;
    }

    @Override
    public double calculatePay(Date date) {
        return 0; // TODO
    }

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceipts.add(salesReceipt);
    }

    @Override
    public String toString() {
        String result = "C(" + salary + ", " + commissionRate + ")";
        for (SalesReceipt receipt: salesReceipts) {
            result += "\n   " + receipt;
        }
        return result;
    }
}


