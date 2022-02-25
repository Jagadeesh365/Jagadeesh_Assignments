package in.SpringAssignment.Question.Q1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring1.xml");

		// using the setter injection
		Customer  customer= context.getBean("customer",Customer.class);
		System.out.println(customer);
		
		// using constructor injection
		Customer customerCon =context.getBean("customerCon",Customer.class);
		System.out.println(customerCon);
		

	}
}
