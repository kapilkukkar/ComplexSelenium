package Shadow_Dom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Handle_shadow_dom 
{
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
	}
	@Test
	public void test_01()
	{
		JavascriptExecutor js =  ((JavascriptExecutor)driver);
		WebElement element= (WebElement)js.executeScript("return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")");
		String value= "arguments[0].value='kapil';";
		js.executeScript(value, element);
	
	}
	@AfterMethod
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.close();
	}
}
