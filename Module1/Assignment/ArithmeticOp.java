package task58;

import java.util.Scanner;

public class ArithmeticOp 
{
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		

		
		System.out.println("ENTER NUMBER A= ");
		int a1=sc.nextInt();
	
		System.out.println("ENTER NUMBER B= ");
		int b1=sc.nextInt();
	
		System.out.println("1.ADDITION");
		System.out.println("2.SUBSTRACTION");
		System.out.println("3.MULTIPLICATION");
		System.out.println("4.DIVISION");
		System.out.println("ENTER YOUR CHOISE:");
		int c=sc.nextInt();
		
		{
		switch(c)
		{
		case 1:System.out.println("A+B = "+(a1+b1));
		break;
		
		case 2:System.out.println("A-B = "+(a1-b1));
		break;
		
		case 3:System.out.println("A*B = "+(a1*b1));
		break;
		
		case 4:System.out.println("A/B = "+(a1/b1));
		break;
		
		default:System.out.println("Your Number is not valid");
		break;
		
		}
		
		
		
		
		}
		
	}
	
	
	
}
