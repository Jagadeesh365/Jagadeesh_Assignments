package in.Question3;

//3) Write a BankAccount class with method withdraw which accepts amount to be withdrawn
//from the account (amount to be deducted from the balance of the account). In case there
//are insufficient funds a InsufficientFundsExpcetion should be raised. After defining the
//method perform Junit testing to check whether the InsufficientFundsException is raised
//when you try to withdraw amount that is over and above the account balance.
//bankAccount.withdraw(20,000); should raise the InsufficientFundsException if the
//balance in the account is less than 20,000. 

@SuppressWarnings("serial")
class InsufficientFundsExpcetion extends Exception {

	public InsufficientFundsExpcetion(String string) {
		super(string);
	}
}

public class BankAccount {
	private int balance = 20000;

	public void withdraw(int amount) throws InsufficientFundsExpcetion {
		if (amount > balance) {
			throw new InsufficientFundsExpcetion("Insufficient funds");
		}
		balance = balance - amount;
	}

}
