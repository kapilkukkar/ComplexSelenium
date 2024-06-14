package Learning.Testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.interactions.Actions;
public class Acton
{
	WebDriver driver;
	@Test
	public void Keyboard_actions() throws InterruptedException
	{
		
		driver= new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/key_presses");
		//Actions action = new Actions(driver);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.SPACE).perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(1000);
		driver.close();		
	}
	@Test
	public void compare_Text() throws InterruptedException
	{
		
		driver= new FirefoxDriver();
		driver.get("https://text-compare.com/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("i am Learning");
		Actions action= new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		action.sendKeys(Keys.TAB).build().perform();
		WebElement text_box= driver.findElement(By.xpath("//textarea[@id='inputText2']"));
		text_box.click();
		action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).keyUp(Keys.CONTROL).perform();
		driver.findElement(By.xpath("//div[@class='compareButtonText']")).click();
		Thread.sleep(2000);
		WebElement text= driver.findElement(By.xpath("//span[@class='messageForUser']"));
		String expected= text.getText();
		System.out.println(expected);
		String actual="The two texts are identical!";
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
		driver.close();	
		
	}
	@Test
	public void test() throws InterruptedException
	{
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[@role='button']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys("macbook");

		Thread.sleep(4000);
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='YGcVZO _2VHNef']"));
		for(WebElement element : list)
		{
			System.out.println(element.getText());
		}
		driver.close();
	}
}

