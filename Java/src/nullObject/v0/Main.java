package nullObject.v0;

public class Main {
    public static void main(String[] args) {
        for (int id = 1000; id < 1300; id++) {
            Employee e = Database.findEmployeeById(id);
            if (e != null && e.isTimeToPay()) {
                e.pay();
            }
        }
    }
}
