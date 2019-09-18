public class BankAccount {
    private double cashBalance;

    public BankAccount() {
        cashBalance = 0.0;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void deposit(double amount) {
        cashBalance += amount;
    }

    public void withdraw(double amount) {
        if(cashBalance < amount) {
            cashBalance = 0;
        } else {
            cashBalance -= amount;
        }
    }
}
