package Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class broken_links 
{
	//Run This Class With TestNG.xml File ("UrlParameter")
	WebDriver driver;
	@BeforeMethod
	@Parameters("url")
	public void set_up(String url)
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver= new ChromeDriver(options);		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test()
	public void get_all_url() throws InterruptedException, IOException
	{
		List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(WebElement link: links)
		{
			String urls= link.getAttribute("href");
			if(urls!= null)
			{
				URL create_url=new URL(urls);
				HttpURLConnection httpconection= (HttpURLConnection) create_url.openConnection();
				httpconection.setRequestMethod("HEAD");
				httpconection.connect();
				int responseCode=httpconection.getResponseCode();
				if(responseCode==200)
				{
					System.out.println("Valid link");
				}
				else
				{
					System.out.println("Broken Link");
					
				}
			}
			
			Thread.sleep(1000);
		}
		
	}
	@Test
	public void broken_link() throws InterruptedException, IOException
	{
		List<WebElement> links= driver.findElements(By.tagName("a"));
		int brokernlink=0;
		int valid_link=0;
		for(WebElement link: links)
		{
			String urls= link.getAttribute("href");
			if(urls!=null)
			{
				URL link_url = new URL(urls);
				HttpURLConnection connection = (HttpURLConnection) link_url.openConnection();
				connection.setRequestMethod("HEAD");
				connection.connect();
				int response_code= connection.getResponseCode();
				if(response_code == 200)
				{
					System.out.println(urls + "- Valid Link");
					valid_link++;
					
				}
				else
				{
					System.out.println(urls + "- Broken Link");
					brokernlink++;
				}
				
				Thread.sleep(500);
			}
			else
			{
			 System.out.println("Null URL");	
			}
			System.out.println("Broken Links Count:"+brokernlink);
			System.out.println("Valid Link Count:"+valid_link);
			
		}
	}
	@AfterMethod
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.close();
	}

}
