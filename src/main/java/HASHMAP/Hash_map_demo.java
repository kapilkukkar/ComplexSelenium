package HASHMAP;
import java.util.*;
import java.util.Map.Entry;

public class Hash_map_demo {

	public static void main(String[] args) 
	{
		Map <String,String> map= new HashMap<String,String>();
		
		map.put("India", "Delhi");
		map.put("USA", "DC");
		map.put("Canada", "Oatawa");
		map.put("Pakistan", "Islamabad");
		
		Iterator <Entry<String,String>> it = map.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<String,String> entry=it.next();
			System.out.println(entry);
		}
		System.out.println("------------------------------------"); 
		
		//lambda iteration method (java 8)
//		map.forEach((k,v)-> System.out.println("Key is="+ k+" and Value is =" +v));;

	}

}
