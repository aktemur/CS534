package nullObject.v0;

public class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public boolean isTimeToPay() {
        // Check the calendar, the history of the employee, etc...
        return true;
    }

    public void pay() {
        System.out.println("Paying money to " + name + ".");
    }
}
