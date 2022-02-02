import java.util.*;
public class PerformStringOpreations {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String scp="Java String pool refers to collection of Strings which are stored in heap memory";
		
		
		while (true)
		{
			System.out.print(" a. Print the string to console in lowercase\n b. Print the string to console in uppercase\n c. Replace all ‘a’ character in the string with $ sign\n d. Check if the original String contains the word collection \ne. Check if the following String “java string pool refers to collection of strings which are stored in heap memory” matches the original\nf.If the string does not match check if there is another method which can be used to check if the strings are equal\ng.Exit\n Choose your opttion:");
			char choose=sc.next().charAt(0);
			switch(choose)
			{
			case 'a':
			{
				System.out.println(scp.toLowerCase());
				break;
			}
			case 'b':
			{
				System.out.println(scp.toUpperCase());
				break;
			}
			case 'c':
			{
				System.out.println(scp.replace('a', '$'));
				break;
			}
			case 'd':
			{
				System.out.println(scp.contains("collection"));
				break;
			}
			case 'e':
			{
				System.out.println(scp.equals("java string pool refers to collection of strings which are stored in heap memory"));
				break;
			}
			case 'f':
			{
				System.out.println(scp=="java string pool refers to collection of strings which are stored in heap memory");
				break;
			}
			case 'g':
			{
				System.exit(0);
			}
			
			default :
				System.out.println("Enter from [a-g]");
				
			}
		}

	}

}
