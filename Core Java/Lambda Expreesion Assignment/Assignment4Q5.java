/*
 *5. Create a string that consists of the first letter of each word in the list of Strings provided. HINT: Use Consumer interface & a String Builder to construct the result.
 */
import java.util.Arrays;
import java.util.List;

public class Assignment4Q5 {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Jagadeesh","Srinivas","Pavan Tej","Devansh","Amrendra","Arshari","Lokesh");
		System.out.println(Assignment4Q5.processWords(names));

	}
	public static String processWords(List<String> list){
		StringBuilder first_letter_of_words=new StringBuilder(); 
		list.forEach(word->first_letter_of_words.append(word.charAt(0)));
		return first_letter_of_words.toString();
	}
}