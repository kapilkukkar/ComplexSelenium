package Learning.Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
public class TestNGDemo 
{
	WebDriver driver;
	
	@Test(expectedExceptions = InterruptedException.class)
	public void verify() throws InterruptedException 
	{
		

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);

		String actual = driver.getTitle();
		
		String expected= "Google";
	
		Assert.assertEquals(expected, actual);
		driver.close();
		
	}
	@Test(expectedExceptions = ArithmeticException.class)
	public void test()
	{
		int i =1/0;
	}
	
	
}
