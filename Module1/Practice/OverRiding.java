package pra88;


class Bank1
{
	int rate()
	{
		return 0;
	}
}
class Sbi extends Bank1
{
	int rate()
	{
		return 7;
	}
}
class Icici extends Bank1
{
	int rate()
	{
		return 8;
	}
}
class Axis extends Bank1
{
	int rate()
	{
		return 9;
	}
}

public class OverRiding 
{
	public static void main(String[] args) 
	{
		
			Bank1 b;
			
			b=new Sbi();
			System.out.println(b.rate());
			
			b=new Icici();
			System.out.println(b.rate());
			
			b=new Axis();
			System.out.println(b.rate());
	}
}


