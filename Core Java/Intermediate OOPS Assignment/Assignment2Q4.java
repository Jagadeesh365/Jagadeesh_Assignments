public abstract class Assignment2Q4 {
	abstract public void method1();
	abstract public void method2();
}
class A extends Assignment2Q4
{
	public void method1()
	{
		System.out.println("overriding the abstract method1");
	}
	public void method2()
	{
		System.out.println("overriding the abstract method2");
	}
}

abstract class B extends Assignment2Q4
{
	public void method3()
	{
		System.out.println("this is not a abstract method but the class is abstract"+"/n"+"so there is no need to implement the abstract methods");
	}
}
abstract class D
{
	public void method4()
	{
		System.out.println("abstract class without abstract methods");
	}
}
class E
{
	public static void main(String args[])
	{
		A a = new A();
		a.method1();
		a.method2();

	}
}
