package nullObject.v0;

public class Database {
    public static Employee findEmployeddById(int id) {
        if (id == 1234) {
            return new Employee("John");
        } else {
            return null;
        }
    }
}
