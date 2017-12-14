package payroll;

public interface PaymentMethod {

    void sendPayment(Payment payment);
}

class HoldMethod implements PaymentMethod {
    @Override
    public String toString() {
        return "Hold";
    }

    @Override
    public void sendPayment(Payment payment) {
        double amount = payment.getAmount();
        Employee employee = payment.getEmployee();
        System.out.println("Holding " + amount + " TL for "
                + employee.getName() + "(" + employee.getId() + ")"
                + " at the HR office.");
    }
}

class MailMethod implements PaymentMethod {
    String address;

    public MailMethod(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Mail";
    }

    @Override
    public void sendPayment(Payment payment) {
        double amount = payment.getAmount();
        Employee employee = payment.getEmployee();
        System.out.println("Mailing " + amount + " TL for "
                + employee.getName() + "(" + employee.getId() + ")"
                + " to address: " + address);
    }
}

class DirectTransferMethod implements PaymentMethod {
    String bank;
    int accountNumber;

    public DirectTransferMethod(String bank, int accountNumber) {
        this.bank = bank;
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Direct";
    }

    @Override
    public void sendPayment(Payment payment) {
        double amount = payment.getAmount();
        Employee employee = payment.getEmployee();
        System.out.println("Transferring " + amount + " TL to "
                + bank + "(#" + accountNumber + ") for "
                + employee.getName() + "(" + employee.getId() + ").");
    }
}