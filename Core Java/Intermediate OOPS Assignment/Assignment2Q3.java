import java.util.*;
class CurrentAccount extends Assignment2Q3 {
    int totalDeposits = 10000;
    int creditLimit = 2000;
    @Override
    public int getCash() {
    	return totalDeposits-creditLimit;
    }
}
class SavingsAccount extends Assignment2Q3 {
    int totalDeposits = 10000;
    int fixedDepositAmount = 5000;
    @Override
    public int getCash() {
    	return totalDeposits+fixedDepositAmount;
    }
}
public class Assignment2Q3 {
	
    public int totalCashInBank(ArrayList<Integer> cash){
    	 int sum=0;
		 for(int i: cash)
		 {
			 sum=sum+i;
		 }
		 return sum;
    	
    }
    public int getCash(){
    	return 0;
    }
    public static void main(String[] args) {
    	Assignment2Q3 Account =new Assignment2Q3();
		ArrayList<Integer> Cash = new ArrayList<Integer>();
		CurrentAccount Caccount = new CurrentAccount();
		System.out.println(Caccount.getCash());
		SavingsAccount Saccount = new SavingsAccount();
		System.out.println(Saccount.getCash());
		Cash.add(Caccount.getCash());
		Cash.add(Saccount.getCash());
		System.out.println(Account.totalCashInBank(Cash));
    }
}

