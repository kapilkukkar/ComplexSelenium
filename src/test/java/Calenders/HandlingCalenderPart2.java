package Calenders;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback;

public class HandlingCalenderPart2 
{
	static WebDriver  driver;
	String desired_date;
	String desired_day;
	String desired_month;
	public static String desired_year;
	public static void scroll_into_veiw()
	{
		WebElement element= driver.findElement(By.xpath("//h2[normalize-space()='Find A Travel Companion']"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	public static String extracted_day(String day)
	{
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld= LocalDate.parse(day,dtf);
		int day_integer= ld.getDayOfMonth();
		String actual_day= String.valueOf(day_integer);
		return actual_day;

	}
	public static String extracted_month(String month)
	{
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld= LocalDate.parse(month,dtf);
		Month month2= ld.getMonth();
		String monthString= month2.toString();
		String lowercaseString= monthString.toLowerCase();
		String actual_month= lowercaseString.substring(0,1).toUpperCase()+lowercaseString.substring(1);		
		return actual_month;
	}
	public static String extracted_year(String year)
	{
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld= LocalDate.parse(year,dtf);
		int year_integer= ld.getYear();
		String actaul_year= String.valueOf(year_integer);
		return actaul_year;
	}
	@BeforeMethod 	
	public void setup()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the desired date");
		desired_date= scanner.nextLine();
		desired_day=extracted_day(desired_date);
		desired_month= extracted_month(desired_date);
		desired_year=extracted_year(desired_date);
		scanner.close();
		driver= new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		//driver.get("https://www.semrush.com/website/lemonde.fr/overview/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void test_01() throws InterruptedException
	{
		scroll_into_veiw();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']")).click();
		WebElement actual_year= driver.findElement(By.xpath("//input[@class='numInput cur-year']"));

		
		while(!desired_year.equals(actual_year.getAttribute("value")))
		{
			WebElement arrow_up= driver.findElement(By.xpath("//span[@class='arrowUp']"));
			arrow_up.click();

		}
		while (true) 
		{
			
			WebElement actaul_month=driver.findElement(By.xpath("//span[@class='cur-month']"));
			String actualMonthText = actaul_month.getText();
			Month actualMonth = Month.valueOf(actualMonthText.toUpperCase()); // Parse the month string to Month enum
		    Month desiredMonth = Month.valueOf(desired_month.toUpperCase()); // Parse the desired month string to Month enum

		    int comparison = actualMonth.compareTo(desiredMonth);
		    if (comparison == 0) 
		    {
		        break; 
		    } 
		    else if (comparison < 0)
		    {
		       
		        driver.findElement(By.xpath("//span[@class='flatpickr-next-month']//*[name()='svg']")).click();
		    } 
		    else 
		    {
		        
		        driver.findElement(By.xpath("//span[@class='flatpickr-prev-month']//*[name()='svg']")).click();
		    }

		    Thread.sleep(500);
		}
		
		while(true)
		{
			List<WebElement> day_list= driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
			for(WebElement day:day_list)
			{
				if(day.getText().equals(desired_day))
				{
					day.click();
					return;
				}
			}
		}
		


	}
	@Test
	public void get_window_handle()
	{
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles.size());
		List<String> newliSt= new ArrayList<String>(handles);
		System.out.println(newliSt.get(0));
	}
	@Test(enabled = false)
	public void check_language()
	{
		System.out.println("Driver language: " + ((JavascriptExecutor) driver).executeScript("return window.navigator.language"));
	}
	

	@AfterMethod
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(5500);
		driver.close();
	}

}
