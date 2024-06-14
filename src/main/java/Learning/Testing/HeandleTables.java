package Learning.Testing;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeandleTables 
{
	public static void main(String[] args) throws IOException, InterruptedException  
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(4000);
		List <WebElement > table = driver.findElements(By.xpath("//table[@name='BookTable']"));
		
		List <WebElement> rowcount = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));
		List <WebElement> coloumncount = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th"));
		
		for(int i=2;i<=rowcount.size();i++)
		{
			for(int j=1;j<=coloumncount.size();j++)
			{
				String data=driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr["+ i +"]/td["+  j  +"]")).getText();
				System.out.println(data);
			}
		}
				
		Thread.sleep(4000);
		driver.close();
	}
	
}
