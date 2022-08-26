package pra88;


interface Print
{
	void print();
}
interface Show
{
	void show();
}
interface Xyz
{
	void xyz();
}

public class A7 implements Print,Show,Xyz
{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("showing success");
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("printing success");
	}

	@Override
	public void xyz() {
		// TODO Auto-generated method stub
		System.out.println("ALL PERFORMED");
	}
	
	public static void main(String[] args) {
		
		
		A7 a1 =new A7();
		a1.print();
		a1.show();
		a1.xyz();
		
	}

}