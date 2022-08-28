package pra178;

import java.util.HashSet;
import java.util.Iterator;



public class SetEx 
{
	public static void main(String[] args) 
	{
		
		HashSet<Object> set =new HashSet<>();
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("C");
		set.add("D");
		set.add("P");
		Iterator i = (Iterator) set.iterator();
		
		while(i.next() != null)
		{
			System.out.println(i.next());
		}
		
	}
}
