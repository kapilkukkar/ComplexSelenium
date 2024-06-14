package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutor_demo 

{
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://letcode.in/shadow");
		driver.manage().window().maximize();
	}
	@Test
	public void handling_shadow_DOM()
	{
		JavascriptExecutor js= (JavascriptExecutor) driver;
		WebElement element1=(WebElement)js.executeScript("return document.querySelector(\"#open-shadow\").shadowRoot.querySelector(\"#fname\")");
		String valueString= "arguments[0].value='Kapil';";
		js.executeScript(valueString, element1);
	}
	@Test
	public void Shadow_dom_without_javaScript()
	{
		driver.findElement(By.id("open-shadow")).getShadowRoot().findElement(By.cssSelector("#fname")).sendKeys("Kapil");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).sendKeys("Kukkar").sendKeys(Keys.TAB).sendKeys("abc@gmail.com").perform();;
	}
	@Test
	public void heighlight_element() throws InterruptedException//website is diffrent make sure
	{
		WebElement element= driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		WebElement element1= driver.findElement(By.xpath("//button[@onclick='myFunctionAlert()']"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", "");
		js.executeScript("arguments[0].setAttribute('style','background:yellow;border:2px solid red;');"+
				         "arguments[1].setAttribute('style','background: red;  border:4px solid black;');", element,element1);		
	}
	@AfterMethod
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.close();
	}
	
}
