package com.superapp.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtility 
{

	private ExtentReports report;

	public void init(String filePath, String title, String reportname, String browserName) 
	{
		ExtentSparkReporter spark = new ExtentSparkReporter(filePath);
		spark.config().setDocumentTitle(title);
		spark.config().setReportName(reportname);
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", browserName);
		report.setSystemInfo("OS", System.getProperty("os.name"));

	}

	public void createTest(String testName) 
	{
		ExtentTest test = report.createTest(testName);
	    UtilityInstanceTransfer.setExtentTest(test);
	}

	public void pass(ExtentTest test,String message) 
	{
		test.pass(message);
		System.out.println(message);
	}

	public void fail(ExtentTest test, Media media, Throwable errorMsg) 
	{
		test.fail(errorMsg);
		//test.addScreenCaptureFromPath(path);
		test.log(Status.FAIL, media);
	}

	public void addCategory(ExtentTest test, String...names ) 
	{
		test.assignCategory(names);
	}

	public void warn(ExtentTest test,String message) 
	{
		test.warning(message);
		System.out.println(message);
	}

	public void skip(ExtentTest test,String message) 
	{
		test.skip(message);
		System.out.println(message);
	}

	public void skip(ExtentTest test,Throwable errorMessage) 
	{
		test.skip(errorMessage);
		System.out.println(errorMessage);
	}

	public void info(ExtentTest test,String message) 
	{
		test.info(message);
		System.out.println(message);
	}

	public void addAuthor(ExtentTest test, String... names) 
	{
		test.assignAuthor(names);
	}

	public void attachScreenshot(ExtentTest test, String screenshotPath, String title, String strategy) 
	{

		if (strategy.equalsIgnoreCase("base64"))
			test.addScreenCaptureFromBase64String(screenshotPath, title);
		else
			test.addScreenCaptureFromPath(screenshotPath, title);
	}

	public void saveReport() 
	{
		report.flush();
	}
	
}
