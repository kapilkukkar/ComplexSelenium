package Learning.Testing;

import java.util.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EncryptedPass {

	public static void main(String[] args) throws InterruptedException 
	
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(1500);
		driver.findElement(By.name("username")).sendKeys("Admin");
		byte[] decrypted = Base64.getDecoder().decode("YWRtaW4xMjM=");
		String password = new String(decrypted);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[.=' Login ']")).submit();
		Thread.sleep(3000);
		driver.close();
		
		
		

	}

}
