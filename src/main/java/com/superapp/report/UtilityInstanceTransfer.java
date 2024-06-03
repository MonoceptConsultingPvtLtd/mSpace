package com.superapp.report;

import com.aventstack.extentreports.ExtentTest;

public class UtilityInstanceTransfer 
{

private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public static ExtentTest getExtentTest() 
	{
		return extentTest.get();
	}
	
	public static void setExtentTest(ExtentTest setExtentTest) 
	{
		extentTest.set(setExtentTest);
	}
	
}
