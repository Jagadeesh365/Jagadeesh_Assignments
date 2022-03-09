import java.util.Scanner;

abstract class DesertItem {

	abstract public int getCost();
}

class Candy extends DesertItem {
	int cost = 80;

	public int addCandies(int candies) {
		return candies;
	}

	@Override
	public int getCost() {
		return cost;
	}
}

class Cookie extends DesertItem {
	int cost = 70;

	public int addCookies(int candies) {
		return candies;
	}

	@Override
	public int getCost() {
		return cost;
	}
}

class IceCream extends DesertItem {
	int cost = 90;

	public int addIceCreams(int candies) {
		return candies;
	}

	@Override
	public int getCost() {
		return cost;
	}
}

public class Assignment2Q7 {
	private void selectRoles() {
		System.out.println("Enter your role(Owner/Customer)");
		Scanner sc = new Scanner(System.in);
		String role = sc.next();
		if (role.equalsIgnoreCase("Owner")) {
			roles("Owner");

		} else if (role.equalsIgnoreCase("Customer")) {
			roles("Customer");
		} else {
			System.out.println("Please enter valid choice! ");
		}
	}

	private void roles(String role) {
		if (role == "Owner") {
			addItems();
		} else if (role == "Customer") {
			placeOrder();
		}
	}

	private void addItems() {
		System.out.println("Press 1. Add Candies\nPress 2. Add Cookies\nPress 3. Add IceCream");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if (choice == 1) {
			addItemsOperation(1);
		} else if (choice == 2) {
			addItemsOperation(2);
		} else if (choice == 3) {
			addItemsOperation(3);
		} else {
			System.out.println("Please enter valid choice! ");
		}
	}

	private void addItemsOperation(int choice) {
		Scanner sc = new Scanner(System.in);
		if (choice == 1) {
			int quantity = 0;
			System.out.print("Enter number of candies: ");
			if (sc.hasNext()) {
				quantity = sc.nextInt();
			}
			Candy candy = new Candy();
			System.out.println(candy.addCandies(quantity) + " Candies Added Succesfully");
		} else if (choice == 2) {
			int quantity = 0;
			System.out.print("Enter number of Cookies: ");
			if (sc.hasNext()) {
				quantity = sc.nextInt();
			}
			Cookie cookie = new Cookie();
			System.out.println(cookie.addCookies(quantity) + " Cookies Added Succesfully");
		} else if (choice == 3) {
			int quantity = 0;
			System.out.print("Enter number of IceCreams: ");
			if (sc.hasNext()) {
				quantity = sc.nextInt();
			}
			IceCream iceCream = new IceCream();
			System.out.println(iceCream.addIceCreams(quantity) + " IceCream Added Succesfully");
		}
	}

	private void placeOrder() {
		System.out.println("Press 1. Buy Candies\nPress 2. Buy Cookies\nPress 3. Buy IceCream");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if (choice == 1) {
			placeOrderOperation(1);
		} else if (choice == 2) {
			placeOrderOperation(2);
		} else if (choice == 3) {
			placeOrderOperation(3);
		} else {
			System.out.println("Please enter valid choice! ");
		}
	}

	private void placeOrderOperation(int choice) {
		Scanner sc = new Scanner(System.in);
		if (choice == 1) {
			System.out.println("Enter quantity");
			int quantity = 0;
			if (sc.hasNext()) {
				quantity = sc.nextInt();
			}
			DesertItem desertItem = new Candy();
			int amount = quantity * desertItem.getCost();
			System.out.println("Your Total is: " + (amount) / 60 + "$");
		} else if (choice == 2) {
			String euro = "€";
			System.out.println("Enter quantity");
			int quantity = 0;
			if (sc.hasNext()) {
				quantity = sc.nextInt();
			}
			DesertItem desertItem = new Cookie();
			int amount = quantity * desertItem.getCost();
			System.out.println("Your Total is: " + (amount) / 60 + euro);
		} else if (choice == 3) {
			System.out.println("Enter quantity");
			int quantity = 0;
			if (sc.hasNext()) {
				quantity = sc.nextInt();
			}
			DesertItem desertItem = new IceCream();
			int amount = quantity * desertItem.getCost();
			System.out.println("Your Total is: " + amount);
		}
	}

	public static void main(String[] args) {
		Assignment2Q7 selctr = new Assignment2Q7();
		selctr.selectRoles();
	}
}