package Tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Handling_dyanamic_Tables 
{

	static WebDriver driver;
	public static String total_pages;
	public static void login() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(15000);
	}
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		driver= new ChromeDriver();
		driver.get("https://demo.opencart.com/admin/");
		driver.manage().window().maximize();
		

	}
	@Test(invocationCount = 1)
	public void test_01() throws InterruptedException
	{
		login();		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		WebElement dialogue_box= driver.findElement(By.xpath("//button[@class='btn-close']"));
		//wait.until(ExpectedConditions.visibilityOf(dialogue_box));
		//	WebElement dialogue_window= driver.findElement(By.xpath("//div[@class='modal-content']"));
		if(dialogue_box.isDisplayed())
		{
			dialogue_box.click();
		}

		
		driver.findElement(By.xpath("//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-customer']/a[1]")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();	
		Thread.sleep(1000);
		JavascriptExecutor jsExecutor= (JavascriptExecutor) driver;		
		WebElement get_total_pages=driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']"));
		jsExecutor.executeScript("arguments[0].scrollIntoView", get_total_pages);
		Thread.sleep(2500);
		String total_string= get_total_pages.getText();
		String[] partStrings = total_string.split("\\(");
		if(partStrings.length>=2)
		{
			total_pages= partStrings[1].split(" ")[0].trim();
			//System.out.println(total_pages);
		}
		int total_number_pages= Integer.parseInt(total_pages);
		for (int i = 2; i <= 6; i++) 
		{
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement activePage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='pagination']//*[text()='" + i + "']")));
		    activePage.click();
		    Thread.sleep(1500);

		    // Data extraction from table
		    List<WebElement> total_rowsList = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr"));
		    int number_of_rows = total_rowsList.size();
		    for (int j = 0; j < number_of_rows; j++) 
		    {
		        //String name = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + (j + 1) + "]//td[2]")).getText();
		        String email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + (j + 1) + "]//td[3]")).getText();
		        System.out.println( email);
		    }
			
		}
		
		
		
	}

	@AfterMethod
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.close();
	}
}
