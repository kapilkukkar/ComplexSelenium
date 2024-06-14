package Learning.Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.*;

public class LoginPageFactory 

{
	WebDriver driver;

	LoginPageFactory(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="user-name")WebElement username;
	@FindBy(id="password")WebElement password;
	@FindBy(id="login-button") WebElement loginbutton;

	public void enterusername(String uname)
	{
		username.sendKeys(uname);

	}
	public void enterpasswrd(String psd)
	{
		password.sendKeys(psd);

	}
	public void lgnbtn()
	{
		loginbutton.click();

	}
}
