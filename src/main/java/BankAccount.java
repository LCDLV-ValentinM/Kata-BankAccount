public class BankAccount {
    private double cashBalance;
    private String historyLine;

    public BankAccount() {
        cashBalance = 0.0;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void deposit(double amount) {
        cashBalance += amount;
        historyLine = "OperationType:" + OperationType.DEPOSIT;
    }

    public void withdraw(double amount) {
        if(cashBalance < amount) {
            cashBalance = 0;
        } else {
            cashBalance -= amount;
        }
    }

    public String getHistory() {
        return historyLine;
    }
}
