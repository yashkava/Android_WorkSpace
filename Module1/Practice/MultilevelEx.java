package pra88;

class A
{
	void a1()
	{
		System.out.println("A1 Accessed");
	}
}
class B extends A
{
	void b1()
	{
		System.out.println("B1 Accessed");
	}
}
class C extends B
{
	void c1()
	{
		System.out.println("C1 Accessed");
	}
}

public class MultilevelEx 
{
	public static void main(String[] args) 
	{
		
		C c1 =new C();
		c1.a1();
		c1.b1();
		c1.c1();
		
	}

}


