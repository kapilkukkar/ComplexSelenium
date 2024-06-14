package Learning.Testing;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;


public class DataDrivenTesting {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		XSSFWorkbook ExcelWBook =null;
		XSSFSheet ExcelWSheet;
		//XSSFRow row;
		//XSSFCell cell;		
		//open Excel->workbook->Sheet->Rows->cell
		
		// create an object of file open
		
		File excelFile = new File("C:\\Users\\kumar\\OneDrive\\Desktop\\TestDataFile.xlsx");		
	// create an object for reading data from file
		
		FileInputStream inputStream = new FileInputStream(excelFile);		
		ExcelWBook = new XSSFWorkbook(inputStream);//Access of workbook		
		ExcelWSheet = ExcelWBook.getSheetAt(0);//Access of sheet		
		int rows= ExcelWSheet.getLastRowNum()+1;
		int cells = ExcelWSheet.getRow(0).getLastCellNum();
		for(int i=1;i<rows;i++)
		{
			WebDriver driver = new ChromeDriver();
			LoginPage page = new LoginPage(driver);
			driver.get("https://www.saucedemo.com/");
			driver.findElement(By.id("user-name")).sendKeys(ExcelWSheet.getRow(i).getCell(0).toString());
			driver.findElement(By.id("password")).sendKeys(ExcelWSheet.getRow(i).getCell(1).toString());
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(3000);
			driver.close();
			
			/*
			 * for (int j=0;j<cells;j++) {
			 * 
			 * System.out.print(ExcelWSheet.getRow(i).getCell(j).toString());
			 * System.out.print("\t \t"); } System.out.println();
			 */	
			
	}
		ExcelWBook.close();
}}
