package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateOrgTestNgTest {
	
	@BeforeClass
	public void bc()
	{
		System.out.println("launch the browser");
	}
	
	@BeforeMethod
	public void bm() {
		System.out.println("login to application");
	}
	
	@AfterClass
	public void ac() {
		System.out.println("close the browser");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("logout from application");
	}
	
	@Test (priority = 1)
	public void createOrg() {
		System.out.println("create org");
		System.out.println("verify org");
	}

	@Test(priority = 2)
	public void createContact() {
		System.out.println("create Contact");
		System.out.println("verify Contact");
	}
	
	@Test(priority = 3)
	public void createProduct() {
		System.out.println("create Product");
		System.out.println("verify Product");
	}
}
