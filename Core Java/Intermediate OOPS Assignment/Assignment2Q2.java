
import java.util.ArrayList;

public class Assignment2Q2 {
	int salary = 10000;
    public int getSalary(int salary)
    {
    	return salary;

    }
	public static void main(String[] args) 
	{
		Assignment2Q2 Employee =new Assignment2Q2();
		ArrayList<Integer> employeeSalaries = new ArrayList<Integer>();
		Manager objM = new Manager();
		System.out.println("Manager salary with incentive     :"+objM.getSalary(objM.salary));
		Labour objL = new Labour();
		System.out.println("Labour salary with overtime amount:"+objL.getSalary(objL.salary));
		employeeSalaries.add(objM.salary);
		employeeSalaries.add(objL.salary);
		System.out.println("Total salaries given to all the employees by an organization:"+Employee.totalEmployeesSalary(employeeSalaries));
	}
	public int totalEmployeesSalary(ArrayList<Integer> employeeSalaries)
    {
		int sum=0;
    	for (int i : employeeSalaries)
    	{
    		sum=sum+i;
    	}
    	return sum;
    }

}



class Manager extends Assignment2Q2 {
    public int getSalary(int salary) {
        int incentive = 5000;
        this.salary=salary+incentive;
        return this.salary;
    }
}

class Labour extends Assignment2Q2 {
    @Override
    public int getSalary(int salary) {
        int overtime = 500;
        this.salary=salary+overtime;
        return this.salary;
    }
}