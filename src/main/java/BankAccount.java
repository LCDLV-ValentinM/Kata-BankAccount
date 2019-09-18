import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private double cashBalance;
    private List<String> historyLine;
    private CustomDate operationDate;

    public BankAccount(CustomDate operationDate) {
        historyLine = new ArrayList<>();
        this.operationDate = operationDate;
        cashBalance = 0.0;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void deposit(double amount) {
        cashBalance += amount;

        addHistoryLine(OperationType.DEPOSIT, amount);
    }

    public void withdraw(double amount) {
        if(cashBalance < amount) {
            cashBalance = 0;
        } else {
            cashBalance -= amount;
        }
        addHistoryLine(OperationType.WITHDRAW, amount);
    }

    public List<String> getHistory() {
        return Collections.unmodifiableList(historyLine);
    }

    private void addHistoryLine(OperationType operationType, double amount) {
        historyLine.add(
                "OperationType:" + operationType + ", "
                        + "Date:" + operationDate.now() + ", "
                        + "Amount:" + amount + ", "
                        + "CashBalance:" + cashBalance
        );
    }
}
