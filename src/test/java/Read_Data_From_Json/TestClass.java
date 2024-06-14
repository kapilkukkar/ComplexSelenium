package Read_Data_From_Json;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass 
{
	WebDriver driver;
	UtilJsonClass utilsClass;
	@BeforeMethod
	public void setup() throws InterruptedException, FileNotFoundException
	{
		String file_path=System.getProperty("user.dir") +"//src/test//java//Read_Data_From_Json//data.json";		
		utilsClass= new UtilJsonClass(file_path);
		String url= utilsClass.getValue("url");
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2500);
	}
	@Test
	public void test_01()
	{
		String username=utilsClass.getValue("username");
		String password=utilsClass.getValue("password");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
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
