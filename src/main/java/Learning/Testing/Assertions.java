package Learning.Testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Assertions 
{
	@Test
	public void testmethod()
	{
		
		WebDriver driver = new ChromeDriver();
		SoftAssert soft = new SoftAssert();
		driver.get("https://testautomationpractice.blogspot.com/");

		System.out.println("verifying Title");
		String expected=driver.getTitle();
		String actual= "Automasting Practi";
		soft.assertEquals(actual,expected);

		System.out.println("verifying wikipedia icon");		
		WebElement icon=driver.findElement(By.className("wikipedia-icon"));
		soft.assertTrue(icon.isDisplayed());

		System.out.println("verifying Search button");		
		WebElement button=driver.findElement(By.className("wikipedia-search-button"));
		soft.assertTrue(button.isDisplayed());

		driver.close();
		// report all softassert failure method
		//soft.assertAll();
	}
	@Test
	public void test() throws InterruptedException
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		Thread.sleep(2000);
		List <WebElement> list1 = driver.findElements(By.xpath("//div[@class='card h-100']/div/h4/a"));
		List<WebElement> list2 = driver.findElements(By.xpath("//app-card//div[1]//div[1]//h4[1]"));
		//List <WebElement> list1 = driver.findElements(By.cssSelector("div[class='card h-100']"));
		System.out.println("Size of List is :"+list1.size());
		for(WebElement e : list2)
		{
		System.out.println("name of the items are :"+e.getText());	
		}
		driver.close();		

	}
	@Test
	public void test5()
	{
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--incognito");
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		options.merge(capabilities);
		WebDriver driver = new ChromeDriver(options);		
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();		
		driver.close();
		}
		
	}





