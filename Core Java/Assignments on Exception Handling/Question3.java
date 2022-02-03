/*
3) Write an application to perform withdraw functionality on a SavingAccount object. Point to
note:
a. Raise InsufficientBalanceException if you are trying to withdraw more than balance
or when you balance is zero. E.g. if you balance is 2000 and if you are trying to
withdraw 2100 or if you balance is 0 and you are trying to withdraw positive value.
b. Raise IllegalBankTransactionException if you are trying to withdraw a negative value
from your balance. E.g. if you try to withdraw a negative value savingAcc.withdraw(-
1000);
Note: SavingAccount
 |-- long id
 |-- double balance
 |--double withdraw(double amount)
 |--double deposit(double amount)
 */
import java.util.*;
class InsufficientBalanceException extends RuntimeException{
	public InsufficientBalanceException(String s) {
		super(s);
	}
}
class IllegalBankTransactionException extends RuntimeException{
	public IllegalBankTransactionException(String s) {
		super(s);
	}
}
class SvaingAcoount
{
	long id;
	double balance;
	public SvaingAcoount(){
		this.balance=28000;
	}
	public double  SavingDeposit(double deposit, long id2) {
		
      return balance+=deposit;
		 
	}
     public double SavingWithdraw(double withdraw, long id2) {
		
    	 if(withdraw>balance || balance==0)
			{
				throw new InsufficientBalanceException("You can't withdraw more than the amount present in your account");
			}
    	 else if(withdraw<0)
			{
				throw new IllegalBankTransactionException("You can't withdraw negative amount");
			}
			return balance-=withdraw;
	}
 
}
public class Question3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		SvaingAcoount SA=new SvaingAcoount();
		
		while(true) 
		{
		System.out.print("1.Deposit\n2.Withdraw\n3.Exit\nSelect Option: ");
		int choose=sc.nextInt();
		switch(choose)
		{
		case 1:
		{   
			
			System.out.print("kindly Enter ID:");
			long id=sc.nextLong();
			System.out.print("kindly Enter Deposit Amount:");
			double deposit=sc.nextDouble();
			System.out.println("Total balance is: "+SA.SavingDeposit(deposit,id));
			break;
		}
		case 2:
		{    
			System.out.print("kindly Enter ID:");
			long id=sc.nextLong();
			System.out.print("kindly Enter Withdraw Amount:");
			double withdraw=sc.nextDouble();
			System.out.println("Total balance is: "+SA.SavingWithdraw(withdraw, id));
			break;
		}
		case 3:
		{
			System.exit(0);
		}
		default:
			System.out.println("select only [1-3]");
		}
	    }
	}

}
