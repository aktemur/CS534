package nullObject.v1;

public class Employee implements IEmployee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public boolean isTimeToPay() {
        // Check the calendar, the history of the employee, etc...
        return true;
    }

    @Override
    public void pay() {
        System.out.println("Paying money to " + name + ".");
    }
}
