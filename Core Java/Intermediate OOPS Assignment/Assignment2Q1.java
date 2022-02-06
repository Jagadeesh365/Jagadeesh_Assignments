/*Q1. Write a singleton class. Confirm that singleton class cannot be inherited.

Singleton Class:-

The singleton design pattern is used to restrict the instantiation of a class and ensures that only one instance of the class exists in the JVM. In other words, a singleton class is a class that can have only one object (an instance of the class) at a time per JVM instance.
*/
class SingletonInheritanceCheck{
	private static  SingletonInheritanceCheck s=null;
	private SingletonInheritanceCheck()
	{
		
	}
	public static  SingletonInheritanceCheck getSingletonInheritanceCheck()
	{
		if (s==null)
		{
			s=new SingletonInheritanceCheck();
		}
		return s;
	}
}
public class Assignment2Q1 {
	SingletonInheritanceCheck check1=SingletonInheritanceCheck.getSingletonInheritanceCheck();
	SingletonInheritanceCheck check2=SingletonInheritanceCheck.getSingletonInheritanceCheck();
}

