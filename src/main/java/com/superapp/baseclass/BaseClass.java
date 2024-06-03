package com.superapp.baseclass;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.superapp.utils.DriverAndroid;
import com.superapp.utils.ScreenshotUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass 
{
	
	public static AppiumDriver driver;
	public static ScreenshotUtility sc;
	
	
	@BeforeSuite
	public void startServer() throws MalformedURLException
	{  
		AppiumServer.startServer();
	}
	
	
	@AfterSuite
	public void tearDown()
	{
		AppiumServer.tearDown();
	}
	
	
	@BeforeMethod
	public void  openApplication() throws MalformedURLException
	{
		 driver=AppFactory.launchApp();
		 sc=new ScreenshotUtility(driver);
	}
			
}
