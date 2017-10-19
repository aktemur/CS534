package nullObject.v0;

public class Main {
    public static void main(String[] args) {
        Employee e = Database.findEmployeddById(1234);
        if (e != null && e.isTimeToPay()) {
            e.pay();
        }

        e = Database.findEmployeddById(9999);
        if (e != null && e.isTimeToPay()) {
            e.pay();
        }
    }
}
