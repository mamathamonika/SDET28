package com.crm.comcast.GenericUtility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImpClass extends BaseClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;


	public void onTestFailure(ITestResult result) {
		JavaUtility jUnit =new JavaUtility();

		String testCaseName = result.getMethod().getMethodName();
		EventFiringWebDriver event = new EventFiringWebDriver(BaseClass.sdriver);
		File src = event.getScreenshotAs(OutputType.FILE);
		File destination = new File("./photo/"+testCaseName+jUnit.getSystemDateAndTime()+".png");

		try {
			FileUtils.copyFile(src,destination);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(destination.getAbsolutePath());

		/*WebDriverUtility wUtil =new WebDriverUtility();
		try {
			wUtil.screenshot(driver, testCaseName);
		} catch (IOException e) {

			e.printStackTrace();
		}*/
	}


	public void onTestStart(ITestResult result) {
		//@Test
		test = report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP,result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		//@BeforeSuite
		ExtentSparkReporter spark=new ExtentSparkReporter("./extentreport.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Vtiger automation");
		spark.config().setReportName("Execution report");

		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Platform", "Windows 10");
		report.setSystemInfo("Reporter", "mamatha");
	}

	public void onFinish(ITestContext context) {
		//@AfterSuite
		report.flush();
	}

}


