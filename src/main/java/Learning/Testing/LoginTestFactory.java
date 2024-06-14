package Learning.Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTestFactory {

	public static void main(String[] args) throws InterruptedException 
	
	{
		WebDriver driver = new ChromeDriver();
		LoginPageFactory pages = new LoginPageFactory(driver);
		driver.get("https://www.saucedemo.com/");
		pages.enterusername("standard_user");
		pages.enterpasswrd("secret_sauce");
		pages.lgnbtn();
		Thread.sleep(2000);
		driver.close();

	}

}
