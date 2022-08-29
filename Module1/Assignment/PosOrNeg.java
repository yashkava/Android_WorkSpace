package task58;

import java.util.Scanner;

public class PosOrNeg 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("ENTER VALUE : ");
		int val = sc.nextInt();
		if(val<0)
		{
			System.out.println("YOUR NUMBER IS NEGATIVE");
		}
		else
		{
			System.out.println("YOUR NUMBER IS POSITIVE");
		}
			
	}
}