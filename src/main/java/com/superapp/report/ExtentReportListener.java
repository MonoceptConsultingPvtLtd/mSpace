package com.superapp.report;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.superapp.baseclass.BaseClass;
import com.superapp.utils.Constants;
import com.superapp.utils.PropertyKey;
import com.superapp.utils.PropertyUtility;
import com.superapp.utils.Record;
import com.superapp.utils.ScreenshotUtility;


public class ExtentReportListener implements ITestListener, ISuiteListener
{

	public static ReportUtility report;
	public static ReportUtility sreport;
	
	public void onStart(ITestContext context) 
	{

		System.out.println("OnStart ---> Test");
	}

	
	public void onStart(ISuite suite) 
	{
		
		System.out.println("onStart");

		PropertyUtility propUtil = null;
		propUtil = new PropertyUtility(Constants.TEST_GENERIC_PROPERTY_FILE_PATH);
		propUtil.initialize(Constants.TEST_GENERIC_PROPERTY_FILE_PATH);
		
		report=new ReportUtility();
		report.init(Constants.EXTENT_REPORT_PATH,
				propUtil.getPropertyData(PropertyKey.EXTENTREPORTTITLE),
				propUtil.getPropertyData(PropertyKey.EXTENTREPORTNAME), propUtil.getPropertyData(PropertyKey.BROWSER));
		sreport=report;
	}

	
	public void onFinish(ISuite suite) 
	{
		System.out.println("onFinish");
		report.saveReport();
	}

	
	public void onTestStart(ITestResult result) 
	{
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());
		
		Record reportAnnotation= result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Record.class);
		
		report.addAuthor(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.author());
		report.addCategory(UtilityInstanceTransfer.getExtentTest(), reportAnnotation.category());
	}

	
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("onTestSuccess");
		report.pass(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName() + " PASS ");
	}

	
	public void onTestFailure(ITestResult result) 
	{   
		System.out.println("onTestFailure");
		
		ScreenshotUtility screen = new ScreenshotUtility(BaseClass.driver);
		String screenshotPath = screen.getScreenshot(Constants.TEST_SCREENSHOT_FILE_PATH.replace("picture", result.getMethod().getMethodName()));
		System.out.println(screenshotPath);
			
	    report.fail(UtilityInstanceTransfer.getExtentTest(),MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build(), result.getThrowable());
	    
	}

	
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("onTestSkipped");
		report.skip(UtilityInstanceTransfer.getExtentTest(),result.getMethod().getMethodName() + "SKIPPED");
		report.skip(UtilityInstanceTransfer.getExtentTest(),result.getThrowable());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		System.out.println("onTestFailedWithTimeout");
	}

	
	public void onFinish(ITestContext context) 
	{
		report.saveReport();
	}
	
}
