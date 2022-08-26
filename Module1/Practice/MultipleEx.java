package pra88;


{

}

class M
{
	void m()
	{
		System.out.println("A Accessed");
	}
}
class N
{
	void n()
	{
		System.out.println("B Accessed");
	}
}
class P extends M ,N
{
	void p()
	{
		System.out.println("C Accessed");
	}
}

public class MultipleEx
	
