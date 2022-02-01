import java.util.Scanner;

class ResultDeclaration{
    public String declareResults( double subject1Marks, double subject2Marks, double subject3Marks) {
    		if(subject1Marks>60 && subject2Marks>60 && subject3Marks>60)
    		{
    			return "passed";
    		}
    		else if((subject1Marks>60 && subject2Marks>60) || (subject2Marks>60 && subject3Marks>60) || (subject3Marks>60 && subject1Marks>60))
    		{
    			return "promoted";
    		}
    		else {
    			return "failed";
    		}
    }
}
public class Assignment1Q4{
    public static void main(String[] args) {
    	ResultDeclaration obj=new ResultDeclaration();
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter the subject1Marks: ");
    	double subject1Marks = sc.nextDouble();
    	System.out.print("Enter the subject2Marks: ");
    	double subject2Marks = sc.nextDouble();
    	System.out.print("Enter the subject3Marks: ");
    	double subject3Marks = sc.nextDouble();
    	
    	String result=obj.declareResults(subject1Marks, subject2Marks, subject3Marks);
    	System.out.print(result);
    	
    }
}