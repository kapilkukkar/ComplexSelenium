package Take_Data_from_Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.javafaker.Faker;

public class Write_data_into_excel {

	public static void main(String[] args) throws IOException 
	{
		Workbook workbook = new XSSFWorkbook();
		Sheet Sheet = workbook.createSheet("FakeData");
		Row head_row= Sheet.createRow(0);
		head_row.createCell(0).setCellValue("ID");
		head_row.createCell(1).setCellValue("Name");
		head_row.createCell(2).setCellValue("Email");
		head_row.createCell(3).setCellValue("Username");
		head_row.createCell(4).setCellValue("Phone_Number");
		head_row.createCell(5).setCellValue("Last_name");
		Faker faker= new Faker();
		for(int i=1;i<=50;i++)
		{
			Row row= Sheet.createRow(i);
			row.createCell(0).setCellValue(i);
			row.createCell(1).setCellValue(faker.name().firstName());
			row.createCell(2).setCellValue(faker.internet().emailAddress());
			row.createCell(3).setCellValue(faker.name().username());
			row.createCell(4).setCellValue(faker.phoneNumber().phoneNumber());		
			row.createCell(5).setCellValue(faker.name().lastName());	
			
		}
		String path=System.getProperty("user.dir")+"//TestData//new_file.xlsx";
		FileOutputStream file= new FileOutputStream(path);
		workbook.write(file);
		workbook.close();

	}

}
