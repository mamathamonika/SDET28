package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelTest {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		
		sheet.createRow(2).createCell(0).setCellValue("Test script name");
		sheet.createRow(3).createCell(0).setCellValue("contact name");
		
		sheet.createRow(2).createCell(1).setCellValue("Test script num");
		sheet.createRow(3).createCell(1).setCellValue("TC_2");
		
		sheet.createRow(2).createCell(2).setCellValue("contact last name");
		sheet.createRow(3).createCell(2).setCellValue("AY");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/data.xlsx");
		workbook.write(fos);
		System.out.println("data added");
		workbook.close();
		
	}

}
