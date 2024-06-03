package com.superapp.baseclass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.superapp.utils.Constants;
import com.superapp.utils.GenerateDynamicTestNG;
import com.superapp.utils.PropertyKey;
import com.superapp.utils.PropertyUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class AppFactory 
{

	static PropertyUtility p=new PropertyUtility(Constants.TEST_DEVICE_PROPERTY_FILE_PATH);
	static PropertyUtility a=new PropertyUtility(Constants.TEST_APPLICATION_PROPERTY_FILE_PATH);
	public static final String USERNAME = "sunsunnypradhan_mYpCoU";
	public static final String AUTOMATE_KEY = "3bgYPmjTWxxXvM7dowyb";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static AppiumDriver android_launchApp() throws MalformedURLException 
	{	
		HashMap<String, String> data = GenerateDynamicTestNG.getSheetName();

		AppiumDriver driver;

		DesiredCapabilities dc= new DesiredCapabilities();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(data.get("Device Name"))
		.setPlatformVersion(data.get("Android Version"))
		.setAppPackage(a.getPropertyData(PropertyKey.ANDROIDAPPPACKAGE))
		.setAppActivity(a.getPropertyData(PropertyKey.ANDROIDAPPACTIVITY));
		//.setCapability("noReset", true);

		driver = new AndroidDriver(new URL(p.getPropertyData(PropertyKey.URL)), options);

		AppDriver.setDriver(driver);
		System.out.println("AndroidDriver is set");
		return driver;

	}


	public static AppiumDriver ios_launchApp() throws MalformedURLException, MalformedURLException 
	{   
		AppiumDriver driver;
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName(p.getPropertyData(PropertyKey.IOSDEVICE))
		.setPlatformVersion(p.getPropertyData(PropertyKey.IOSPLATFORMVERSION))
		.setBundleId(p.getPropertyData(PropertyKey.IOSBUNDLEID));

		driver = new IOSDriver(new URL(p.getPropertyData(PropertyKey.URL)), options);

		AppDriver.setDriver(driver);
		System.out.println("IOSDriver is set");
		return driver;
	}

	public static AppiumDriver androidBrowserstack_launchApp() throws MalformedURLException 
	{	
		
		AppiumDriver driver;
		DesiredCapabilities capabalities = new DesiredCapabilities();
		capabalities.setCapability("browserstack.user", USERNAME);
		capabalities.setCapability("browserstack.key", AUTOMATE_KEY);
		capabalities.setCapability("browserName", "chrome");
		capabalities.setCapability("deviceName", "Google Pixel 4");
		capabalities.setCapability("os_version", "10.0");
		capabalities.setCapability("app", "bs://809823de16f148916e92e6f89d6a17e21b4e1fe2"); 
		capabalities.setCapability("enableBiometric", "true");

		driver = new AndroidDriver(new URL(URL), capabalities);

		AppDriver.setDriver(driver);
		System.out.println("AndroidDriver is set");
		return driver;

	}

	public static AppiumDriver launchApp() throws MalformedURLException 
	{
		System.out.println(AppData.platform);
		
		AppiumDriver driver = null;
		System.out.println("Entering into MaxLife App");

		if(AppData.platform.equalsIgnoreCase("ios"))
		{
			driver= ios_launchApp();
			System.out.println("iOS launched");
		}

		else if(AppData.platform.equalsIgnoreCase("android"))
		{
			driver= android_launchApp();
			System.out.println("Android launched");
		}
		
		else if (AppData.platform.equalsIgnoreCase("browserandroid")) 
		{
			driver= androidBrowserstack_launchApp();
			System.out.println("Browserstack Android launched");
		}
		return driver;
	}



}
