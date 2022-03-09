package in.Question4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

class TestLifeCycleAnnotation {
	static LifeCycleAnnotation Calculator;
	@BeforeAll
	static void setup(){
		System.out.println("@BeforeAll executed");
		Calculator =new LifeCycleAnnotation();
	}

	@BeforeEach
	void setupThis(){
		System.out.println("@BeforeEach executed");
		
	}

	@Test
    void testadd()
	{
		System.out.println("********TEST ONE EXECUTED*********");
		assertEquals(4, Calculator.add(2, 2));
    }

    @Test
    void testdivide()
   {
		System.out.println("**********TEST TWO EXECUTED**********");
		assertEquals( 6 , Calculator.divide(12, 2));
    }

	@AfterEach
	void tearThis(){
		System.out.println("@AfterEach executed");
	}

	@AfterAll
	static void tear(){
		System.out.println("@AfterAll executed");
	}

}
