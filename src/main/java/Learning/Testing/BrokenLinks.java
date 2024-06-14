package Learning.Testing;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

import java.io.IOException;
import java.net.*;

public class BrokenLinks 
{

	public static void main(String[] args) throws IOException, InterruptedException  
	{
		
		WebDriver driver = new ChromeDriver();		
		//driver.get("http://www.deadlinkcity.com/");
		driver.get("http://www.zlti.com");
		Thread.sleep(2000);		
		List <WebElement> link = driver.findElements(By.tagName("a"));		
		System.out.println("total links are :" +link.size());		
		for(int i=0;i<link.size();i++)
		{
			WebElement element = link.get(i);
			String url= element.getAttribute("href");			
			URL links = new URL(url);			
			HttpURLConnection httpcon = (HttpURLConnection) links.openConnection();//create a connection using url 
			Thread.sleep(250);			
			httpcon.setRequestMethod("HEAD");//establish a connection
			httpcon.connect();
			
			int responsecode=httpcon.getResponseCode();	
			
			if(responsecode >=400)
			{
				System.out.println(url + "- broken link");
			}
			else
			{
				System.out.println(url + "- valid link");
			}	
			
		}
				
		driver.close();
	}
}


