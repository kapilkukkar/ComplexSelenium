package Selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeOptions_Demo
{

	public WebDriver driver;
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"} );
		File path=new File("C:\\Users\\kumar\\AppiumLearning\\SeleniumPractice\\jobalytics.crx");
		options.addExtensions(path);
		driver= new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		Thread.sleep(5500);
		
	}
	@Test
	public void test_01() throws IOException
	{
		System.out.println(driver.getTitle());	
		
	}
	@AfterMethod()
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.close();
	}

}
