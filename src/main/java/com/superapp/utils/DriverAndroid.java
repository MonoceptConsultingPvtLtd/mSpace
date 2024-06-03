package com.superapp.utils;

import java.util.Set;

import io.appium.java_client.android.AndroidDriver;

public class DriverAndroid
{
	private  AndroidDriver driver;
	
	public DriverAndroid(AndroidDriver driver)
	{
		this.driver=driver;
	}
	
	
	/**
	 * This method is used to open the notifications in the mobile device
	 */
	public void openAndroidNotification()
	{
		driver.openNotifications();
	}
	

	/**
	 * This method is used to print all the context of native view and web view for Android
	 */
	public void androidGetViews() 
	{
		Set<String> contexts=driver.getContextHandles();	
		for(String context:contexts) 
		{
			System.out.println(context);	
		}
	}
	
	
	/**
	 * This method is used to switch to different views i.e, from native to web view or web to native view for Android
	 */
	public void androidSwitchContext(String name) 
	{
		driver.context(name);
	}
	
	
	/**
	 * This method is used to open an application by passing the app package in String for Android
	 */
	public void androidOpenApp(String appPackage)
	{
		driver.activateApp(appPackage);
	}
	
	
	/**
	 * This method is used to close an application by passing the app package in String for Android
	 */
	public void androidCloseApp(String appPackage)
	{
		driver.terminateApp(appPackage);
	}

}
