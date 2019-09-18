import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountShould {

    @Test
    public void haveA0CashBalanceAtCreation(){
        BankAccount bankAccount = new BankAccount();
        assertEquals(0.0, bankAccount.getCashBalance());
    }
}
