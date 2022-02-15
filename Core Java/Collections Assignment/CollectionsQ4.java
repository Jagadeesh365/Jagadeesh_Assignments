import java.util.*; 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CollectionsQ4{  
	public static void main(String args[]){
	 
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	 
		LocalDate d1 = LocalDate.of(1998, 11, 24);
		LocalDate d2 = LocalDate.of(2004, 12, 23);
		
  
		LinkedList<LocalDate> check=new LinkedList<>();  
		check.add(d1);  
		check.add(d2);  
		 
	  
	    Iterator<LocalDate> getData=check.descendingIterator();  
	    while(getData.hasNext()){ 
		    LocalDate date = getData.next();
		    System.out.print("Your date of birth is : "+date.format(format));
	   
	        if(date.isLeapYear()) {
		        System.out.println(" and it was a leap year.");
	        }
	        else {
		    System.out.println(" and it was not a leap year.");
	        }
        }  
	}
}