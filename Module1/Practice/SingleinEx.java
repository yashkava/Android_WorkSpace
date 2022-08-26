package pra88;


class A1
{
	String name;
	void a1()
	{
		System.out.println("A1 Accessed");
	}
}
class B1 extends A1
{
	void b1()
	{
		System.out.println("B1 Accessed");
	}
}

public class SingleinEx 
{
	public static void main(String[] args) 
	{
		B1 b =new B1();
		
		b.a1();
		b.b1();
	}
}



