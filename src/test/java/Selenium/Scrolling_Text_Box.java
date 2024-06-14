package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Scrolling_Text_Box 
{
	static WebDriver driver;
	Faker faker;
	public static  WebElement text_box;
	public static JavascriptExecutor js;
	public static void scroll_into_view()
	{
		js.executeScript("arguments[0].scrollIntoView()", text_box);
	}
	public static void scroll_text_area() throws InterruptedException
	{		
		js.executeScript("arguments[0].scrollTop = 207", text_box);
		Thread.sleep(2500);
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", text_box);
		
	}
	@BeforeMethod
	public void setup()
	{
		driver= new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		text_box= driver.findElement(By.xpath("//textarea[@id='ta1']"));
		js= (JavascriptExecutor) driver;
	}
	@Test
	public void test_01() throws InterruptedException
	{
		faker= new Faker();
		scroll_into_view();
		text_box.sendKeys(faker.lorem().paragraph(50));
		Thread.sleep(2500);
		scroll_text_area();
		Thread.sleep(2500);
		
	}
	@AfterMethod
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.close();
	}

}
