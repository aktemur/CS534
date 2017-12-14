package payroll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TransactionParser {

    public Transaction parse(String cmd) {
        Scanner scanner = new Scanner(cmd);
        String opCode = scanner.next();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if (opCode.equals("AddEmp")) { // USE CASE 1
                int empId = scanner.nextInt();
                String name = scanner.next();
                String address = scanner.next();
                String type = scanner.next();
                if (type.equals("H")) {
                    double hourlyRate = scanner.nextDouble();
                    return new AddHourlyEmpTransaction(empId, name, address, hourlyRate);
                } else if (type.equals("S")) {
                    double monthlySalary = scanner.nextDouble();
                    return new AddSalariedEmpTransaction(empId, name, address, monthlySalary);
                } else if (type.equals("C")) {
                    double monthlySalary = scanner.nextDouble();
                    double commissionRate = scanner.nextDouble();
                    return new AddCommissionedEmpTransaction(empId, name, address, monthlySalary, commissionRate);
                }
            } else if (opCode.equals("DelEmp")) { // USE CASE 2
                int empId = scanner.nextInt();
                return new DelEmpTransaction(empId);
            } else if (opCode.equals("TimeCard")) { // USE CASE 3
                int empId = scanner.nextInt();
                Date date = dateFormat.parse(scanner.next());
                double hours = scanner.nextDouble();
                return new TimeCardTransaction(empId, date, hours);
            } else if (opCode.equals("SalesReceipt")) { // USE CASE 4
                int empId = scanner.nextInt();
                Date date = dateFormat.parse(scanner.next());
                double amount = scanner.nextDouble();
                return new SalesReceiptTransaction(empId, date, amount);
            } else if (opCode.equals("ServiceCharge")) { // USE CASE 5
                int memberId = scanner.nextInt();
                Date date = dateFormat.parse(scanner.next());
                double amount = scanner.nextDouble();
                return new ServiceChargeTransaction(memberId, date, amount);
            } else if (opCode.equals("ChgEmp")) { // USE CASE 6
                int empId = scanner.nextInt();
                String field = scanner.next();
                if (field.equals("Name")) {
                    String name = scanner.next();
                    return new ChangeEmpNameTransaction(empId, name);
                } else if (field.equals("Hourly")) {
                    double hourlyRate = scanner.nextDouble();
                    return new ChangeEmpHourlyTransaction(empId, hourlyRate);
                } else if (field.equals("Salaried")) {
                    double salary = scanner.nextDouble();
                    return new ChangeEmpSalariedTransaction(empId, salary);
                } else if (field.equals("Commissioned")) {
                    double salary = scanner.nextDouble();
                    double rate = scanner.nextDouble();
                    return new ChangeEmpCommissionedTransaction(empId, salary, rate);
                } else if (field.equals("Hold")) {
                    return new ChangeEmpHoldTransaction(empId);
                } else if (field.equals("Direct")) {
                    String bank = scanner.next();
                    int account = scanner.nextInt();
                    return new ChangeEmpDirectTransaction(empId, bank, account);
                } else if (field.equals("Mail")) {
                    String address = scanner.next();
                    return new ChangeEmpMailTransaction(empId, address);
                } else if (field.equals("Member")) {
                    int memberId = scanner.nextInt();
                    double rate = scanner.nextDouble();
                    return new ChangeEmpMemberTransaction(empId, memberId, rate);
                } else if (field.equals("NoMember")) {
                    return new ChangeEmpNoMemberTransaction(empId);
                }
            } else if (opCode.equals("Payday")) { // USE CASE 7
                Date date = dateFormat.parse(scanner.next());
                return new PaydayTransaction(date);
            } else if (opCode.equals("DisplayEmp")) { // EXTRA USE CASE FOR DEBUGGING
                int empId = scanner.nextInt();
                return new DisplayEmpTransaction(empId);
            }
            return new InvalidTransaction();
        } catch (Exception e) {
            return new InvalidTransaction();
        }
    }

}
