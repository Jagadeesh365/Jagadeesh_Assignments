/*
   1)Write an application that accepts two numbers, divides the first number with the second
     number and display the result. Hint: You need to handle ArithmeticException which is
     thrown when there is an attempt to divide a number by zero. 
*/
import java.util.*;
public class Question1 {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter Dividend:");
	int dividend=sc.nextInt();
	
	System.out.print("Enter Divisor:");
	int divisor=sc.nextInt();
	
	  try
	  {
		  System.out.println("Quotient:"+ ( dividend/divisor )); //Risky code 
	  }
	  catch (ArithmeticException e)
	  {
		  System.out.println("Hello! you can't divide number by 0"); //Handling code 
	  }
	  finally {
			sc.close();  //closeupCode 
		}
	}

}
