package pra158;

public class StringCompareEx 
{
	public static void main(String[] args) 
	{
		
		String s1 ="Yash";
		String s2="Yash";
		String s3=new String("yash");
		String s4="shay";
		
		String s5="yash";
		String s6="yash";
		String s7="YAsh";
		
		String s8="raj";
		String s9="raaj";
		String s10="raj";
		
		
		System.out.println("--------------Equals-------------");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		
		System.out.println("---------Equals Ignorecase-----------");
		
		
		System.out.println(s5.equals(s6));
		System.out.println(s5.equalsIgnoreCase(s7));
		
		
		System.out.println("--------- ==  -----------");
		
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		
		System.out.println("--------- CompareTo-----------");
		
		System.out.println(s8.compareTo(s10));
		System.out.println(s8.compareTo(s9));
		
	}
}
