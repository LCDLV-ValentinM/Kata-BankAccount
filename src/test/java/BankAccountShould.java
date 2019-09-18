import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
