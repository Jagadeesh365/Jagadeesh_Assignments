import java.util.*;
class SearchArray
{
    public boolean  searchArray(int[] arr,int toCheckValue)
    {
    	
    	for(int i=0;i<arr.length;i++)
    	{
    		if(arr[i]==toCheckValue)
    		{
    			return true;
    			  
    		}
    	}
    	return false;
    		
    	
    	
    }
}

public class Assignment1Q7 {
    public static void main(String[] args) {
    	Scanner sc=new Scanner (System.in);
    	SearchArray obj=new SearchArray();
        int arr[] = { 5,12,14,6,78,19,1,23,26,35,37,7,52,86,47};
        System.out.println("Enter value to find above array:");
        int valueToCheck =sc.nextInt();
        
        if(obj.searchArray(arr,valueToCheck))
        {
        	System.out.println("Yes value was find "+valueToCheck);
        }
        else
        {
        	System.out.println("Value is not find of  "+valueToCheck);
        }
        
}
    }