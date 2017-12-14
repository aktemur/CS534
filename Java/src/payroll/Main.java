package payroll;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static TransactionParser parser = new TransactionParser();

    public static void main(String[] args) {
        // Populate the DB with some data for convenience
        parser.parse("AddEmp 1 Baris Istanbul S 1000").execute();
        parser.parse("AddEmp 2 Bob Chicago H 150").execute();
        parser.parse("AddEmp 3 Lukas Berlin C 600 0.10").execute();
        parser.parse("AddEmp 4 Mary NewYork S 2000").execute();

        while (true) {
            System.out.print("> ");
            String cmd = scanner.nextLine();
            Transaction transaction = parser.parse(cmd);
            transaction.execute();
        }
    }

}
