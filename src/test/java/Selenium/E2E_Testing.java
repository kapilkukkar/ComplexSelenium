package Selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class E2E_Testing 
{
	static WebDriver driver;
	Faker faker;
	public static void date_pick(String date,String month,String year)
	{
		WebElement monthElement= driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select dateSelect= new Select(monthElement);
		dateSelect.selectByVisibleText(month);
		WebElement yearElement= driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select yearSelect= new Select(yearElement);
		yearSelect.selectByVisibleText(year);
		List<WebElement> list= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td"));
		for(WebElement element:list)
		{
			if(element.getText().equals(date))
			{
				element.click();
				break;
			}
		}


	}
	@BeforeMethod
	public void set_up()
	{
		driver= new ChromeDriver();		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void test_01() throws InterruptedException
	{
		faker= new Faker();
		
		List<WebElement> list= driver.findElements(By.xpath("//ul[@id='checkout-products']//li"));
		Thread.sleep(2000);
		for(WebElement element:list)
		{
			if(element.getText().contains("Past dated ticket"))
			{
				WebElement radioButton = element.findElement(By.tagName("input"));
                radioButton.click();
                break;
			}
		}

		driver.findElement(By.xpath("//input[@id='travname']")).sendKeys(faker.name().firstName());
		driver.findElement(By.xpath("//input[@id='travlastname']")).sendKeys(faker.name().lastName());
		driver.findElement(By.xpath("//textarea[@id='order_comments']")).sendKeys(faker.lorem().paragraph(2));
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		date_pick("20", "Jun", "1991");
		driver.findElement(By.xpath("//input[@id='sex_1']")).click();
		driver.findElement(By.xpath("//input[@id='traveltype_2']")).click();
		driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys(faker.address().city());
		driver.findElement(By.xpath("//input[@id='tocity']")).sendKeys(faker.address().city());
		driver.findElement(By.xpath("//input[@id='departon']")).click();
		date_pick("20", "Jul", "2024");
		driver.findElement(By.xpath("(//input[@class='thwcfe-checkout-date-picker input-text thwcfe-input-field hasDatepicker'])[3]")).click();
		date_pick("18", "Nov", "2024");
		driver.findElement(By.xpath("//textarea[@id='notes']")).sendKeys(faker.lorem().paragraph(2));
		driver.findElement(By.xpath("//span[@id='select2-reasondummy-container']")).click();		
		List<WebElement> optionsElements= driver.findElements(By.xpath("//ul[@class='select2-results__options']//li"));
		for(WebElement element:optionsElements)
		{
			if(element.getText().contains("Visa extension"))
			{
				element.click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='deliverymethod_3']")).click();
		driver.findElement(By.xpath("//input[@id='billname']")).sendKeys(faker.company().name());
		driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys(faker.phoneNumber().cellPhone());
		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys(faker.internet().emailAddress());
		driver.findElement(By.xpath("//span[@id='select2-billing_country-container']")).click();
		WebElement billing_country= driver.findElement(By.xpath("//select[@id='billing_country']"));
		Select billing_dropdown= new Select(billing_country);
		billing_dropdown.selectByVisibleText("United States (US)");
		driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys(faker.address().buildingNumber());
		driver.findElement(By.xpath("//input[@id='billing_address_2']")).sendKeys(faker.address().fullAddress());
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys(faker.address().cityName());		
		WebElement statElement= driver.findElement(By.xpath("//select[@id='billing_state']"));
		Select state_dropdown= new Select(statElement);
		state_dropdown.selectByVisibleText("Hawaii");
		driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys(faker.address().zipCode());
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@id='payment_method_yith-stripe']")).click();		
		WebElement frame1= driver.findElement(By.xpath("(//iframe[contains(@name, '__privateStripeFrame')])[1]"));
		driver.switchTo().frame(frame1);		
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//input[@class='InputElement is-empty Input Input--empty' and @name='cardnumber']")).sendKeys(faker.finance().creditCard());
		Thread.sleep(2000);	
		WebElement frame2= driver.findElement(By.xpath("(//iframe[contains(@name, '__privateStripeFrame')])[2]"));
		Thread.sleep(2000);	
		driver.switchTo().frame(frame2);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@class='InputElement is-empty Input Input--empty' and @name='exp-date']")).sendKeys(faker.number().digits(4));
//		Thread.sleep(2500);
		WebElement frame3= driver.findElement(By.xpath("(//iframe[contains(@name, '__privateStripeFrame')])[3]"));
		driver.switchTo().frame(frame3);
		Thread.sleep(2500);
		driver.findElement(By.xpath("//input[@class='InputElement is-empty Input Input--empty' and @name='cvc']")).sendKeys(faker.number().digits(3));
		Thread.sleep(3500);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[@id='place_order']")).click();

	}
	@AfterMethod
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(5500);
		driver.close();
	}

}
