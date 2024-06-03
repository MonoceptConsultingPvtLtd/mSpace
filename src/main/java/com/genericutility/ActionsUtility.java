package com.genericutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ActionsUtility 
{

	
	Actions a=null;
	public void initializeAction(AppiumDriver driver) 
	{
		a=new Actions(driver);
	}
	
	/**
	 * This generic method will move the mouse to the particular Web element
	 * @param element
	 */
	public void mouseHover(WebElement element) 
	{
		a.moveToElement(element).perform();
	}
	
	/**
	 * This generic method will perform the drag and drop action
	 * @param src
	 * @param dest
	 */
	public void dragAndDropWebElement(WebElement src,WebElement dest) 
	{
		a.dragAndDrop(src, dest).perform();
	}
	
	/**
	 * This generic method will perform double click
	 * @param element
	 */
	public void doubleClickWebElement(WebElement element) 
	{
		a.doubleClick(element).perform();
	}
	
	/**
	 * This generic method will perform right click
	 * @param element
	 */
	public void contextClickWebElement(WebElement element) 
	{
		a.contextClick(element).perform();
	}
	
	public void sendValues(String value)
	{
		a.sendKeys(value).perform();
	}
	
}
