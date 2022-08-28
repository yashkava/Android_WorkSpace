package pra178;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx 
{
	public static void main(String[] args) 
	{
		
		/*key,value pair*/
		
		HashMap<String,Integer> map =new HashMap<>();
		
		map.put("aa", 001);
		map.put("ab", 102);
		map.put("ba", 103);
		map.put("bb", 104);
		
		
		
		for(Map.Entry m:map.entrySet())
		{
			System.out.println(m.getKey()+" "+m.getValue());
			
		}
		
		
		
	}

}