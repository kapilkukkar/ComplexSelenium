package Learning.Testing;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestNgExcel 

{	
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}
	@Test(dataProvider ="searchDataProvider")
	public void search(String keyword)
	{
		WebElement searchbox=driver.findElement(By.name("q"));
		searchbox.sendKeys(keyword);
		searchbox.sendKeys(Keys.ENTER);
	}
	@DataProvider(name="searchDataProvider")
	public Object[][] dataprovidermethod() throws IOException
	{
		String filename="C:\\Users\\kumar\\Downloads\\testfile.xlsx";
		Object[][] searchData=getExcelData(filename,"Sheet1");
		return searchData;
	}
	
	
	
	public String[][] getExcelData(String fileName, String Sheet) throws IOException
	{
		String[][] data =null;
		
		FileInputStream inputStream = new FileInputStream(fileName);
		XSSFWorkbook ExcelWBook = new XSSFWorkbook(inputStream);
		XSSFSheet excelsheet= ExcelWBook.getSheet(Sheet);
		int row= excelsheet.getLastRowNum()+1;
		int cell=excelsheet.getRow(0).getLastCellNum();
		data=new String[row-1][cell];
		for(int i=1;i<row;i++)
		{
			for(int j=0;j<cell;j++)
			{
				data[i-1][j]=excelsheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		ExcelWBook.close();
		return data;
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

	
}
