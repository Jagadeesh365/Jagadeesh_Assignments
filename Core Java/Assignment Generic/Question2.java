import java.util.*;

//2) Write an application to hold 10 random int values as keys and 10 random double values as
//values for a HashMap. Print the data store in the HashMap. Note: Keys can only be int and
//values double 

public class Question2 {
	public static void main(String[] args) {
		Random rand = new Random();
		HashMap<Integer,Double> map = new HashMap<Integer,Double>();
		while(map.size()<10)
		{
			map.put(rand.nextInt(), rand.nextDouble());
		}
		
		System.out.println(map);
	}
}