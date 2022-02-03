/*
 2) Carrying forward with the above problem, handle ArithmeticException by raising
    UnsupportedOperationException as a solution. 
*/
import java.util.*;
public class Question2 {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter Dividend:");
	int dividend=sc.nextInt();
	
	System.out.print("Enter Divisor:");
	int divisor=sc.nextInt();
	
	  try
	  {
		  if(divisor==0)
		  {
			  
			  throw new UnsupportedOperationException("Divisor can't be 0");
		  }
		  System.out.println("Quotient:"+ ( dividend/divisor )); //Risky code 
	  }
	  catch (UnsupportedOperationException e)
	  {
		  System.out.print(e.getMessage()); //Handling code 
	  }
	  finally {
			sc.close();  //closeupCode 
		}
	}

}