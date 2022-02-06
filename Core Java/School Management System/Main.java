package School.Management.System;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
	 Teacher lizzy=new Teacher(1,"Lizzy",500);
	 Teacher mellisa=new Teacher(2,"Mellisa",700);
	 Teacher yanderhorn =new Teacher(3,"yanderhorn",600);
	 
	  List<Teacher>teacherList=new ArrayList<>();
	  teacherList.add(lizzy);
	  teacherList.add(mellisa);
	  teacherList.add(yanderhorn);
	  
	  
	 Student tamasha=new Student(1,"Tamasha",4);
	 Student rakshith=new Student(2,"Rakshith",12);
	 Student rabbil=new Student(3,"Rabbil",5);
      
	 List<Student> studentList =new ArrayList<>();
	 studentList.add(tamasha);
	 studentList.add(rakshith);
	 studentList.add(rabbil);
	 
	 School ghs=new School(teacherList,studentList);
	
	tamasha.payFees(5000);
	rakshith.payFees(6000);
	System.out.println("GHS has Earned $"+ghs.getTotalMoneyEarned());
	System.out.println("--------Making GHS SCHOOL PAY SALARY------------");
	lizzy.receiveSalary(lizzy.getSalary());
	System.out.println("GHS has spent for salary to "+lizzy.getName()+" and now has "+ghs.getTotalMoneyEarned());
	
	}

}

