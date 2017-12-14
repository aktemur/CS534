package payroll;

import java.util.Collection;
import java.util.Date;

public interface Transaction {
    public void execute();
}

abstract class AddEmpTransaction implements Transaction {
    int empId;
    String name;
    String address;

    public AddEmpTransaction(int empId, String name, String address) {
        this.empId = empId;
        this.name = name;
        this.address = address;
    }

    @Override
    public void execute() {
        Employee emp = new Employee(empId, name, address);
        emp.setPaymentClassification(getClassification());
        emp.setPaymentMethod(new HoldMethod());
        PayrollDatabase.addEmployee(emp);
    }

    protected abstract PaymentClassification getClassification();
}

class AddHourlyEmpTransaction extends AddEmpTransaction {
    double hourlyRate;

    public AddHourlyEmpTransaction(int empId, String name, String address, double hourlyRate) {
        super(empId, name, address);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(hourlyRate);
    }
}

class AddSalariedEmpTransaction extends AddEmpTransaction {
    double monthlySalary;

    public AddSalariedEmpTransaction(int empId, String name, String address, double monthlySalary) {
        super(empId, name, address);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(monthlySalary);
    }
}

class AddCommissionedEmpTransaction extends AddEmpTransaction {
    double monthlySalary;
    double commissionRate;

    public AddCommissionedEmpTransaction(int empId, String name, String address, double monthlySalary, double commissionRate) {
        super(empId, name, address);
        this.monthlySalary = monthlySalary;
        this.commissionRate = commissionRate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification(monthlySalary, commissionRate);
    }
}

class DelEmpTransaction implements Transaction {
    int empId;

    public DelEmpTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        PayrollDatabase.deleteEmployeeWithId(empId);
    }
}

class TimeCardTransaction implements Transaction {
    int empId;
    Date date;
    double hours;

    public TimeCardTransaction(int empId, Date date, double hours) {
        this.empId = empId;
        this.date = date;
        this.hours = hours;
    }

    @Override
    public void execute() {
        Employee emp = PayrollDatabase.findEmployeeWithId(empId);
        PaymentClassification classification = emp.getPaymentClassification();
        HourlyClassification hourlyClassification = (HourlyClassification) classification;
        hourlyClassification.addTimeCard(new TimeCard(date, hours));
    }
}

class SalesReceiptTransaction implements Transaction {
    int empId;
    Date date;
    double amount;

    public SalesReceiptTransaction(int empId, Date date, double amount) {
        this.empId = empId;
        this.date = date;
        this.amount = amount;
    }

    @Override
    public void execute() {
        Employee emp = PayrollDatabase.findEmployeeWithId(empId);
        PaymentClassification classification = emp.getPaymentClassification();
        CommissionedClassification commissionedClassification = (CommissionedClassification) classification;
        commissionedClassification.addSalesReceipt(new SalesReceipt(date, amount));
    }
}

class ServiceChargeTransaction implements Transaction {
    int memberId;
    Date date;
    double amount;

    public ServiceChargeTransaction(int memberId, Date date, double amount) {
        this.memberId = memberId;
        this.date = date;
        this.amount = amount;
    }

    @Override
    public void execute() {
        Employee emp = PayrollDatabase.findEmployeeWithMemberId(memberId);
        Affiliation affiliation = emp.getAffiliation();
        UnionAffiliation unionAffiliation = (UnionAffiliation)affiliation;
        unionAffiliation.addServiceCharge(new ServiceCharge(date, amount));
    }
}

abstract class ChangeEmpTransaction implements Transaction {
    int empId;

    public ChangeEmpTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee emp = PayrollDatabase.findEmployeeWithId(empId);
        if (emp != null)
            change(emp);
        else
            System.out.println("No such employee found!");
    }

    protected abstract void change(Employee emp);
}

class ChangeEmpNameTransaction extends ChangeEmpTransaction {
    String name;

    public ChangeEmpNameTransaction(int empId, String name) {
        super(empId);
        this.name = name;
    }

    @Override
    protected void change(Employee emp) {
        emp.setName(name);
    }
}

class ChangeEmpHourlyTransaction extends ChangeEmpTransaction {
    double hourlyRate;

    public ChangeEmpHourlyTransaction(int empId, double hourlyRate) {
        super(empId);
        this.hourlyRate = hourlyRate;
    }

    @Override
    protected void change(Employee emp) {
        emp.setPaymentClassification(new HourlyClassification(hourlyRate));
    }
}

class ChangeEmpSalariedTransaction extends ChangeEmpTransaction {
    double salary;

    public ChangeEmpSalariedTransaction(int empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    protected void change(Employee emp) {
        emp.setPaymentClassification(new SalariedClassification(salary));
    }
}

class ChangeEmpCommissionedTransaction extends ChangeEmpTransaction {
    double salary;
    double rate;

    public ChangeEmpCommissionedTransaction(int empId, double salary, double rate) {
        super(empId);
        this.salary = salary;
        this.rate = rate;
    }

    @Override
    protected void change(Employee emp) {
        emp.setPaymentClassification(new CommissionedClassification(salary, rate));
    }
}

class ChangeEmpHoldTransaction extends ChangeEmpTransaction {
    public ChangeEmpHoldTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee emp) {
        emp.setPaymentMethod(new HoldMethod());
    }
}

class ChangeEmpDirectTransaction extends ChangeEmpTransaction {
    String bank;
    int account;

    public ChangeEmpDirectTransaction(int empId, String bank, int account) {
        super(empId);
        this.bank = bank;
        this.account = account;
    }

    @Override
    protected void change(Employee emp) {
        emp.setPaymentMethod(new DirectTransferMethod(bank, account));
    }
}

class ChangeEmpMailTransaction extends ChangeEmpTransaction {
    String address;

    public ChangeEmpMailTransaction(int empId, String address) {
        super(empId);
        this.address = address;
    }

    @Override
    protected void change(Employee emp) {
        emp.setPaymentMethod(new MailMethod(address));
    }
}

class ChangeEmpMemberTransaction extends ChangeEmpTransaction {
    int memberId;
    double rate;

    public ChangeEmpMemberTransaction(int empId, int memberId, double rate) {
        super(empId);
        this.memberId = memberId;
        this.rate = rate;
    }

    @Override
    protected void change(Employee emp) {
        emp.setAffiliation(new UnionAffiliation(memberId, rate));
        PayrollDatabase.addMembership(memberId, empId);
    }
}

class ChangeEmpNoMemberTransaction extends ChangeEmpTransaction {
    public ChangeEmpNoMemberTransaction(int empId) {
        super(empId);
    }

    @Override
    protected void change(Employee emp) {
        UnionAffiliation unionAffiliation = (UnionAffiliation)emp.getAffiliation();
        int memberId = unionAffiliation.getMemberId();
        emp.setAffiliation(new NoAffiliation());
        PayrollDatabase.removeMembership(memberId);
    }
}

class PaydayTransaction implements Transaction {
    Date date;

    public PaydayTransaction(Date date) {
        this.date = date;
    }

    @Override
    public void execute() {
        Collection<Employee> employees = PayrollDatabase.getAllEmployees();
        for (Employee employee: employees) {
            employee.pay(date);
        }
    }
}

class DisplayEmpTransaction implements Transaction {
    private int empId;

    public DisplayEmpTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute() {
        Employee emp = PayrollDatabase.findEmployeeWithId(empId);
        System.out.println(emp);
    }
}

class InvalidTransaction implements Transaction {
    @Override
    public void execute() {
        System.out.println("! Transaction could not be parsed.");
    }
}



