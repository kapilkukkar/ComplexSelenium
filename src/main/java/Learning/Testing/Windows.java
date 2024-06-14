package Learning.Testing;

import org.testng.annotations.Test;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class Windows
{

	@Test(enabled=false)
	public void test1()
	{

		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.amazon.ca/");
		driver.quit();
	}
	@Test
	public void test2()
	{
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com/");
	}
}
