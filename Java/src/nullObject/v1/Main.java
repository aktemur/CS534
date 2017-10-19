package nullObject.v1;

public class Main {
    public static void main(String[] args) {
        for (int i = 1000; i < 1300; i++) {
            IEmployee e = Database.findEmployeddById(i);
            if (e.isTimeToPay()) {
                e.pay();
            }
        }
    }
}
