/*Q1: Find out if the given number is an Armstrong number or not. 

Description :-

An Armstrong number of three digits is an integer, where the sum of the cubes of its digits is equal to the number itself.

Consider the example: 371=> 3^3 + 7^3 + 1^3 = 371 ( If you add those all numbers, the final digit should be same as given number ).
*/
class ArmstrongOrNot

{
	public boolean armstrongCheck(int num) {
		int result = 0;
		int orig = num;
		for(int orgin =num;num != 0;num=num/10)
		{ 
		int remainder = num%10;
		result = result + remainder*remainder*remainder;
		} 
		if(result==orig)
		{
			return true;
		}
		else
		{
			return false;
		}

		
	}
}
public class Assignment1Q1 {

	public static void main(String[] args) {
		ArmstrongOrNot obj=new ArmstrongOrNot();
		int number=371;
		if(obj.armstrongCheck(number))
		{
			System.out.println("Number : " + number + " is an Armstrong number");

			
		}
		else
		{
			System.out.println("Number : " + number + " is not Armstrong number");

			
		}
        
	}

}
