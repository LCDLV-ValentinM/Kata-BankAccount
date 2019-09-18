import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankAccountShould {

    @Test
    public void haveA0CashBalanceAtCreation(){
        BankAccount bankAccount = new BankAccount();
        assertEquals(0.0, bankAccount.getCashBalance());
    }

    @Test
    public void haveACashBalancePlusTheAmountDeposited(){
        BankAccount bankAccount = new BankAccount();
        double amount = 3000.0;
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getCashBalance());
    }

    @Test
    public void haveInitialAmountLessAmountWithdrawed() {
        double initialCashBalance = 3000.0;
        double withrawnAmount = 600.0;
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(initialCashBalance);
        bankAccount.withdraw(withrawnAmount);
        assertEquals(initialCashBalance-withrawnAmount,bankAccount.getCashBalance());
    }

    @Test
    public void notWithdrawMoreThanCashBalance() {
        double initialCashBalance = 400.0;
        double withrawnAmount = 600.0;
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(initialCashBalance);
        bankAccount.withdraw(withrawnAmount);
        assertEquals(0, bankAccount.getCashBalance());
    }

    @Test
    public void saveTheHistoryOperationTypeWhenADepositIsMade() {
        double initialCahsBalance = 0.0;
        double amount = 500.0;
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(amount);
        assertTrue(bankAccount.getHistory().contains("OperationType:Deposit"));
    }
}
