package nullObject.v1;

public class Main {
    public static void main(String[] args) {
        IEmployee e = Database.findEmployeddById(1234);
        if (e.isTimeToPay()) {
            e.pay();
        }

        e = Database.findEmployeddById(9999);
        if (e.isTimeToPay()) {
            e.pay();
        }
    }
}
