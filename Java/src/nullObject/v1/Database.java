package nullObject.v1;

public class Database {
    public static IEmployee findEmployeddById(int id) {
        if (id == 1234) {
            return new Employee("John");
        } else {
            // NOTE: You can use the Singleton pattern here
            // E.g. NullEmployee.getInstance()
            return new NullEmployee();
        }
    }
}
