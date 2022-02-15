import java.util.Comparator;
import java.util.TreeMap;
enum gender{male, female}

class Contact{
	public long phoneNo;
	public String name;
	public String email;
	gender g;
	public Contact(String name, String email, gender g) {
		this.name = name;
		this.email = email;
		this.g = g;
	}
}
class Compare implements Comparator<Contact>{
	public int compare(Contact c1, Contact c2) {
		return 0;
	}
}
	
public class CollectionQ1 {

	public static void main(String[] args) {
		
		TreeMap <Long, Contact> tm = new TreeMap<Long, Contact>();
		tm.put(9866297543l,new Contact("Jagadesh", "jagadeeshgmail.com", gender.male)); 
		tm.put(917723458l, new Contact("Chandni", "moonpieu@gmail.com", gender.female));
		tm.put(8686264861l, new Contact("Kedhar", "kehar@gmail.com", gender.male));
		tm.put(9963542854l, new Contact("kowshik", "Kowishi@gmail.com", gender.male));
		tm.put(8523674122l, new Contact("Amit", "amit@gmail.com", gender.male));
		tm.put(9177236584l, new Contact("Prasanna", "reddy@gmail.com", gender.female));
		tm.put(6324876486l, new Contact("Chandnu", "priya@gmail.com", gender.male));
		tm.put(7684239458l, new Contact("Bhanavi", "bhavani@gmail.com", gender.female));
		tm.put(77788844255l, new Contact("Priyanak", "priyanka@gmail.com", gender.female));
		tm.put(66897453862l, new Contact("Prathap", "prathap@gmail.com", gender.male));
		
		System.out.println("Keys:");
		System.out.println(tm.keySet());
		System.out.println("Values:");
		System.out.println(tm.values());
		System.out.println("Pair:");
		System.out.println(tm);
	}
}