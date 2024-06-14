package Learning.Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SingleStament {

	public static void main(String[] args) throws InterruptedException 
	
	{		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		Actions actions= new Actions(driver);
		Action actns= actions
				.moveToElement(driver.findElement(By.name("user-name")))
				.click()
				.sendKeys("standard_user",Keys.TAB)
				.sendKeys("secret_sauce",Keys.ENTER).build();
		
		actns.perform();
		Thread.sleep(1500);
		driver.close();
	}						

}
