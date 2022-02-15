/*
 * Define Functional Interface and write a program to perform arithmetic operations like add, subtract, multiply and divide using functional interface.
 */

interface Arithmetic{
	double operation(double a,double b);
}
public class Assignment4Q1 {

	public static void main(String[] args) {
		double x=13;
		double y=5;
		Arithmetic addition=(a,b)->a+b;
		Arithmetic subtraction=(a,b)->a-b;
		Arithmetic multiplication=(a,b)->a*b;
		Arithmetic division=(a,b)->(a/b);
		System.out.println("Addition "+x+" and "+y+"      :"+addition.operation(x, y));
		System.out.println("Subtraction "+x+" and "+y+"   :"+subtraction.operation(x, y));
		System.out.println("Multiplication "+x+" and "+y+":"+multiplication.operation(x, y));
		System.out.println("Division "+x+" and "+y+"      :"+division.operation(x, y));

	}

}