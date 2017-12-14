package payroll;

public class Payment {
    private final Employee employee;
    private final double amount;

    public Payment(Employee employee, double amount) {
        this.employee = employee;
        this.amount = amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public double getAmount() {
        return amount;
    }
}
