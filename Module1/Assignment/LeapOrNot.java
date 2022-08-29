package task58;

import java.util.Scanner;

public class LeapOrNot 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("ENTER YEAR : ");
		int yr = sc.nextInt();
		if(yr % 4 == 0)
			
		{
			System.out.println("LEAP YEAR");
		}
		else
		{
			System.out.println("NOT LEAP YEAR");
		}
			
	}
}
