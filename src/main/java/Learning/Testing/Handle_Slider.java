package Learning.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class Handle_Slider 
{
	WebDriver driver;
	@Test
	public void slider()
	{
		
		driver= new FirefoxDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		WebElement slide= driver.findElement(By.xpath("//span[1]"));
		WebElement slide1= driver.findElement(By.xpath("//span[2]"));
		Point location= slide.getLocation();
		System.out.println(location);//59,249
		Point location_max= slide1.getLocation();
		System.out.println(location_max);//619,249
		Actions action= new Actions(driver);
		action.dragAndDropBy(slide, 101, 0).perform();
		action.dragAndDropBy(slide1, -100,200).perform();
		
		Point new_location= slide.getLocation();
		System.out.println(new_location);
		driver.close();
		
		
	}
}
