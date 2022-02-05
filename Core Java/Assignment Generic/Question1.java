/*
 1) Use a HashSet to hold Employee Objects. Upon running the application, the details of the
employees added to the HashSet should be displayed.
Employee <<class>>
 |-- id
 |-- name
 |-- salary
 |-- department
 |-- displayDetails()
Feel free to add properties and methods to Employee Class
Note: if we 
 */
import java.util.*;
class Employee
{
	private int empid;
	private String name;
	private double salary;
	private String department;
	public Employee(int empid, String name, double salary, String department) {
		super();
		this.empid = empid;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	public void displayDetails() {
		System.out.println("Employee ID: "+empid);
		System.out.println("Employee Name: "+name);
		System.out.println("Employee Salary: "+salary);
		System.out.println("Department: "+department);
	}
}
public class Question1 {

	public static void main(String[] args) {
	
			HashSet<Employee> emp=new HashSet<>();
			emp.add(new Employee(1171, "Jagadeesh",50000,"WEB Developer"));
			emp.add(new Employee(1214, "Srinivas",35000,"Python"));
			emp.add(new Employee(1214, "Karthik",65000,"Java"));
			for(Employee e : emp){
			    e.displayDetails();
			    System.out.print("\n");
			}

	}

}
