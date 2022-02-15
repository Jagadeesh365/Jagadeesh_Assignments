//Q4. Remove the words that have odd lengths from the list. HINT: Use one of the new methods from JDK 8. Use removeIf() method from Collection interface.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Assignment4Q4 {
	public ArrayList<String> removeOddLength(ArrayList<String> employeeList) {
		Predicate<String> delete_odd_names = p -> p.length()%2!=0;
		employeeList.removeIf(delete_odd_names);
		return employeeList;
	}

	public static void main(String[] args) {
		ArrayList<String> employeeNames = new ArrayList<String>(Arrays.asList("Jagadeesh","Srinivas","Pavan Tej","Devansh","Amrendra","Arshari","Lokesh"));
		
		Assignment4Q4 assignment4q4=new Assignment4Q4();
		for (String after_old_removed : assignment4q4.removeOddLength(employeeNames)) {
			System.out.println(after_old_removed);
		}
	}
}