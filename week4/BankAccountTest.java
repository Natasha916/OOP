package week4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccountTest {
	 @Test
	    public void testDeposit() {
	        BankAccount account = new BankAccount();
	        account.deposit(100.0);
	        assertEquals(100.0, account.getBalance(), 0.001);
	    }

	    @Test
	    public void testWithdrawSuccessful() {
	        BankAccount account = new BankAccount();
	        account.deposit(100.0);
	        boolean result = account.withdraw(50.0);
	        assertTrue(result);
	        assertEquals(50.0, account.getBalance(), 0.001);
	    }

	    @Test
	    public void testWithdrawFailsDueToInsufficientBalance() {
	        BankAccount account = new BankAccount();
	        account.deposit(100.0);
	        boolean result = account.withdraw(50.0);
	        assertTrue(result);
	        assertEquals(50.0, account.getBalance(), 0.001);

	        result = account.withdraw(60.0);

	        assertFalse(result);
	        assertEquals(50.0, account.getBalance(), 0.001);
	    }

}
