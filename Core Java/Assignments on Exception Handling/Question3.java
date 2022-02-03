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
			SA.SavingDeposit(deposit,id);
			break;
		}
		case 2:
		{    
			System.out.print("kindly Enter ID:");
			long id=sc.nextLong();
			System.out.print("kindly Enter Withdraw Amount:");
			double withdraw=sc.nextDouble();
			SA.SavingWithdraw(withdraw, id);
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
