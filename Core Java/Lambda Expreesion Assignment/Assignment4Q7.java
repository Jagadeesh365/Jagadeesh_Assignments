
/*
 * Q7. Convert every key-value pair of the map into a string and append them all into a single string, in iteration order. HINT: Use Map.entrySet() method & a StringBuilder to construct the result String.

 */
import java.util.HashMap;

public class Assignment4Q7 {
	public String convertKeyValueToString(HashMap<String, Integer> map) {
		StringBuilder sb = new StringBuilder();
		map.entrySet().forEach(entry->sb.append(entry.getKey()).append(entry.getValue()));
		return sb.toString();
	}
	public static void main(String[] args) {
		HashMap<String,Integer> names=new HashMap<String,Integer>();
		names.put("Jagadeesh",1171);
		names.put("Lokesh",1172);
		names.put("Amrendra",1172);
		names.put("Pavan",1173);
		names.put("Arshsri",1174);
		Assignment4Q7 obj=new Assignment4Q7();
		System.out.println(obj.convertKeyValueToString(names));
	}
	
}