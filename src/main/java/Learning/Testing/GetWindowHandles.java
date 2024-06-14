package Learning.Testing;

import org.openqa.selenium.By;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;

public class GetWindowHandles {

	public static void main(String[] args) throws InterruptedException 
	
	{
		
		WebDriver driver = new ChromeDriver();		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String main_window= driver.getWindowHandle();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='OrangeHRM, Inc']")).click();	
		
		Set <String> handles=driver.getWindowHandles();
	
//		Iterator<String> it=handles.iterator();
//		while(it.hasNext())
//		{
//			System.out.println(it.next());
//		}		
		List<String> windowid = new ArrayList<String>(handles);//convert set to list
		System.out.println(windowid.get(0));
		System.out.println(windowid.get(1));
		
		driver.switchTo().window(windowid.get(1));
		System.out.println("Title is=" + driver.getTitle());
		
		//driver.findElement(By.xpath("//a[@href='/en/contact-sales/']//button[contains(text(),'Contact Sales')]")).click();
		
		driver.close();
		
		//driver.switchTo().window(windowid.get(0));
		driver.switchTo().window(main_window);
		Dimension d = new Dimension(480,62);
		driver.manage().window().setSize(d);
		System.out.println("Title is=" + driver.getTitle());
		System.out.println("size is = " + driver.manage().window().getSize());
		//Thread.sleep(2000);
		
		driver.quit();

	}

}
