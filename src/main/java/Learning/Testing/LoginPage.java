package Learning.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	WebDriver driver;

	LoginPage(WebDriver d)
	{
		driver = d;
	}

	By username= By.id("user-name");
	By password = By.id("password");
	By loginbtn = By.id("login-button");

	public void enterusername(String uname)
	{
		driver.findElement(username).sendKeys(uname);

	}
	public void enterpasswrd(String psd)
	{
		driver.findElement(password).sendKeys(psd);

	}
	public void lgnbtn()
	{
		driver.findElement(loginbtn).click();

	}
}
