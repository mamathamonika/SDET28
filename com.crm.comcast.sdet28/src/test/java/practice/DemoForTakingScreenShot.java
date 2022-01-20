package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoForTakingScreenShot {

	@Test
	public void sample()
	{
		String except ="hi";
		String actual ="hi";
		Assert.assertEquals(except, actual);
		
	}
}
