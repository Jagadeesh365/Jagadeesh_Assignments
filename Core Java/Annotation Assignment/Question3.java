/*
 * Create a custom annotation called @Execute to be applied on methods. Placing the
@Execute method on a method implies that method should be invoked using Reflection API
(Invoking the method using Reflection API is out of scope of this assignments). The
annotation @Execute should have an optional property “sequence” which can be given
values such as 1, 2, 3… in the order of priority. In case the sequence property is not used the
API may invoke methods in random order. 
 */
package in.lpu.annotation;

@interface Execute {
	int sequence();
}

public class Question3 {

	@Execute(sequence = 2)
	public void method1() {
		System.out.println("Method 1");
	}

	@Execute(sequence = 1)
	public void method2() {
		System.out.println("Method 2");
	}

	@Execute(sequence = 3)
	public void method3() {
		System.out.println("Method 3");
	}

	public static void main(String[] args) {

		System.out.println("Sequences given.");

	}

}