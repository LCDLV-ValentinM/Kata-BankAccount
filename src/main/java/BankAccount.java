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
        historyLine.add(
            "OperationType:" + OperationType.DEPOSIT + ", "
            + "Date:" + operationDate.now() + ", "
            + "Amount:" + amount + ", "
            + "CashBalance:" + cashBalance
        );
    }

    public void withdraw(double amount) {
        if(cashBalance < amount) {
            cashBalance = 0;
        } else {
            cashBalance -= amount;
        }
    }

    public List<String> getHistory() {
        return Collections.unmodifiableList(historyLine);
    }
}
