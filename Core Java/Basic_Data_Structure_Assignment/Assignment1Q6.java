import java.util.*;
class Login{
    String userId = "Ajay",password = "password";
    Scanner sc = new Scanner(System.in);
    int count=0;
    public String getUser()
    {
    	System.out.println("Enter UserId");
		String user=sc.next();
		return user;
    }
    public String getPassword()
    {
    	System.out.println("Enter Password");
	    String  pass=sc.next();
	     return pass;
    }
    public String loginUser(String user, String pass) {
    	
    	  user=getUser();
		  pass=getPassword();
		  
    if(user.equals(userId) && pass.equals(password))
    {
    	System.out.println("hellonbns");
    	return "welcome"+" "+user;
    }
    else
    {
    	count++;
	    if(count<3)
	    {
	       System.out.println("You have entered wrong credentials ,please enter the right credentials.");
	       loginUser(user,pass);
	       
	    }
    }
	    return "You have entered wrong credentials 3 times"+"\n"+"Contact Admin";
	    
	    
	    	
	    
	
	    
    }

}
public class Assignment1Q6 {

	public static void main(String[] args) {
		
		Login user=new Login();
		String userId="",password="";
		
		System.out.println(user.loginUser(userId, password));
	}

}