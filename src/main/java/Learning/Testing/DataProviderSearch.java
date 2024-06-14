package Learning.Testing;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataProviderSearch 

{	

	@DataProvider(name="SearchKey")
	public Object[][] searchdata()
	{
		Object[][] search= new Object[3][2];

		search[0][0]= "india"; 
		search[0][1]= "Qutub minar"; 	
		search[1][0]= "Agra";
		search[1][1]= "Taj Mahal"; 
		search[2][0]= "Hyderabad"; 
		search[2][1]="CharMinar";

		return search;

	}
		@Test(dataProvider="SearchKey")
		public void TestCaseGgle(String country,String monument)
		{
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.google.com/");
			WebElement search = driver.findElement(By.name("q"));
			search.sendKeys(country + " " + monument);
			driver.findElement(By.name("btnK")).submit();
			driver.close();
		}
		

		@Test(dataProvider="SearchKey" ,dataProviderClass=DataProviderSeprate.class)
		public void TestCaseGgle2(String country,String monument)
		{
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.google.com/");
			WebElement search = driver.findElement(By.name("q"));
			search.sendKeys(country + " " + monument);
			driver.findElement(By.name("btnK")).submit();
			driver.close();
		}
}
