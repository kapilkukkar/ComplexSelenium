package Shadow_Dom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Nested_Shadow 
{

	WebDriver driver;
	JavascriptExecutor js;
	@BeforeMethod
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://dev.automationtesting.in/shadow-dom");
		driver.manage().window().maximize();
	}
	@Test
	public void test_01()
	{
		js =  ((JavascriptExecutor)driver);
		WebElement element= (WebElement)js.executeScript("return document.querySelector(\"#shadow-root\").shadowRoot.querySelector(\"#inner-shadow-dom\").shadowRoot.querySelector(\"#nested-shadow-element\")");
		String text = (String) js.executeScript("return arguments[0].innerText;", element);
		System.out.println(text);

	}
	@Test
	public void test_02()
	{
		js= (JavascriptExecutor)driver;
		WebElement element=(WebElement)js.executeScript("return document.querySelector(\"#shadow-root\").shadowRoot.querySelector(\"#inner-shadow-dom\").shadowRoot.querySelector(\"#nested-shadow-dom\").shadowRoot.querySelector(\"#multi-nested-shadow-element\")");
		String text=(String) js.executeScript("return arguments[0].innerText;", element);
		System.out.println(text);
	}
	@AfterMethod
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.close();
	}
}
