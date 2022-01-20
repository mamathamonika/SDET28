package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {
	
	@Test
	public void hardAssertTest()
	{
		System.out.println("launch browser");
		System.out.println("login to application");
		
		String actual = "string";
		String expected ="string";
		Assert.assertEquals(actual, expected);
		
		int [] a = {1,2,3,4};
		int [] b = {1,2,3,4};
		Assert.assertEquals(a, b);
		
		System.out.println("logout of application");
		System.out.println("close browser");
		
		
	}

}
