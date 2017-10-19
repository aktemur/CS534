package bankAccount.v0;

public class Main {
    public static void main(String[] args) {
        int account1number = 1;
        double account1balance = 100;
        String account1currency = "TL";

        int account2number = 2;
        double account2balance = 200;
        String account2currency = "USD";

        System.out.println("Account " + account1number
                + " has " + account1balance
                + " " + account1currency + ".");
        System.out.println("Account " + account2number
                + " has " + account2balance
                + " " + account2currency + ".");

        // Deposit 50TL into account 1
        account1balance = account1balance + 50;

        // Deposit 300 USD into account 2
        account2balance = account2balance + 300;

        System.out.println("Account " + account1number
                + " has " + account1balance
                + " " + account1currency + ".");
        System.out.println("Account " + account2number
                + " has " + account2balance
                + " " + account2currency + ".");
    }
}
