package Take_Data_from_Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.javafaker.Faker;

public class WriteDataInSpecificFile {

    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\kumar\\AppiumLearning\\SeleniumPractice\\file.xlsx"; // Replace with your Excel file path
        try 
        {
            updateExcelFile(excelFilePath);
            System.out.println("Excel file updated successfully.");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateExcelFile(String excelFilePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

        // Get the last row number (0-based index)
        int lastRowNum = sheet.getLastRowNum();

        // Create Faker instance for generating fake data
        Faker faker = new Faker();

        try {
            // Generate 50 rows of fake data starting from the next available row
            for (int i = lastRowNum + 1; i <= lastRowNum + 50; i++) 
            {
                Row row = sheet.createRow(i);

                // Populate cells with fake data
                row.createCell(0).setCellValue(faker.name().firstName());
                row.createCell(1).setCellValue(faker.name().firstName());
                row.createCell(2).setCellValue(faker.name().lastName());
                row.createCell(3).setCellValue(i); // Assuming this is an ID or index
                row.createCell(4).setCellValue(faker.number().digits(2));
                row.createCell(5).setCellValue(faker.number().digits(10));
                row.createCell(6).setCellValue("08/27"); // Example date
                row.createCell(7).setCellValue("Male"); // Example gender
                row.createCell(8).setCellValue("Married"); // Example marital status
                row.createCell(9).setCellValue(faker.country().capital());
                row.createCell(10).setCellValue(faker.date().birthday().toString()); // Ensure date format is suitable
                row.createCell(11).setCellValue(faker.address().firstName());
                row.createCell(12).setCellValue(faker.address().fullAddress());
                row.createCell(13).setCellValue(faker.address().city());
                row.createCell(14).setCellValue(faker.address().state());
                row.createCell(15).setCellValue(faker.address().zipCode());
                row.createCell(16).setCellValue(faker.address().country());
                row.createCell(17).setCellValue(faker.phoneNumber().phoneNumber());
                row.createCell(18).setCellValue(faker.phoneNumber().cellPhone());
                row.createCell(19).setCellValue(faker.phoneNumber().phoneNumber());
                row.createCell(20).setCellValue(faker.internet().emailAddress());
                row.createCell(21).setCellValue(faker.internet().safeEmailAddress());
            }

            // Write changes back to the Excel file
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
        } 
        finally {
            // Close resources
            workbook.close();
            inputStream.close();
        }
    }
}
