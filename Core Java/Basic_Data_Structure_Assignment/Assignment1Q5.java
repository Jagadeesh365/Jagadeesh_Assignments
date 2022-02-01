import java.util.*;
class TaxAmount{
    public double calculateTaxAmount(int ctc){
    			if(ctc<=180000)
    	    	{
    	    		
    	    		return ctc;
    	    	}
    	    	else if(ctc>=181001 && ctc<=300000)
    	    	{
    	    		return ctc*10/100;
    	    		
    	    	}
    	    	else if(ctc>=300001 && ctc<=500000)
    	    	{
    	    		return ctc*20/100;
    	    	}
    	    	else if(ctc>=500001 && ctc<=1000000)
    	    	{
    	    		return ctc*30/100;
    	    	}
    	    	return 0;
    	
    }
}
public class Assignment1Q5 {
    public static void main(String args[]) 
    {
    	TaxAmount obj=new TaxAmount();
    	Scanner sc=new Scanner(System.in);
    	System.out.print("Enter your CTC: ");
    	int ctc=sc.nextInt();
    	double result=obj.calculateTaxAmount(ctc);
    	System.out.print("Tax is: "+result);
    }
}