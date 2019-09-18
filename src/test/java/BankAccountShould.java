import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankAccountShould {
    private CustomDate operationDate;

    @Before
    public void setUp() throws Exception {
        operationDate = new OperationDate();
    }

    @Test
    public void haveA0CashBalanceAtCreation(){
        BankAccount bankAccount = new BankAccount(operationDate);

        assertEquals(0.0, bankAccount.getCashBalance());
    }

    @Test
    public void haveACashBalancePlusTheAmountDeposited(){
        BankAccount bankAccount = new BankAccount(operationDate);
        double amount = 3000.0;
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getCashBalance());
    }

    @Test
    public void haveInitialAmountLessAmountWithdrawed() {
        double initialCashBalance = 3000.0;
        double withrawnAmount = 600.0;
        BankAccount bankAccount = new BankAccount(operationDate);
        bankAccount.deposit(initialCashBalance);

        bankAccount.withdraw(withrawnAmount);

        assertEquals(initialCashBalance-withrawnAmount,bankAccount.getCashBalance());
    }

    @Test
    public void notWithdrawMoreThanCashBalance() {
        double initialCashBalance = 400.0;
        double withrawnAmount = 600.0;
        BankAccount bankAccount = new BankAccount(operationDate);
        bankAccount.deposit(initialCashBalance);

        bankAccount.withdraw(withrawnAmount);

        assertEquals(0, bankAccount.getCashBalance());
    }

    @Test
    public void saveTheHistoryOperationTypeWhenADepositIsMade() {
        double initialCahsBalance = 0.0;
        double amount = 500.0;
        BankAccount bankAccount = new BankAccount(operationDate);

        bankAccount.deposit(amount);

        assertTrue(bankAccount.getHistory().get(0).contains("OperationType:"+OperationType.DEPOSIT));
    }

    @Test
    public void saveTheHistoryDateWhenADepositIsMade() {
        LocalDateTime operationLocalDateTime = LocalDateTime.now();
        String operationDateString = operationLocalDateTime.toString();
        CustomDate operationDateMock = new OperationDateMock(operationLocalDateTime);
        double amount = 500.0;
        BankAccount bankAccount = new BankAccount(operationDateMock);

        bankAccount.deposit(amount);

        assertTrue(bankAccount.getHistory().get(0).contains("Date:"+operationDateString));
    }

    @Test
    public void saveTheAmountInHistoryWhenADepositIsMade() {
        double amount = 500.0;
        BankAccount bankAccount = new BankAccount(operationDate);

        bankAccount.deposit(amount);

        assertTrue(bankAccount.getHistory().get(0).contains("Amount:"+amount));
    }

    @Test
    public void saveTheNewCashBalanceToWhenADepositIsMade() {
        double depositedAmount = 500.0;
        BankAccount bankAccount = new BankAccount(operationDate);
        double initialCashBalance = bankAccount.getCashBalance();

        bankAccount.deposit(depositedAmount);

        assertTrue(bankAccount.getHistory().get(0).contains("CashBalance:"+(initialCashBalance+depositedAmount)));
    }

    @Test
    public void saveHistoryOfAllDepositsWhenEachIsDone() {
        double firstDepositedAmount = 500.0;
        double secondDepositedAmount = 800.0;
        BankAccount bankAccount = new BankAccount(operationDate);

        bankAccount.deposit(firstDepositedAmount);
        bankAccount.deposit(secondDepositedAmount);

        assertTrue(bankAccount.getHistory().get(0).contains("OperationType:"+OperationType.DEPOSIT));
        assertTrue(bankAccount.getHistory().get(1).contains("OperationType:"+OperationType.DEPOSIT));
    }
}
