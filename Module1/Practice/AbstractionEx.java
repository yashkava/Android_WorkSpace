package pra88;

abstract class K
{
	abstract void k1();
}

class Y extends K
{

	@Override
	void k1() {
		// TODO Auto-generated method stub
		System.out.println("K 1 IS ACCESSED");
	}
	
}
public class AbstractionEx 
{
	public static void main(String[] args) 
	{
		
		Y l1  =new Y();
		l1.k1();
		
		
	}
}
