package Learning.Testing;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebElement;

public class DatePicker 
{

	public static void main(String[] args) throws IOException, InterruptedException  
	{
		String expected_day="29";
		String expected_mnth="February";
		String expected_year="2025";
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		while(true)
		{

			String calenderMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String calenderYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		
			if(calenderMonth.equals(expected_mnth) && calenderYear.equals(expected_year))
			{
				List <WebElement> daysList = driver.findElements(By.xpath("//table/tbody/tr/td"));
				
				for(WebElement e:daysList)
				{
					String calenderDay = e.getText();
					if(calenderDay.equals(expected_day))
					{
						e.click();
						break;
						
					}
				}
					
				break;
			}
			else
			{
				
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
			
		}
		Thread.sleep(4000);
		driver.close();

	}

}