package pra88;

class P1
{
	void p1()
	{
		System.out.println("P1 accessed");
	}
}
class Q extends P1
{
	void q()
	{
		System.out.println("Q accessed");
	}
}
interface R 
{
	void r();
}
class S extends Q implements R
{
	void s()
	{
		System.out.println("S accessed");
	}

	@Override
	public void r() 
	{
		// TODO Auto-generated method stub
		System.out.println("R accessed");
	}
}


public class HybridEx 
{
	public static void main(String[] args) 
	{
		S s1 =new S();
		
		s1.p1();
		s1.q();
		s1.r();
		s1.s();
	}
}
