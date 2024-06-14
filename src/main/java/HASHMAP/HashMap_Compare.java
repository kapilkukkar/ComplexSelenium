package HASHMAP;

import java.util.*;
import java.util.Map.Entry;
public class HashMap_Compare {

	public static void main(String[] args)
	{
		Map <String,String> map= new HashMap<String,String>();

		map.put("India", "Delhi");
		map.put("USA", "DC");
		map.put("Canada", "Oatawa");
		map.put("Pakistan", "Islamabad");
		//map.put("Afgan", "Kabul");
		map.put("Pakistan", "Fazilka");
		
		Map <String,String> map2= new HashMap<String,String>();
		map2.put("India", "Delhi");
		map2.put("USA", "DC");
		map2.put("Canada", "Oatawa");
		map2.put("Pakistan", "Islamabad");
	//	map2.put("China", "Bejing");		
		
		//Compare two hash map	by Key	
		System.out.println(map2.keySet().equals(map.keySet()));
		//take out extraKey from HashMap
		
//		HashSet<String> combinekey= new HashSet<>();//		
//		combinekey.addAll(map.keySet());
//		combinekey.addAll(map2.keySet());
//		combinekey.removeAll(map.keySet());
//		
//		System.out.println(combinekey);
		
		//compare two hashmap with by value set		
		//1.duplicates are not allowed
	//System.out.println(new ArrayList<>(map.values()).equals(new ArrayList<>(map2.values())));
		//System.out.println(new ArrayList<>(map.values()).equals(new ArrayList<>(map2.values())));
		//2.Duplicates are allowed
		
		
	}
	

}
