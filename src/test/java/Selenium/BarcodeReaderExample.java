package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BarcodeReaderExample {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();

		try {
			// Open the webpage
			driver.get("https://barcode.tec-it.com/en/Code11?data=0123-4567");
			driver.manage().window().maximize();
			Thread.sleep(2500);
			driver.findElement(By.xpath("((//ul[@class='styled-list'])[1]//li)[1]")).click();
			Thread.sleep(2500);

			// Locate the barcode element
			WebElement barcodeElement = driver.findElement(By.xpath("//img[@alt='Barcode']"));

			 File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	            // Load the screenshot
	            BufferedImage fullImg = ImageIO.read(screenshot);

	            // Get the location and size of the barcode element
	            org.openqa.selenium.Point point = barcodeElement.getLocation();
	            int elementWidth = barcodeElement.getSize().getWidth();
	            int elementHeight = barcodeElement.getSize().getHeight();

	            // Debug: Print the location and size of the barcode element
	            System.out.println("Barcode location: " + point);
	            System.out.println("Barcode size: Width = " + elementWidth + ", Height = " + elementHeight);

	            // Crop the barcode from the screenshot
	            BufferedImage barcodeImg = fullImg.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight);

	            // Save the cropped barcode image (optional)
	            ImageIO.write(barcodeImg, "png", new File("cropped-barcode.png"));

	            // Decode the barcode
	            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(barcodeImg)));

	            try {
	                Result result = new MultiFormatReader().decode(binaryBitmap);
	                // Print the barcode data
	                System.out.println("Barcode Type: " + result.getBarcodeFormat());
	                System.out.println("Barcode Data: " + result.getText());
	            } catch (NotFoundException e) {
	                System.out.println("Barcode not found in the provided image.");
	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            // Clean up
	            driver.quit();
	        }
	    }
}
