package Question1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.SpringAssignment.Question.Q1.Address;
import in.SpringAssignment.Question.Q1.Customer;


public class TestCustomer {
	private Customer customer,expected;
	private ApplicationContext context;
	
	

	@BeforeEach
	public void setup() {
		context = new ClassPathXmlApplicationContext("spring1.xml");

	}

	@Test
	void customerDetail() {

		customer =context.getBean("customerCon",Customer.class);
		assertEquals(new Customer(11719575,"Mavitha","99333775511",new Address("Vaikuntapuramlo","Nellore","Andhar Pradesh","India","262531")),customer);
	}

}
