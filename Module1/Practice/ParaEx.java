package PRA58;

public class ParaEx
{
	int id;
	String name;
	
	public ParaEx(int i,String n) 
	{
		// TODO Auto-generated constructor stub
		id=i;
		name=n;
	}
	
	void display()
	{
		System.out.println(id+" "+name);
	}
	
	public static void main(String[] args) 
	{
		ParaEx p1 =new ParaEx(001,"YASH");
		ParaEx p2 =new ParaEx(002,"BHARGAV");
		
		p1.display();
		p2.display();
	}
}
