/*
 * Create a custom annotation called @Test which can be only applied on a method implying
that the following method is a test-case. (Is it possible to restrict the annotation to be
applied only on a non-static method?) 
 */
package in.lpu.annotation;

@interface Test {
}

class ClassTest {
	@Test
	public void display() {
		System.out.print("This is inside Test class @test.");
	}
}

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassTest ct = new ClassTest();
		ct.display();

	}

}
