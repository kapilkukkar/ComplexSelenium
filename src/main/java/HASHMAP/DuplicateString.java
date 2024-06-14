package HASHMAP;

import java.util.*;
import java.util.Map.Entry;

//import org.testng.annotations.Test;

public class DuplicateString {

	public static void main(String[] args)
	{
		String arr[]= {"Selenium","Amazon","Azure","Amazon","GCP","Selenium","Azure","Amazon","AliBaba","SauceLab","Azure","GCP"};

		Map<String,Integer> map= new HashMap<String,Integer>();
		for(String e:arr)
		{
			Integer count= map.get(e);
			if(count == null)
			{
				map.put(e, 1);
			}
			else
			{
				map.put(e, ++count);
			}
			
			
		}
	
	Set<Entry<String,Integer>>entry_set= map.entrySet();
	for(Entry<String,Integer>entry:entry_set)//for printing
	{
		if(entry.getValue()>1)
		{
			System.out.println(entry.getKey()+" = "+ entry.getValue());
		}
	}
		


	}
}


