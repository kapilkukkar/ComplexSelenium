package Learning.Testing;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.*;

public class Waits
{
	WebDriver driver;
	@Test
	public void implicit() throws InterruptedException
	{
		//WebDriverManager.firefoxdriver().setup();
		//driver= new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver= new ChromeDriver();
		driver.get("https://www.google.ca/");
		driver.manage().window().maximize();

		WebElement text_box=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		text_box.sendKeys("Selenium");
		text_box.sendKeys(Keys.ENTER);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread.sleep(1000);
		System.out.println(driver.getTitle());
		driver.close();


	}

	public static WebElement wait_for_element_method(WebDriver driver,By locator,int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}
	@Test
	public void explicit()
	{
		
		driver= new FirefoxDriver();
		driver.get("https://www.google.ca/");
		driver.manage().window().maximize();

		WebElement text_box=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		text_box.sendKeys("Selenium");
		text_box.sendKeys(Keys.ENTER);
		By locator = By.xpath("//h3[normalize-space()='Selenium']");
		//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//		
		//		WebElement element = wait.until(ExpectedConditions
		//				             .visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Selenium']")));
		//System.out.println(element);
		wait_for_element_method(driver,locator,10);
		System.out.println(driver.getTitle());
		driver.close();


	}
	public static WebElement fluent_wait_function(WebDriver driver,  By locator)
	{
		Wait<WebDriver> mywait= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		mywait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}
	@Test
	public void fluent() throws InterruptedException
	{
		
		driver= new FirefoxDriver();
		driver.get("https://www.google.ca/");
		driver.manage().window().maximize();

		WebElement text_box=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		text_box.sendKeys("Selenium");
		text_box.sendKeys(Keys.ENTER);
	
		By locator = By.xpath("//h3[normalize-space()='Selenium']");
	//	WebElement locator1= driver.findElement(By.xpath("//h3[normalize-space()='Selenium']"));
		//wait_for_element_method(driver, locator, 10);
		fluent_wait_function(driver, locator);
		
		//declaration of Fluent Wait
//		Wait<WebDriver> mywait= new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(30))
//				.pollingEvery(Duration.ofSeconds(15))
//				.ignoring(NoSuchElementException.class);
//		
//		WebElement element = mywait.until(new Function <WebDriver,WebElement>()
//		{
//			public WebElement apply(WebDriver driver) 
//			{
//				return driver.findElement(By.xpath("//h3[normalize-space()='Selenium']"));
//			}
//		}
//		);
	//	locator.click();
		System.out.println(driver.getTitle());
		driver.close();


	}
	@Test
	public void test()
	{
		
		driver= new FirefoxDriver();
		driver.get("https://www.google.ca/");
		driver.manage().window().maximize();

		WebElement text_box=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		text_box.sendKeys("Selenium");
		text_box.sendKeys(Keys.ENTER);
		
		Wait<WebDriver> mywait= new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		WebElement element=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Selenium']")));
		element.click();
		System.out.println(driver.getTitle());
		driver.close();
	}
}
