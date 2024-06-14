package HASHMAP;
import java.util.*;

public class StringOccurnace 
{

	public static void test(String name)
	{
		Map<Character, Integer> charmap= new HashMap<Character,Integer>();

		char char_name[]= name.toCharArray();

		for(char c: char_name)
		{
			if(!String.valueOf(c).isBlank())
			if(charmap.containsKey(c))
			{
				charmap.put(c, charmap.get(c)+1);
			}
			else
			{
				charmap.put(c, 1);
			}
		}
		System.out.println(name +"="+ charmap);
	}
	public static void main(String[] args) 
	{

		test("Kapil kukkar");
	}

}
