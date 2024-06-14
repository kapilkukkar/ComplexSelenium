package Learning.Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser 
{

	WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	public void LaunchBrowser(String browser)
	{
		switch(browser.toLowerCase())
		{
		case"chrome":

			WebDriver driver = new ChromeDriver();
			break;
		case"firefox":			
			driver = new FirefoxDriver();
			break;	
		case"msedge":			
			driver= new EdgeDriver();
			break;
		default:

			driver=null;
			break;
		}}
	@Test
	public void verifyTitle()
	{
		driver.get("https://www.google.com/");
		String actual="Google";

		String expected= driver.getTitle();

		Assert.assertEquals(actual,expected);
	}

	@AfterMethod

	public void quit()
	{
		driver.quit();
	}

}
