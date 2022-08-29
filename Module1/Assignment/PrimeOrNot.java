package task58;

import java.util.Scanner;

public class PrimeOrNot 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("ENTER NUMBER : ");
		int nm = sc.nextInt();
		if(nm % 2 == 0)
			
		{
			System.out.println("THIS IS A PRIME NUMBER");
		}
		else
		{
			System.out.println("THIS IS NOT PRIME NUMBER");
		}
			
	}
}
