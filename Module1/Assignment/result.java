package task58;

import java.util.Scanner;

public class result 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
	
		System.out.println("MATHS: ");
		float marks1=sc.nextFloat();
		System.out.println("GUJARATI: ");
		float marks2=sc.nextFloat();
		System.out.println("HINDI: ");
		float marks3=sc.nextFloat();
		System.out.println("ENGLISH: ");
		float marks4=sc.nextFloat();
		System.out.println("SANSKRIT: ");
		float marks5=sc.nextFloat();

		float a=(marks1+marks2+marks3+marks4+marks5)*100/500;
		System.out.println("YOU HAVE " +a+ " %");
	
	}
	
	
	
}
