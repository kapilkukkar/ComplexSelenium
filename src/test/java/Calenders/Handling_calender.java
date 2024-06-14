package Calenders;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Handling_calender 
{
	static WebDriver driver;
	String desired_date;
	String desired_day;
	String desired_month;
	String desired_year;
	public static void scroll_into_view()
	{
		WebElement element= driver.findElement(By.xpath("//input[@id='datepicker']"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		
	}
	public String expected_day(String day)
	{
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld= LocalDate.parse(day,dtf);
		int dateinteger= ld.getDayOfMonth();
		String ecpect_dayString= String.valueOf(dateinteger);
		return ecpect_dayString;

	}
	public String expected_month(String month)
	{
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld= LocalDate.parse(month,dtf);
		Month month2= ld.getMonth();
		String montthString= month2.toString();
		String lowercaseString= montthString.toLowerCase();
		String expected_monthString=lowercaseString.substring(0, 1).toUpperCase()+lowercaseString.substring(1);
		return expected_monthString;

	}
	public String expected_year(String year)
	{
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate ld=LocalDate.parse(year,dtf);
		int year_integer= ld.getYear();
		String expect_year= String.valueOf(year_integer);
		return expect_year;

	}
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter the date plz");
		desired_date=scanner.nextLine();
		desired_day=expected_day(desired_date);
		desired_month=expected_month(desired_date);
		desired_year=expected_year(desired_date);		
		scanner.close();
		driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().setSize(new Dimension(400,400));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(enabled = false)
	public void test_01() throws InterruptedException
	{
		scroll_into_view();
		List<WebElement> page_list = driver.findElements(By.xpath("//ul[@class='pagination']//li"));

		for(int i=1;i<=page_list.size();i++)
		{
			WebElement pages=driver.findElement(By.xpath("//a[normalize-space()='"+i+"']"));
			pages.click();
			Thread.sleep(1000);

			List<WebElement> total_rows= driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr"));
			for(int j=1;j<=total_rows.size();j++)
			{
				String idString=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+j+"]//td[1]")).getText();
				String product_name=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+j+"]//td[2]")).getText();
				String price=driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+j+"]//td[3]")).getText();
				driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+j+"]//td[4]//input")).click();

				System.out.println(idString +"  "+product_name+"  "+price);

			}
		}
	}
	@Test
	public void handling_calenders() throws InterruptedException
	{
		scroll_into_view();
		driver.switchTo().frame("frame-one796456169");		
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		WebElement dropdown= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select select = new Select(dropdown);
		select.selectByVisibleText(desired_year);
//		List<WebElement> options = select.getOptions();
//		for(WebElement option : options)
//		{
//			select = new Select(dropdown);
//			String optionsString= option.getText(); 
//			if(desired_year.equals(optionsString))
//			{
//				select.selectByValue(optionsString);
//			}
//		}
		while(true)
		{
			String actual_month_text=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			Month actual_month= Month.valueOf(actual_month_text.toUpperCase());
			Month desired_monthh= Month.valueOf(desired_month.toUpperCase());
			int comparsion= actual_month.compareTo(desired_monthh);
			if(comparsion==0)
			{
				break;
			}
			else if (comparsion<0)
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
			else
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//previous
			}
			Thread.sleep(1000);
		}
		while(true)
		{
			List<WebElement> day_list= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
			for(WebElement day: day_list)
			{
				if(day.getText().equals(desired_day))
				{
					day.click();
					return;
				}
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
