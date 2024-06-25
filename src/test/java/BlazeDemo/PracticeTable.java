package BlazeDemo;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;

import com.github.javafaker.Faker;

public class PracticeTable 
{

	WebDriver driver;
	Faker faker= new Faker();
	public static String random_month()
	{
		String[] months = {"January", "February", "March", "April", "May", "June", "July",
				"August", "September", "October", "November", "December"};
		Random random = new Random();
		String randomMonth = months[random.nextInt(months.length)];
		return randomMonth;

	}
	public  String get_Screenshot(WebDriver driver, String testName) throws IOException
	{
	    String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
	    String filePath = "./screenshots/" + testName + "_" + timestamp + ".png";
	    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);    
	    try 
	    {
	    	FileUtils.copyFile(srcFile, new File(filePath));	 
	    } 
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return filePath;
	}
	@BeforeMethod
	public void setup()
	{
		driver= new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement dropdown_1= driver.findElement(By.xpath("//select[@name='fromPort']"));
		WebElement dropdown_2= driver.findElement(By.xpath("//select[@name='toPort']"));
		Select select_1 = new Select(dropdown_1);
		Select select_2 = new Select(dropdown_2);
		select_1.selectByValue("Boston");
		select_2.selectByValue("Dublin");		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
	}

	@Test
	public void test_01() throws InterruptedException
	{
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table']//td[6]"));
		double total_sum=0;

		for(WebElement elements: list)
		{
			String elementString = elements.getText().substring(1);
			double integer_element=Double.parseDouble(elementString);
			total_sum= integer_element+total_sum;

		}
		System.out.println(total_sum);		
	}
	@Test
	public void test_02() throws InterruptedException
	{
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table']//td[6]"));
		List<Double> prices= new ArrayList<Double>();
		for(WebElement element: list)
		{
			String elementString = element.getText().substring(1);
			double price=Double.parseDouble(elementString);
			prices.add(price);

		}
		Collections.sort(prices);

		if(prices.get(0)==200.98)
		{
			driver.findElement(By.xpath("//table[@class='table']//tr[3]//td[1]//input")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys(faker.name().firstName());
			driver.findElement(By.xpath("//input[@id='address']")).sendKeys(faker.address().fullAddress());
			driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().cityName());
			driver.findElement(By.xpath("//input[@id='state']")).sendKeys(faker.address().state());
			driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys(faker.address().zipCode());
			WebElement dropDown_list= driver.findElement(By.xpath("//select[@name='cardType']"));
			Select select = new Select(dropDown_list);
			select.selectByValue("dinersclub");
			driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys(faker.finance().creditCard());
			driver.findElement(By.xpath("//input[@id='creditCardMonth']")).clear();
			driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys(random_month());			
			String random_year=String.valueOf(faker.number().numberBetween(1900, 2024));
			driver.findElement(By.xpath("//input[@id='creditCardYear']")).clear();
			driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys(random_year);			
			driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys(faker.name().fullName());
			driver.findElement(By.xpath("//input[@id='rememberMe']")).click();
			driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

		}
		else
		{
			System.out.println("Array is not sorted");	
		}
	}
	@Test
	public void test_03()
	{
		throw new SkipException("Intentionally skipping this method to genrate Extent report");
	}
	@Test
	public void test_04()
	{
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='table']//td[6]"));
		double total_sum=0;

		for(WebElement elements: list)
		{
			String elementString = elements.getText().substring(1);
			double integer_element=Double.parseDouble(elementString);
			total_sum= integer_element+total_sum;

		}
		assertEquals(2105.82, 2015);	
	}
	@AfterMethod

	public void teardown(ITestResult result) throws IOException
	{
		if (ITestResult.FAILURE == result.getStatus()) 
		{
			get_Screenshot(driver,result.getName());
		}
		driver.close();	
	}

}
