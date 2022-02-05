
import java.util.*;
class Pair<T,U>{
	private T key;
	private U value;
	
	public Pair(T key, U value) {
		super();
		this.key = key;
		this.value = value;
	}

	public T getKey() {
		return key;
	}

	public U getValue() {
		return value;
	}
	
	
}
public class Question4 {


	public static void main(String[] args) {
      		Pair<String,String>  p=new Pair<String,String>("1170","jagadeesh");
      		Pair<String,Date>   p1=new Pair<String,Date>("Date and time:",new java.util.Date());
      		
      		System.out.println(p.getKey()+" "+p.getValue());
      		System.out.println(p1.getKey()+" "+p1.getValue());
      		
	}

}
