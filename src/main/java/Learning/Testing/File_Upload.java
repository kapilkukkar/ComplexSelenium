package Learning.Testing;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.interactions.Actions;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;



public class File_Upload 
{

	WebDriver driver;
	@Test(enabled=false)
	public void test2() throws AWTException
	{
		
		
		driver= new FirefoxDriver();
		driver.get("https://demoqa.com/upload-download");
		driver.manage().window().maximize();
		WebElement button = driver.findElement(By.xpath("//input[@id='uploadFile']"));
		Actions action = new Actions(driver);
		action.click(button).perform();
		
		Robot rb = new Robot();
		rb.delay(2000);
		String path ="C:\\Users\\kumar\\Downloads\\Resume Infosys\\Kapil Kukkar.pdf";
		
		//copy address to clipboard
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		
		//now paste the address
		
		rb.keyPress(KeyEvent.VK_CONTROL);		
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(2000);
		
		driver.close();
		
	}
	@Test(enabled = false)
	public void test()
	{
		driver = new FirefoxDriver();
		driver.get("https://demoqa.com/upload-download");
		driver.findElement(By.xpath("//input[@id='uploadFile']"))
		.sendKeys("C:\\Users\\kumar\\Downloads\\Resume Infosys\\Kapil Kukkar.pdf");
		driver.close();
		
	}
	//if file type is not avaialble in DOM
	@Test
	public void test1() throws InterruptedException, AWTException
	{
		
		driver = new FirefoxDriver();
		driver.get("https://demoqa.com/upload-download");
		Thread.sleep(2000);
		WebElement button=driver.findElement(By.xpath("//input[@id='uploadFile']"));
		driver.manage().window().maximize();
		//Actions action = new Actions(driver);
		//action.click(button).perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button);
		
		Robot rb = new Robot();	
		rb.delay(2000);
		
		//Copy the file Address in window
		StringSelection ss = new StringSelection("C:\\Users\\kumar\\Downloads\\Resume Infosys\\Kapil Kukkar.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//Pasting the Address now
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		
		//Pressing Enter to Open the File
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(2000);
		
		
		
		driver.close();
		
	}
}
