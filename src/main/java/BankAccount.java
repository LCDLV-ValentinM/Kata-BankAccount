public class BankAccount {
    private double cashBalance;
    private String historyLine;
    private CustomDate operationDate;

    public BankAccount(CustomDate operationDate) {
        this.operationDate = operationDate;
        cashBalance = 0.0;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void deposit(double amount) {
        cashBalance += amount;
        historyLine = "OperationType:" + OperationType.DEPOSIT + ", "
                      + "Date:" + operationDate.now() + ", "
                      + "Amount:" + amount
        ;
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
