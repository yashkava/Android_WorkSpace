package PRA58;

import java.util.Scanner;

public class UserInputEx 
{
	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ENTER YOUR MARKS: ");
		float marks=sc.nextFloat();
		if(marks>=35)
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		
		
	}
}
