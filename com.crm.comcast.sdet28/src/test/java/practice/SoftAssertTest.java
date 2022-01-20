package practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	
	@Test
	public void softAssert() {
	System.out.println("launch browser");
	System.out.println("login to application");
	
	String actual = "string";
	String expected ="string";
	SoftAssert sf = new SoftAssert();
	sf.assertEquals(actual, expected);
	
	int [] a = {1,2,3,4};
	int [] b = {1,2,3,4};
	sf.assertEquals(a, b);
	
	Reporter.log(expected,true);
	
	System.out.println("logout of application");
	System.out.println("close browser");
	sf.assertAll();
}

}
