package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Challenges 
{
	WebDriver driver;
	@BeforeMethod
	public void set_up()
	{
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		driver= new ChromeDriver(options);
		driver.get("https://www.worldometers.info/world-population/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();		
	}
	@Test
	public void test_01() throws InterruptedException
	{
		int count=1;
		while(count<=2)
		{
			WebElement world_count=driver.findElement(By.xpath("//div[@class='maincounter-number']"));
			System.out.println(world_count.getText());
			List<WebElement> elements= driver.findElements(By.xpath("//div[@class='sec-counter']"));
			for(WebElement element: elements)
			{
				System.out.println(element.getText());
			}
			Thread.sleep(1000);
			count++;
		}

	}
	@AfterMethod
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.close();
	}
}
