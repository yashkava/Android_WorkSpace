package pra88;
class MyColor
{
	
	String color="WHITE";
	
}
class MyColor2 extends MyColor
{

	String color="BLACK";
	
	void display()
	{
		System.out.println(color);
		System.out.println(super.color);
	}
}


public class SuperEx 
{
	public static void main(String[] args) 
	{
		MyColor2 m2 =new MyColor2();
		
		m2.display();
	}
}


