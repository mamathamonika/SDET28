package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		Properties property = new Properties();
		property.load(fis);
		String browser = property.getProperty("browser");
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		String orgnameexcel = workbook.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String expected = workbook.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();

		Random random = new Random();
		int num = random.nextInt(1000);
		String orgname = orgnameexcel + num;
		
		
		WebDriver driver = null;
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.out.println("browser not supported");
		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actual= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(actual.contains(expected))
		{
			System.out.println("organization created");
		}
		else
		{
			System.out.println("organization not created");
		}
		driver.quit();
	}

}
