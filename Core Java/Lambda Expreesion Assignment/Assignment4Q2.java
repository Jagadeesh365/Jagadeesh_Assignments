/*
 * Write an application using lambda expressions to print Orders having 2 criteria implemented: 1) order price more than 10000 2) order status is ACCEPTED or COMPLETED.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Assignment4Q2 {
	private int totalPrice;
	private String status;

	public Assignment4Q2(int totalPrice, String status) {
		super();
		this.totalPrice = totalPrice;
		this.status = status;
	}

	public static ArrayList<Assignment4Q2> listOfOrders(ArrayList<Assignment4Q2> orders) {

		ArrayList<Assignment4Q2> filtered_data = orders.stream()
				.filter(check -> check.totalPrice > 10000)
				.filter(g ->g.status.contains("ACCEPTED") || g.status.contains("COMPLETED"))
				.collect(Collectors.toCollection(ArrayList::new));  
		 return filtered_data;
	}
	public static void main(String[] args) {
		ArrayList<Assignment4Q2> ordersArrayList= new ArrayList<Assignment4Q2>(
				Arrays.asList(
						new Assignment4Q2(11000,"COMPLETED"),
						new Assignment4Q2(8000,"COMPLETED"),
						new Assignment4Q2(7000,"ACCEPTED"),
						new Assignment4Q2(12000,"ACCEPTED"),
						new Assignment4Q2(16000,"ACCEPTED")
						     ));
		listOfOrders(ordersArrayList)
				.forEach(Assignment4Q2 -> System.out.println(Assignment4Q2.totalPrice + ": " + Assignment4Q2.status));

	}
}
