package Learning.Testing;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DatePickerDemo 
{
	public static void main(String[] args) throws IOException, InterruptedException  
	{
		String expected_mnth_year="May 2025";		
		String expected_day="25";
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		Thread.sleep(4500);
		driver.findElement(By.xpath("//text[@Class='dateText']")).click();
		while(true)
		{

			String calenderMonth_year = driver.findElement(By.xpath(" //*[@id=\"homeV2-root\"]/div[1]/div[1]/div/div[4]/div/div[2]/div/div/div[1]/div[2]")).getText();
			
		
			if(calenderMonth_year.equals(expected_mnth_year) )
			{
				List <WebElement> daysList = driver.findElements(By.xpath("//span[@class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 bwoYtA' or @class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 dkWAbH' or @class='DayTiles__CalendarDaysSpan-sc-1xum02u-1 gjcAAZ']"));
				
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
				
				driver.findElement(By.xpath("//*[@id=\"Layer_1\"]")).click();
			}
			
		}
		Thread.sleep(4000);
		driver.close();

	}
}
