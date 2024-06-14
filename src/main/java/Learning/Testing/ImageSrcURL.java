package Learning.Testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class ImageSrcURL {

	@Test
	public void test()
	{
		
		WebDriver driver = new ChromeDriver();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement logo=driver.findElement(By.xpath("//img[@alt='Google']"));
		System.out.println("value is= " + logo.getAttribute("src"));
		driver.close();

	}
	@Test
	public void test3() throws InterruptedException
	{

		WebDriver driver = new ChromeDriver();
		driver.get("https://automationqahub.com/latest-api-testing-interview-questions-and-answers/");
		driver.manage().window().maximize();
		if(driver.findElement(By.xpath("//img[@alt='Buy Me A Coffee']")).isDisplayed())
		{
			System.out.println("Element is Present");
		}
		else
		{
			System.out.println("Element is Not Present");
		}
		boolean text=driver.getPageSource().contains("Buy Me A Coffee");
		System.out.println(text);
		Thread.sleep(2000);
		driver.close();
		
	}
	@Test
	public void test2() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("document.getElementById("").value=""")
		//js.executeScript("document.getElementByID('sb_form_q').value ='Taj Mahal';");
		js.executeScript("document.getElementById('sb_form_q').setAttribute('value', 'Taj Mahal');");
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(3000);
		driver.close();
	}
	

}
