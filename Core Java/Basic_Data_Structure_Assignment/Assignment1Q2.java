/*Q2. Find out all the Armstrong numbers falling in the range of 100-999

Description :-

An Armstrong number of three digits is an integer, where the sum of the cubes of its digits is equal to the number itself.

Consider the example: 371=> 3^3 + 7^3 + 1^3 = 371 ( If you add those all numbers, the final digit should be same as given number ).

Find the Armstrong numbers between 100 to 999.

Test cases:      

              Output : 153 370 371 407 
  */
class ArmstrongNumBetweenRange{
    public int []  armstrongNumbersInRange(int min , int max){
    	int j=0;
    	int list[]=new int[4];
		for(int start=min;start<=max;start++)
		{
			   int num=start;
			   int result = 0;
		       for(num=start;num != 0;num=num/10)
		       { 
		    	 
		           int remainder = num%10;
		            result = result + remainder*remainder*remainder;
		            
	           	} 
		       if(result==start)
		       {         
		                list[j]=start;
		                j++;      	     
	         	}
		}
		 
		return list;	
    }
}

public class Assignment1Q2 {
    public static void main (String [] args) {

       int min = 100;
       int max = 999;
       ArmstrongNumBetweenRange obj=new ArmstrongNumBetweenRange();
       System.out.print("Armstrong numbers from "+min+" to "+max+" are: ");
       int amstrongList[]=obj.armstrongNumbersInRange(min, max);
       for(int i=0;i<amstrongList.length;i++)
       {
    	   System.out.print(amstrongList[i]+" ");
       }
       

    }
}