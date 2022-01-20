package practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CheckFirstValueAndGetSecondValueFromExcelTest {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		
		String firstvalue = "create organization";
		int lastrow = sheet.getLastRowNum();
			
		for(int i=1;i<=lastrow;i++)
		{
			Row row = sheet.getRow(i);
			String firstCellValue = row.getCell(0).getStringCellValue();
			if(firstvalue.equals(firstCellValue))
			{
				String secondvalue = row.getCell(1).getStringCellValue();
				System.out.println(secondvalue);
			}
		}
		System.out.println("not found");
		workbook.close();
	}

}
