package pra158;

public class CopyValueEx 
{
	public static void main(String[] args) 
	{
		
		int A[]= {10,20,30,40,50,60};
		
		int B[]=new int[10];
		
		System.arraycopy(A, 2, B, 2, 3);
		
		for(int i=0;i<10;i++)
		{
			System.out.println(B[i]);
		}
		
	}
}
