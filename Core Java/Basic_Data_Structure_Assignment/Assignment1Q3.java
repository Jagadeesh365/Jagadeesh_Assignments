
import java.util.*;
class SiCi {
    public double simpleInterest(double principalAmount,int time,double interestRate)
    {
    	return principalAmount*time*interestRate/100;
    }
    public double compoundInterest(double principalAmount,int time,double interestRate)
    {
    	return principalAmount*(Math.pow((1 + interestRate / 100), time));
    }
}
public class Assignment1Q3 {
    public static void main (String args[]) {
    SiCi obj=new SiCi();
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter principal Amount: ");
    double principalAmount=sc.nextDouble();
    System.out.println("Enter Time:");
    int time=sc.nextByte();
    System.out.println("Enter InterestRate:");
    double interestRate=sc.nextDouble();
    
    double sp=obj.simpleInterest(principalAmount,time,interestRate);
    double cp=obj.compoundInterest(principalAmount,time,interestRate);
    System.out.println("Princial Amoubt:"+principalAmount+" Time:"+time+" Interest Rate:"+interestRate+" Simple Intetest:"+(sp)+" After "+time+" years is "+(principalAmount+sp));
    System.out.println("Compount Amoubt:"+principalAmount+" Time:"+time+" Interest Rate:"+interestRate+" Compount Intetest:"+(cp-principalAmount)+" After "+time+" years is "+(cp));
  }
}