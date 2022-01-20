package com.crm.comcast.GenericUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpClass extends BaseClass implements ITestListener {

	public void onTestFailure(ITestResult result) {
		String testCaseName = result.getMethod().getMethodName();
		EventFiringWebDriver event = new EventFiringWebDriver(BaseClass.sdriver);
		File src = event.getScreenshotAs(OutputType.FILE);
		File destination = new File("./photo/"+testCaseName+".png");
		
		try {
		FileUtils.copyFile(src,destination);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
