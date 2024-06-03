package com.superapp.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;

public class ScreenshotUtility 
{

	public AppiumDriver driver;

	public ScreenshotUtility(AppiumDriver driver) 
	{

		this.driver=driver;

	}

	public String getScreenshot(String path) 
	{

		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		//File screenSourcePath=screenshot.getScreenshotAs(OutputType.FILE);

		byte[] screenshotBytes = screenshot.getScreenshotAs(OutputType.BYTES);
		try 
		{
			Files.write(Paths.get(path), screenshotBytes);
		} 
		catch (IOException e1) 
		{
			
			e1.printStackTrace();
		}

		String screenDestPath=path;

		try 
		{
			//FileUtils.copyFile(screenSourcePath, new File(screenDestPath));
			Files.write(Paths.get(path), screenshotBytes);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		return screenDestPath;

	}


}
