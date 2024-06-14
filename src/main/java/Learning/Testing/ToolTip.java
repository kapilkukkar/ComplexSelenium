package Learning.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ToolTip 
{
	WebDriver driver;

	@Test
	public void ToolTip() throws InterruptedException
	{

	
		driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='Tooltip']")).click();
		driver.switchTo().frame(0);
		WebElement input_box= driver.findElement(By.xpath("//input[@id='age']"));
		String title = input_box.getAttribute("title");
		System.out.println(title);
		Thread.sleep(2000);
		driver.close();
		
	}
	@Test
	public void using_Chord() throws InterruptedException
	{
		
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//String tab= Keys.chord(Keys.CONTROL,Keys.ENTER);
		WebElement new_link=driver.findElement(By.xpath("//a[@class='ico-register']"));
		//new_link.sendKeys(tab);
		new_link.click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println(title);
		driver.quit();
		
	}
	@Test
	public void test3()
	{
		
		driver= new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://jqueryui.com/");
		String title1 = driver.getTitle();
		System.out.println(title1);
		driver.quit();
		
	}
	@Test
	public void capture_size_WebElement()
	{
		
		driver= new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		WebElement logo= driver.findElement(By.xpath("//img[@alt='company-branding']"));
		Point location= logo.getLocation();//getRect also user to get coordinates of the Logo
		System.out.println(location);
		System.out.println(logo.getSize());
		System.out.println(logo.getRect().getHeight());//another method for dimensions
		System.out.println(logo.getRect().getWidth());
		
		driver.close();
		
	}
}
