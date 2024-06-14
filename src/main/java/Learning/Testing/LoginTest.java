package Learning.Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
//		LoginPage page = new LoginPage(driver);
//		WebDriver driver;
		
		driver.get("https://www.saucedemo.com/");
//		page.enterusername("standard_user");
//		page.enterpasswrd("secret_sauce");
//		page.lgnbtn();
//		Thread.sleep(3500);
//		driver.close();

	}

}
