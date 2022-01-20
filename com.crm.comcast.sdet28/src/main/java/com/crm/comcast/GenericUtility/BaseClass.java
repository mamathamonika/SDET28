package com.crm.comcast.GenericUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;

/**
 * 
 * @author Mamatha
 *
 */

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;

	//object creation for utilies and objectRepository
	public FileUtility fUtil = new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	//public LoginPage loginPage = new LoginPage(driver);
	//public HomePage homePage = new HomePage(driver);

	/**
	 * connection to data base
	 */

	@BeforeSuite (groups={"smokeTest","regressionTest"})
	public void dataBaseConnection() {
		System.out.println("=======connected to database========");
	}

	/**
	 * to launch the browser
	 * @throws Throwable
	 */
	//@Parameters("browser")
	@BeforeClass (groups={"smokeTest","regressionTest"})
	public void launchBrowser() throws Throwable {
		String browser = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		if(browser.equals("chrome"))
		{
			System.setProperty(IpathConstants.CHROME_KEY,IpathConstants.CHROME_PATH);
			driver = new ChromeDriver();
		}

		else 
		{
			System.out.println("unsupported browser");
		}
        sdriver=driver;
		driver.manage().window().maximize();
		wUtil.waitForPageToLoad(driver);
		driver.get(url);			
	}

	/**
	 * to login to the application
	 * @throws Throwable
	 */

	@BeforeMethod (groups={"smokeTest","regressionTest"})
	public void loginToAppTest()throws Throwable {
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
	    LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(username, password);
	}

	/**
	 * to logout of application
	 */
	@AfterMethod (groups={"smokeTest","regressionTest"})
	public void logoutOfApplication() {
		HomePage homePage = new HomePage(driver);
		homePage.logout();
	}

	/**
	 * to close the browser
	 */
	@AfterClass (groups={"smokeTest","regressionTest"})
	public void closeBrowser() {
		driver.quit();
	}


	/**
	 * to close the database connection
	 */
	@AfterSuite (groups={"smokeTest","regressionTest"})
	public void closeDatabase() {
		System.out.println("=======close connection database========");
	}
}
