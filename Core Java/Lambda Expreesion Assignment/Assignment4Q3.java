/*
 * Use the functional interfaces Supplier, Consumer, Predicate & Function to invoke built-in methods from Java API.

Description:
 */
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Product {
	String cmpy = "iphone";
}

public class Assignment4Q3 {
	static void modifyValue(int val) {
		System.out.println("Value is: " + val);
	}

	static void display() {
	}

	public static void main(String[] args) {
		Product product = new Product();
		Supplier<Boolean> boolSupplier = () -> product.cmpy.length() == 6;
		System.out.println(boolSupplier.get()); 

		Consumer<Integer> consumer = Assignment4Q3::modifyValue;
		consumer.accept(24); 

		ArrayList<String> brand = new ArrayList<String>();
		brand.add("iphone");
		brand.add("Nokia");
		brand.add("MI");
		brand.add("Realme");

		Predicate<String> remow_with_size = check -> check.length() == 5; 
		brand.removeIf(remow_with_size);
		System.out.println(brand);  
		
		
		Function<Integer, Integer> func = multi -> multi*4;  
	    System.out.println(func.apply(15));

	}
}