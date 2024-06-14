package Take_Data_from_Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_excel_file
{
	public static FileInputStream file;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static void read_file(String filename, String sheetname) throws IOException
	{
		file= new FileInputStream(filename);
		workbook = new XSSFWorkbook(file);
		sheet= workbook.getSheet(sheetname);
	}
	public static int row_count(String filename, String sheetname) throws IOException
	{
		read_file(filename, sheetname);
		int total_rows = sheet.getLastRowNum()+1;
		workbook.close();
		return total_rows;
		
	}
	public static int column_count(String filename, String sheetname) throws IOException
	{
		read_file(filename, sheetname);
		int total_column= sheet.getRow(0).getLastCellNum();
		workbook.close();
		return total_column;
		
		
	}
	public static String cell_value(String filename, String sheetname,int row_no,int cell_no) throws IOException
	{
		read_file(filename, sheetname);
		cell= workbook.getSheet(sheetname).getRow(row_no).getCell(cell_no);
		workbook.close();
		return cell.getStringCellValue();
		
		
	}

}
