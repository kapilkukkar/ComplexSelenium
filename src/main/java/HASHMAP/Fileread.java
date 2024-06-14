package HASHMAP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Fileread 
{
	static String path="C:\\Users\\kumar\\eclipse-workspace\\Testing\\src\\main\\resourse\\sample.text";

	public static void main(String[] args) 

	{
		Map<String,Integer> wordmap= new HashMap<String,Integer>();

		BufferedReader reader = null;
		try 
		{
			reader = new BufferedReader(new FileReader(path));
			String currentline= reader.readLine();
			while(currentline != null)
			{
				String words[]=currentline.toLowerCase().split(" ");
				for(String word: words)
				{
					if(!word.isBlank())
					{
						if(wordmap.containsKey(word))
						{
							wordmap.put(word, wordmap.get(word)+1);

						}
						else
						{
							wordmap.put(word,1);
						}
					}
				}
				currentline= reader.readLine();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		finally
		{
			try 
			{
				reader.close();
			} 
			catch (IOException e) 
			{

				e.printStackTrace();
			}
		}
//		wordmap.forEach((k,v)-> System.out.println(k+ "="+v));
//		Map<String,Integer> maxmap= new HashMap<String,Integer>();
//		wordmap
//		.entrySet()
//		.stream()
//		.filter(entry -> entry.getValue()== Collections.max(wordmap.values()))
//		.forEach(e->maxmap.put(e.getKey(),e.getValue()));
//
//		System.out.println(maxmap);

	}

}
