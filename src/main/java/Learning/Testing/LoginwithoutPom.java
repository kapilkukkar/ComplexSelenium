package Learning.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.*;



public class LoginwithoutPom {

	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriver driver= new EdgeDriver();
		
		/*
		 * driver.get("https://www.saucedemo.com/");
		 * driver.findElement(By.id("user-name")).sendKeys("standard_user");
		 * driver.findElement(By.id("password")).sendKeys("secret_sauce");
		 * driver.findElement(By.id("login-button")).click();
		 */
		driver.get("https://www.amazon.ca/a/addresses/add?ref=ya_address_book_add_button");
		driver.manage().window().maximize();
		/*
		 * WebElement element=
		 * driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
		 * 
		 * Actions action= new Actions(driver); action.moveToElement(element).perform();
		 * driver.findElement(By.className("nav-action-inner")).click();
		 * //driver.findElement(By.id("password")).sendKeys("secret_sauce");
		 * //driver.findElement(By.id("login-button")).click(); Thread.sleep(1500);
		 * driver.close();
		 */
		
		

	}

}
