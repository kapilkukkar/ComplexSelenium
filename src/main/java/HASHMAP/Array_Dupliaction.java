package HASHMAP;

import org.testng.annotations.Test;
import java.util.*;
import java.util.Map.Entry;


public class Array_Dupliaction 
{

	String arr[]= {"Amazon","Azure","GCP","Selenium","Amazon","AliBaba","SauceLab","Azure","GCP"};
	//String arr[]= {"Selenium","Amazon","Azure","Amazon","GCP","Selenium","Azure","Amazon","AliBaba","SauceLab","Azure","GCP"};
	
	@Test
	public void Brut_Force()
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i].equals(arr[j]))
				{
					System.out.println(arr[i]);
				}
			}
		}
		
	}
	@Test
	public void HashSet()
	{
	Set<String> set = new HashSet<String>();
	for(String e:arr)
	{
		if(set.add(e)== false)
		{
			System.out.println(e);
		}
	}
		
	}
	@Test
	public void HashMap()
	{
		Map<String,Integer> map = new HashMap<String,Integer>();
		for (String e: arr)
		{
			Integer count = map.get(e);
			if (count== null)
			{
				map.put(e, 1);
			}
			else 
			{
			map.put(e, ++count);
			}
				
		}
		//print the HashMap
		Set <Entry<String,Integer>>entry_set= map.entrySet();
		for(Entry<String,Integer>entry:entry_set)
		{
			if(entry.getValue()>1)
			{
				System.out.println(entry.getKey()+" = "+ entry.getValue());
			}
		}		
	}
	@Test
	public void test()
	{
		String str="$9000";
		String a= str.replaceAll("[$]", "");
		
		
		System.out.println(a);
	}
	@Test
	public void test1()
	{
		String str="Kapil%^&*#G";
		//String str1= str.replaceAll("[0-9a-zA-Z]", "");
        String str1 = str.replaceAll("\\W", "");

		System.out.println(str1);
				
	}
	@Test
	public void split()
	{
		String pop="xXheloois hersjlfjljlls";
		String p[]=pop.split("xX");
		System.out.println(p[0].length());
		System.out.println(p[1].length());
		//System.out.println(p[2]);
	}
}
