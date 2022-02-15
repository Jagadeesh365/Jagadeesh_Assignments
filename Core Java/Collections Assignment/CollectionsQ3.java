/*
 * 3)	Store at least 10 Employee Objects in an TreeSet<Employee>. When the application runs the user should be asked to select one of the options upon which you will print the employee details in a sorted manner.
For E.g.
Run Application:
a)	ID
b)	Name
c)	Department
d)	Salary
Your choice: b
<Should print all the employee�s details sorted by name>

 */
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Collections;

class Employee implements Comparable<Employee>
{
	int ID;
	String Name;
	String Department;
	double Salary;
	public Employee(int ID,String Name,String Department,double Salary)
	{
		this.ID=ID;
		this.Name=Name;
		this.Department=Department;
		this.Salary=Salary;
	}
	public int compareTo(Employee e)
    {
        if (ID >e.ID) {
            return 1;
        }
        else if (ID < e.ID) {
            return -1;
        }
        else {
            return 0;
        }
    }

}
public class CollectionsQ3 {
	public static void main(String args[])
	{
		Employee e1= new Employee(20,"John","HR",270000);
		Employee e2= new Employee(32,"Shivani","Marketing",38000);
		Employee e3= new Employee(12,"Rocky","Design",470000);
		Employee e4= new Employee(56,"Bruno","Sales",52000);
		Employee e5= new Employee(82,"Jiya","Finance",63000);
		Employee e6= new Employee(21,"Karan","Production",37000);
		Employee e7= new Employee(54,"Hema","Law",800000);
		Employee e8= new Employee(30,"Kenny","Business",45000);
		Employee e9= new Employee(41,"Naina","Accounting",36000);
		Employee e10= new Employee(06,"Clein","Operations",79000);
		 Scanner sc = new Scanner(System.in);
		 TreeSet<Employee> xy = new TreeSet<Employee>(Collections.reverseOrder());
		 xy.add(e1);
		 xy.add(e2);
		 xy.add(e3);
		 xy.add(e4);
		 xy.add(e5);
		 xy.add(e6);
		 xy.add(e7);
		 xy.add(e8);
		 xy.add(e9);
		 xy.add(e10);
		 while(true)
		 {
		 System.out.println("a) ID"+"\n"+"b) Name"+"\n"+"c) Department"+"\n"+"d) Salary"+"\n"+"e) Exit\n");
		 System.out.println("Press Option: ");
		  String Choice=sc.nextLine();
		 if (Choice.equalsIgnoreCase("a"))
		 {
			 for(Employee e: xy)
			 {
				 System.out.println(e.ID);
			 }
		 }
		 else if (Choice.equalsIgnoreCase("b"))
		 {
			 for(Employee e: xy)
			 {
				 System.out.println(e.Name);
			 }
		 }
		 else if (Choice.equalsIgnoreCase("c"))
		 {
			 for(Employee e: xy)
			 {
				 System.out.println(e.Department);
			 }
		 }
		 else if (Choice.equalsIgnoreCase("d"))
		 {
			 for(Employee e: xy)
			 {
				 System.out.println(e.Salary);
			 }
		 }
		 else if (Choice.equalsIgnoreCase("e"))
		 {
			 System.exit(0);
		 }
		 else
		 {
			 System.out.println("Invalid option try with from A to D\n");
		 }
		 }
		 
		 
	}

}