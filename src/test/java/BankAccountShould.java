import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BankAccountShould {
    private CustomDate operationDate;

    @Before
    public void setUp() {
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
    public void haveInitialAmountLessAmountWithdrawn() {
        double initialCashBalance = 3000.0;
        double withdrawnAmount = 600.0;
        BankAccount bankAccount = new BankAccount(operationDate);
        bankAccount.deposit(initialCashBalance);

        bankAccount.withdraw(withdrawnAmount);

        assertEquals(initialCashBalance-withdrawnAmount,bankAccount.getCashBalance());
    }

    @Test
    public void notWithdrawMoreThanCashBalance() {
        double initialCashBalance = 200.0;
        double withdrawnAmount = 400.0;
        BankAccount bankAccount = new BankAccount(operationDate);
        bankAccount.deposit(initialCashBalance);

        bankAccount.withdraw(withdrawnAmount);

        assertEquals(0, bankAccount.getCashBalance());
    }

    @Test
    public void saveTheHistoryOperationTypeWhenADepositIsMade() {
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

    @Test
    public void saveTheHistoryOperationTypeWhenAWithdrawIsMade() {
        double initialCashBalance = 4000.0;
        double withdrawnAmount = 600.0;
        BankAccount bankAccount = new BankAccount(operationDate);
        bankAccount.deposit(initialCashBalance);

        bankAccount.withdraw(withdrawnAmount);

        assertTrue(bankAccount.getHistory().get(1).contains("OperationType:"+OperationType.WITHDRAW));
    }

    @Test
    public void saveTheHistoryDateWhenAWithdrawIsMade() {
        LocalDateTime operationLocalDateTime = LocalDateTime.now();
        String operationDateString = operationLocalDateTime.toString();
        CustomDate operationDateMock = new OperationDateMock(operationLocalDateTime);
        double initialCashBalance = 400.0;
        double withdrawnAmount = 200.0;
        BankAccount bankAccount = new BankAccount(operationDateMock);
        bankAccount.deposit(initialCashBalance);

        bankAccount.withdraw(withdrawnAmount);

        assertTrue(bankAccount.getHistory().get(1).contains("Date:"+operationDateString));
    }

    @Test
    public void saveTheAmountInHistoryWhenAWithdrawIsMade() {
        double initialCashBalance = 8000.0;
        double withdrawnAmount = 600.0;
        BankAccount bankAccount = new BankAccount(operationDate);
        bankAccount.deposit(initialCashBalance);

        bankAccount.withdraw(withdrawnAmount);

        assertTrue(bankAccount.getHistory().get(1).contains("Amount:"+withdrawnAmount));
    }

    @Test
    public void saveTheNewCashBalanceToWhenAWithdrawIsMade() {
        double initialCashBalance = 2500.0;
        double withdrawnAmount = 600.0;
        BankAccount bankAccount = new BankAccount(operationDate);
        bankAccount.deposit(initialCashBalance);

        bankAccount.withdraw(withdrawnAmount);

        assertTrue(bankAccount.getHistory().get(1).contains("CashBalance:"+(initialCashBalance-withdrawnAmount)));
    }

    @Test
    public void saveTheNew0CashBalanceToWhenAWithdrawIsMadeGivenNotEnoughCashBalance() {
        double initialCashBalance = 100.0;
        double withdrawnAmount = 300.0;
        BankAccount bankAccount = new BankAccount(operationDate);
        bankAccount.deposit(initialCashBalance);

        bankAccount.withdraw(withdrawnAmount);

        assertTrue(bankAccount.getHistory().get(1).contains("CashBalance:"+0));
    }

    @Test
    public void saveHistoryOfAllWithdrawnWhenEachIsDone() {
        double firstDepositedAmount = 5000.0;
        BankAccount bankAccount = new BankAccount(operationDate);
        bankAccount.deposit(firstDepositedAmount);
        double firstWithdrawnAmount = 600.0;
        double secondWithdrawnAmount = 700.0;

        bankAccount.withdraw(firstWithdrawnAmount);
        bankAccount.withdraw(secondWithdrawnAmount);

        assertTrue(bankAccount.getHistory().get(1).contains("OperationType:"+OperationType.WITHDRAW));
        assertTrue(bankAccount.getHistory().get(2).contains("OperationType:"+OperationType.WITHDRAW));
    }
}
