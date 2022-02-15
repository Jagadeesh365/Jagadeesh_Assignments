import java.util.*; 
public class CollectionQ2 {
	public static void main(String[] args) {
		Set<String> products = new TreeSet<>();

		

		products.add("iphone");
		products.add("Samsung");
		products.add("Nokia");
		products.add("Realmi");
		products.add("LG");
		products.add("VIVO");
		products.add("LG");
		products.add("Motorola");
		products.add("MI");
		products.add("HTC");
		System.out.println("Mobile products in india");
		System.out.println(products);
		System.out.println("Total: "+ products.size());
		//all the products are but size is because of LG is duplicate value 
}
}