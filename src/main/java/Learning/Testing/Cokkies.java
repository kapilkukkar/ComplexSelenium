package Learning.Testing;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cokkies {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		Set <Cookie> cookiesList=driver.manage().getCookies();

		int x= cookiesList.size();
		System.out.println("Total number of cookies before:" + x);
		for(Cookie ck:cookiesList)
		{
			System.out.println( ck.getName()+ "=" + ck.getValue());	
		}
		/*
		 * System.out.println("Looking for Cookie name");
		 * System.out.println(driver.manage().getCookieNamed("GPS"));
		 */
		Cookie obj= new Cookie("Testing","www.youtube.com");
		driver.manage().addCookie(obj);
		Set <Cookie> cookiesList1=driver.manage().getCookies();
		int y= cookiesList1.size();
		System.out.println("Total number of cookies after:" + y);
		for(Cookie ck:cookiesList1)
		{
			System.out.println( ck.getName()+ "=" + ck.getValue());	
		}
		/*
		 * driver.manage().deleteCookie(obj); Set <Cookie>
		 * cookiesList2=driver.manage().getCookies();
		 */
		driver.manage().deleteCookie(obj);
		Set <Cookie>cookiesList2=driver.manage().getCookies();
		int z= cookiesList2.size();
		System.out.println("Total number of cookies after:" + z);
		driver.close();
	}

}
