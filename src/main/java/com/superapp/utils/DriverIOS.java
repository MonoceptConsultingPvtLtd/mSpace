package com.superapp.utils;

import java.util.Set;

import io.appium.java_client.ios.IOSDriver;

public class DriverIOS 
{
	
	IOSDriver iosDriver;
	
	public DriverIOS(IOSDriver driver)
	{
		this.iosDriver=driver;
	}
	
	/**
	 * This method is used to print all the context of native view and web view for iOS
	 */
	public void iosGetViews() 
	{
		Set<String> contexts=iosDriver.getContextHandles();	
		for(String context:contexts) 
		{
			System.out.println(context);	
		}
	}
	

	/**
	 * This method is used to switch to different views i.e, from native to web view or web to native view for iOS
	 */
	public void iosSwitchContext(String name) 
	{
		iosDriver.context(name);
	}
	
	
	/**
	 * This method is used to open an application by passing the app package in String for iOS
	 */
	public void iosOpenApp(String appPackage)
	{
		iosDriver.activateApp(appPackage);
	}
	
	
	/**
	 * This method is used to close an application by passing the app package in String for iOS
	 */
	public void iosCloseApp(String appPackage)
	{
		iosDriver.terminateApp(appPackage);
	}

}
