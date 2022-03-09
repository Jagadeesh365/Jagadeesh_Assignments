package in.Question3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestBankAccount {

	@Test
	void TestbalanceWithdraw() {
		BankAccount wd = new BankAccount();
		assertThrows(InsufficientFundsExpcetion.class, () -> wd.withdraw(21000),
				"Should throw exception if balance is less than the withdrawl amount");
	}
}
