package com.superapp.baseclass;

import java.io.File;
import java.net.MalformedURLException;

import com.superapp.utils.Constants;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer 
{

	public static AppiumDriverLocalService server;
    
	public static AppiumDriverLocalService getServer()
	{
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingPort(4723)
				.withLogFile(new File(Constants.TEST_SERVICE_LOGS_FILE_PATH))
				.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
				.withArgument(GeneralServerFlag.USE_PLUGINS, "gestures"));
	}

	public static void startServer() throws MalformedURLException
	{
	    server=getServer();
		server.start();
		server.clearOutPutStreams();
		
	}
	

	public static void tearDown()
	{
		server.stop();
	}
	
}
