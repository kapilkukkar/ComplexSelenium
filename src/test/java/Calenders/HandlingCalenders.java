package Calenders;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.bytebuddy.implementation.bytecode.member.FieldAccess.Defined;

public class HandlingCalenders 
{
	String expected_year;
	String expected_month;
	String expected_day;
	String expected_date;
	WebDriver driver;
	
	
	public static String expected_year(String expected_year)
	{
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld=LocalDate.parse(expected_year,dtf);
		int year= ld.getYear();
		String expect_year= String.valueOf(year);
		return expect_year;
		
	}
	public static String expected_month(String expected_month)
	{
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld=LocalDate.parse(expected_month,dtf);
		Month month = ld.getMonth();
		String monthString= month.toString();
		String lowercaseString=monthString.toLowerCase();
		String expectedmonth= lowercaseString.substring(0,1).toUpperCase()+ lowercaseString.substring(1);
		return expectedmonth;
		
		
	}
	public static String expected_day(String expected_day)
	{
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld= LocalDate.parse(expected_day,dtf);
		int day= ld.getDayOfMonth();
		String expectedday=	String.valueOf(day);		
		return expectedday;
		
	}
	
	@BeforeMethod
	public void setup()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the date Plz:");
		expected_date= scanner.nextLine();
		expected_year=expected_year(expected_date);
		expected_month=expected_month(expected_date);
		expected_day=expected_day(expected_date);
		scanner.close();
		driver=new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test
	public void simple_calender() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();		
		while(true)
		{
			String current_month = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-month']")).getText();
			String current_year=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-year']")).getText();

			if(current_month.equals(expected_month) && current_year.equals(expected_year))
			{
				List<WebElement> days_list=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td[normalize-space(text())='']"));

				for(WebElement day: days_list)
				{
					String actual_day= day.getText();
					if(actual_day.equals(expected_day))
					{
						day.click();
						return;
					}
				}


			}
			else
			{
				WebElement next_button=driver.findElement(By.xpath("//span[normalize-space()='Next']"));
				next_button.click();
				wait.until(ExpectedConditions.stalenessOf(next_button));
			}

		}
		 
	}
	

	@AfterMethod

	public void tear_down() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.close();
	}

}
