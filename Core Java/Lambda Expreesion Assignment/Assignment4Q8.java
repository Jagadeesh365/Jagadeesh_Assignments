import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Q8. Create a new thread that prints the numbers from the list. Use class Thread & interface Consumer.

public class Assignment4Q8 {
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1171,1172,1173,1174,1175,1176,1177);
		Thread thread = new Thread(() -> nums.forEach( num -> System.out.println(num)));
		System.out.println("list is: ");
		thread.run();	

}
}