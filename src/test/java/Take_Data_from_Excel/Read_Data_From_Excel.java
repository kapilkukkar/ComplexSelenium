package Take_Data_from_Excel;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Read_Data_From_Excel 
{
	WebDriver driver;
	@DataProvider(name = "Login Credentials")
	public String [][] getdata() throws IOException
	{
		String file= System.getProperty("user.dir")+"//TestData//data.xlsx";
		int total_rows= Read_excel_file.row_count(file, "Sheet1");
		int total_column= Read_excel_file.column_count(file, "Sheet1");
		String user_data[][]= new String[total_rows-1][total_column];
		for(int row=1;row<total_rows;row++)
		{
			for(int column = 0; column<total_column;column++)
			{
				user_data[row-1][column]=Read_excel_file.cell_value(file, "Sheet1", row, column);
			}
		}
		return user_data;
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		
		driver= new ChromeDriver();	
		String url= "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(2500);
		
	}
	@Test(dataProvider = "Login Credentials")
	public void test_01(String Username, String Password) throws IOException
	{		
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@AfterMethod
	public void tear_down() throws InterruptedException
	{
		Thread.sleep(2500);
		driver.close();
	}
}
