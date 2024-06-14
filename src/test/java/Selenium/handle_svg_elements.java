package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class handle_svg_elements 
{

	static WebDriver driver;
	public static void scroll_into_view()
	{
		WebElement element= driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	@BeforeMethod	
	public void set_up()
	{
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		//options.addArguments("--headless=new");
		driver= new ChromeDriver(options);
		driver.get("https://emicalculator.net/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();		
	}
	@Test
	public void test_01() throws InterruptedException
	{
		scroll_into_view();
		List<WebElement> list=driver.findElements(By.xpath("(//*[local-name()='svg'])[2]//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']"));
		Actions actions = new Actions(driver);
		for(WebElement element: list)
		{
			actions.moveToElement(element).perform();
			String xpathString="(//*[name()='svg']//*[local-name()='g' and @class='highcharts-label highcharts-tooltip highcharts-color-undefined']//*[name()='text']//*[name()='tspan'])[2]";
			Thread.sleep(500);
			String text=driver.findElement(By.xpath(xpathString)).getText();
			System.out.println(text.split(" ")[3]);
			
		}
		

	}
	@Test
	public void test_02()
	{
		List<WebElement> list= driver.findElements(By.xpath("(//*[name()='svg'])[1]//*[name()='g' and @class='highcharts-series-group']//*[name()='path']"));
		for(WebElement element:list)
		{
			System.out.println(element.getText());
		}
	}
	@AfterMethod
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.close();
	}
}
