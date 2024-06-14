package Selenium;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class ScreenShots
{

	static WebDriver driver;
	public static void scroll_into_view()
	{
		WebElement element= driver.findElement(By.xpath("//div[@id='resizable']"));
		JavascriptExecutor js= (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(5500);
		
	}
	@Test
	public void test_01() throws IOException
	{
		File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("screenshots\\title.png"));
		
	}
	@Test
	public void another_way_take_screenshot()
	{
		scroll_into_view();
		File sourceFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
		sourceFile.renameTo(new File("screenshots\\title.png"));
	}
	@Test
	public void take_screenshot_fileHandler() throws IOException
	{
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File("screenshots\\title1.png"));
	}
	@Test
	public void take_webelement_Screenshot() throws IOException
	{
		WebElement buttonElement= driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
		File screenshotFile=buttonElement.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshotFile, new File("screenshots\\button.png"));
	}
	@Test
	public void screenshot_with_robot_class() throws AWTException, IOException, InterruptedException
	{
		scroll_into_view();
		Robot robot = new Robot();
		Dimension dimension= Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle = new Rectangle(dimension);
		//WebElement alertElement=driver.findElement(By.xpath("//button[@onclick='myFunctionAlert()']"));
		//alertElement.click();		
		BufferedImage bufferedImage= robot.createScreenCapture(rectangle);
		ImageIO.write(bufferedImage, "png", new File("screenshots\\robot.png"));
	}
	@Test
	public void full_screenshot_with_Url_Robot() throws AWTException, IOException, InterruptedException
	{
		scroll_into_view();
		Thread.sleep(2500);
		Robot robot = new Robot();
		Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle= new Rectangle(dimension);
		BufferedImage bufferedImage=robot.createScreenCapture(rectangle);
		ImageIO.write(bufferedImage, "png", new File("screenshots\\url.png"));
		
	}
	@Test
	public void screenshot_fullpage_with_ashotAPI() throws IOException
	{
		Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(),"png", new File("screenshots\\fullpage/png"));
		
	}
	@Test
	public void scroll_up_down() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(1500);
		jse.executeScript("window.scrollTo(0,0);");
	}
	@Test
	public void move_to_element() throws InterruptedException
	{
		WebElement element= driver.findElement(By.xpath("//button[@onclick='myFunctionAlert()']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	@AfterMethod
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(3500);
		driver.close();
	}
}

