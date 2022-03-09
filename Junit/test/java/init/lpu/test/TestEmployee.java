package init.lpu.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@DisplayName("TESTING EMPLOYEE TASK")
public class TestEmployee {

	@Test
	@Tag("prod")
	public void testA() {
		System.out.println("HELLO_TEST_A");

	}
	@Test
	@Tag("dev")
	public void testB() {
		System.out.println("HELLO_TEST_B");

	}
	@Test
	@Tag("prod")
	public void testC() {
		System.out.println("HELLO_TEST_C");

	}

	@Test
	@Tag("dev")
	public void testD() {
		System.out.println("HELLO_TEST_D");

	}
}
