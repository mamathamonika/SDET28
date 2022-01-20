package practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetTheDataFromExcelSheetTest {

	public static void main(String[] args) throws Throwable {
		
		// java object representation of physical excel sheet
		FileInputStream fis = new FileInputStream("./src/test/resources/data.xlsx");
		
		//work book creation
		Workbook workbook = WorkbookFactory.create(fis);
		
		//get control of sheet
		Sheet sheet = workbook.getSheet("Sheet1");
		
		//get control of row
		Row row = sheet.getRow(1);
		
		//get control of cell
		Cell cell = row.getCell(2);
		
		//get the cell value
		String orgName = cell.getStringCellValue();
		
		System.out.println(orgName);
		workbook.close();
	}	
}
