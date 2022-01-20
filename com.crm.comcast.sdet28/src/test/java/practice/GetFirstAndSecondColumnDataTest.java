package practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetFirstAndSecondColumnDataTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		int lastRow = sheet.getLastRowNum();
		System.out.println(lastRow);
		
		for(int i=1; i<=lastRow;i++)
		{
			Row row = sheet.getRow(i);
			String firstCelValue = row.getCell(0).getStringCellValue();
			String secondCelValue = row.getCell(1).getStringCellValue();
			String thirdCelValue = row.getCell(2).getStringCellValue();
			System.out.println(firstCelValue+"\t"+secondCelValue+"\t"+thirdCelValue);
		}
		workbook.close();

	}

}
