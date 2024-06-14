package Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Read_Data_from_PropertyFile 
{
	WebDriver driver;
	public static Properties readconfigFile() throws IOException
	{
		
		String path="C:\\Users\\kumar\\AppiumLearning\\SeleniumPractice\\config.properties";
		Properties properties= new Properties();
		FileInputStream fileInputStream = new FileInputStream(path);
		properties.load(fileInputStream);
		return properties;
		
		
	}
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		
		driver= new ChromeDriver();	
		String url= readconfigFile().getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2500);
		
	}
	@Test
	public void test_01() throws IOException
	{		
		String user_name= readconfigFile().getProperty("username");
		String password= readconfigFile().getProperty("password");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(user_name);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@AfterMethod
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.close();
	}

	
}
