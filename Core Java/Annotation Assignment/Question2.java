/*
 * Build a custom annotation called @Info, which can be used by developers on a class, a
property, or a method. The developer can provide the following information when using this
annotation:
a) AuthorID: <<Developers ID>> - (Mandatory Input)
b) Author: <<Developers name>> - (Optional Input)
c) Supervisor: <<Developers Supervisor>> - (Optional Input)
d) Date: <<”String Date”>> - (Mandatory Input)
e) Time: <<”String Time”>> - (Mandatory Input)
f) Version: <<Numerical Version >> - (Mandatory Input)
g) Description: <<Description of the class, method, or property >> - (Optional Input)
 */
package in.lpu.annotation;

@interface Info {
	int authId();

	String authName();

	String supervisor();

	String date();

	String time();

	double version();

	String description();
}

@Info(authId = 1, authName = "Jagadeesh", supervisor = "Lokesh", date = "24th Nov", time = "2:30 AM", version = 2.0, description = "Roobo"
		+ "")
class ClassTest2 {
	public void display() {
		System.out.print("Annotated.");
	}
}

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClassTest2 ct = new ClassTest2();
		ct.display();
	}

}