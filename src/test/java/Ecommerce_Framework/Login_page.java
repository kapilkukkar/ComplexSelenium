package Ecommerce_Framework;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions ;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Login_page
{
	public WebDriver driver;
	WebDriverWait wait;
	Faker faker=new Faker();
	public String url= "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	public String name= faker.name().firstName();
	public void login()
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	public void logout()
	{
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
	}
	public void leave_page_calender(String month,String year,String day)
	{
		wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='oxd-calendar-selector-month']"))).click();
		String monthdropdown_xpath = "//ul[@class='oxd-calendar-dropdown']//li";
		List<WebElement> monthList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(monthdropdown_xpath)));
		for (WebElement element : monthList) 
		{
			if (element.getText().equals(month)) 
			{
				element.click();
				break;
			}
		}		
		String year_dropdown_xpath = "//ul[@class='oxd-calendar-dropdown']//li";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='oxd-calendar-selector-year']//p[1]"))).click();
		List<WebElement> yearList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(year_dropdown_xpath)));
		for (WebElement element : yearList) 
		{
			if (element.getText().equals(year)) 
			{
				element.click();
				break;
			}
		}		
		String day_xpath = "//div[@class='oxd-calendar-dates-grid']/div[position() <= 31]";
		List<WebElement> dayList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(day_xpath)));
		for (WebElement element : dayList)
		{
			if (element.getText().equals(day)) 
			{
				element.click();
				break;
			}
		}
	}

	@BeforeMethod
	public void set_up() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		//driver= new ChromeDriver(options);
		driver= new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@Test(priority = 1,enabled = false)	
	public void login_valid_credentials() throws InterruptedException
	{
		login();
		String page_title = driver.getTitle();		
		if(page_title.equals("OrangeHRM"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}

	}
	@Test(priority = 2,enabled = false)
	public void test_logout() throws InterruptedException
	{
		login();
		Thread.sleep(3500);

		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		WebElement logo= driver.findElement(By.xpath("//img[@alt='company-branding']"));	
		if(logo.isDisplayed())
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}

	}
	@Test(priority = 3,enabled = false)
	public void login_invalid_credentials()
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admi55/6");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement textElement= driver.findElement(By.xpath("//p[normalize-space()='Invalid credentials']"));
		String text= textElement.getText();
		Assert.assertEquals(text, "Invalid credentials");


	}
	@Test(priority = 1)
	public void add_employee() throws InterruptedException, AWTException
	{
		faker= new Faker();
		login();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Add Employee']")).click();
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-plus']")).click();
		Robot robot= new Robot();
		robot.delay(2000);
		String filepath="C:\\Users\\kumar\\AppiumLearning\\SeleniumPractice\\image.jpg";
		StringSelection ss= new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);		
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder='Middle Name']")).sendKeys(faker.name().name());
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(faker.name().lastName());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement details= driver.findElement(By.xpath("//h6[normalize-space()='Personal Details']"));
		if(details.isDisplayed())
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}

	}
	@Test(priority = 2)
	public void search_employee() throws InterruptedException
	{
		login();		
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElements(By.tagName("input")).get(1).sendKeys(name);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2500);
		WebElement confirmation= driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span']"));
		String text= confirmation.getText();
		Assert.assertEquals(text, "(1) Record Found");
		logout();

	}
	@Test
	public void find_employee()
	{
		login();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElements(By.tagName("input")).get(1).sendKeys(name);
		List<WebElement> list= driver.findElements(By.xpath("driver.findElements(By.tagName(\"input\")).get(1).sendKeys(name);"));

	}
	@Test
	public void handle_table() throws InterruptedException
	{
		login();
		driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();
		WebElement element= driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
		Thread.sleep(2500);
		List<WebElement> row_list = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']"));

		for(int i=3;i<=row_list.size()+1;i++)
		{
			String nameString=driver.findElement(By.xpath("((//div[@role='row'])["+i+"]//div[@role='cell'])[2]")).getText();
			String employee_nameString= driver.findElement(By.xpath("((//div[@role='row'])["+i+"]//div[@role='cell'])[4]")).getText();
			System.out.println(nameString+ "  " + employee_nameString);
		}

	}
	@Test
	public void File_upload() throws AWTException, InterruptedException
	{
		login();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']")).click();
		driver.findElement(By.xpath("(//ul[@class=\"oxd-dropdown-menu\"]//li)[3]")).click();
		driver.findElement(By.xpath("//div[@class='oxd-file-button']")).click();
		Robot robot = new Robot();
		robot.delay(1500);
		String filepath="C:\\Users\\kumar\\AppiumLearning\\SeleniumPractice\\file.csv";		
		StringSelection ss= new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();


	}
	@Test()
	public void delete_record() throws InterruptedException
	{
		login();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(2500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		WebElement first_name=driver.findElement(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[3]"));
		String text= first_name.getText();
		System.out.println(first_name.getText());		
		driver.findElements(By.tagName("input")).get(1).sendKeys(text);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement resultElement=driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]"));
		if(!resultElement.getText().equals("No Records Found"))
		{
			driver.findElement(By.xpath("(//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th'])[1]")).click();
			Thread.sleep(2500);
			driver.findElement(By.xpath("//button[normalize-space()='Delete Selected']")).click();
			driver.findElement(By.xpath("//button[normalize-space()='Yes, Delete']")).click();	
			Thread.sleep(2500);
			assertEquals(resultElement.getText(), "No Records Found", "Test Passed");			

		}


	}
	@Test
	public void ttetedg()
	{
		login();

		// Navigate to PIM section
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pimElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']")));
		pimElement.click();

		// Scroll down the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		// Find and print the first name of the first record
		WebElement firstNameElement = driver.findElement(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell'])[3]"));
		String text = firstNameElement.getText();
		System.out.println(text);

		// Enter the first name in the search input field and submit the search
		driver.findElements(By.tagName("input")).get(1).sendKeys(text);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Wait for the result element to be present
		WebElement resultElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]")));
		if (!resultElement.getText().equals("No Records Found")) 
		{
			WebElement headerCheckbox = driver.findElement(By.xpath("(//div[@class='oxd-table-header-cell oxd-padding-cell oxd-table-th'])[1]"));
			headerCheckbox.click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Delete Selected']"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes, Delete']"))).click();
			wait.until(ExpectedConditions.textToBe(By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]"), "No Records Found"));
			resultElement = driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]"));
			assertEquals(resultElement.getText(), "No Records Found", "Test Passed");
		}
	}
	@Test
	public void print_employee_list() throws InterruptedException
	{
		login();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 3000)");
		Thread.sleep(2500);
		List<WebElement> paginationList = driver.findElements(By.xpath("//ul[@class='oxd-pagination__ul']//li"));
		System.out.println(paginationList.size());
		for (int pageIndex = 1; pageIndex <= paginationList.size(); pageIndex++) 
		{
			List<WebElement> rowList = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']"));
			System.out.println("Page " + pageIndex + " has " + rowList.size() + " rows.");		
			for (int rowIndex = 1; rowIndex <= rowList.size(); rowIndex++) 
			{				
				WebElement chkbox = driver.findElement(By.xpath("(//div[@class='oxd-table-body']//div[@class='oxd-table-card'])[" + (rowIndex+1) + "]//div[@class='oxd-checkbox-wrapper']"));
				chkbox.click();
				Thread.sleep(200);				
				String name = driver.findElement(By.xpath("(//div[@class='oxd-table-body']//div[@class='oxd-table-card'])[" + rowIndex + "]//div[@role='cell'][3]")).getText();
				String employeeName = driver.findElement(By.xpath("(//div[@class='oxd-table-body']//div[@class='oxd-table-card'])[" + rowIndex + "]//div[@role='cell'][4]")).getText();
				System.out.println(name + "   " + employeeName);
			}			
			if (pageIndex < paginationList.size()) 
			{
				paginationList = driver.findElements(By.xpath("//ul[@class='oxd-pagination__ul']//li"));
				paginationList.get(pageIndex).click();
				Thread.sleep(2500);
			}
		}
	}
	@Test
	public void apply_for_leave() throws InterruptedException
	{
		login();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='oxd-main-menu']//li)[3]//span"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='oxd-topbar-body-nav-tab'])[1]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-select-text-input']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'CAN')]"))).click();		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]"))).click();
		leave_page_calender("July", "2024","25");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"))).click();
		leave_page_calender("July", "2024","25");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Specify Time')]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='oxd-icon bi-clock oxd-time-input--clock'])[1]"))).click();
		for(int i=0;i<=3;i++)
		{
			WebElement hour_up_button= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='oxd-icon bi-chevron-up oxd-icon-button__icon oxd-time-hour-input-up']")));
			hour_up_button.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='oxd-time-period-label'])[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='oxd-icon bi-clock oxd-time-input--clock'])[2]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='oxd-icon bi-chevron-down oxd-icon-button__icon oxd-time-hour-input-down']"))).click();
		for(int i=0;i<=3;i++)
		{
			WebElement minute_up_button= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='oxd-icon bi-chevron-up oxd-icon-button__icon oxd-time-minute-input-up']")));
			minute_up_button.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//textarea"))).sendKeys(faker.lorem().paragraph(2));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();

	}


	@AfterMethod	
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(6500);
		driver.close();
	}

}
