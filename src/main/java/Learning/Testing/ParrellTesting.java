package Learning.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ParrellTesting 
{   
	WebDriver driver;
	
	@Test
	public void verifyTitle() throws InterruptedException
	{
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		String actual= driver.getTitle();	
		String expected="Swag Labs";
		
		Assert.assertEquals(actual,expected);
		Thread.sleep(1500);
		driver.close();
	}
		@Test
		public void verifyLogo()
		{
			driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			
			WebElement actuallogo = driver.findElement(By.xpath("//div[@class='login_logo']"));
			
			Assert.assertTrue(actuallogo.isDisplayed());
			driver.close();
			
		}
		
	
}
