package com.superapp.utils;

import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.genericutility.WaitUtility;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class GestureUtility 
{

	private AppiumDriver driver;
	WaitUtility wait;

	public GestureUtility(AppiumDriver driver) 
	{

		this.driver=driver;
		wait=new WaitUtility();			

	}



	/**
	 * This gesture performs long click action on the given element/coordinates
	 */
	public void longClickGesture(RemoteWebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()
						));
	}


	/**
	 * This gesture performs double click action on the given element/coordinates
	 */
	public void doubleClickGesture(RemoteWebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()
						));
	}


	/**
	 * This gesture performs click action on the given element/coordinates
	 */
	public void clickGesture(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: clickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()
						));
	}


	/**
	 * This gesture performs drag action from the given element/coordinates to the given point
	 */
	public void dragGesture(RemoteWebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
				"endX", 100,
				"endY", 100
				));
	}


	/**
	 * This gesture performs pinch-open gesture on the given element/area
	 */
	public void pinchOpenGesture(RemoteWebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
				"percent", 0.75
				));
	}


	/**
	 * This gesture performs pinch-close gesture on the given element/area
	 */
	public void pinchCloseGesture(RemoteWebElement element)
	{
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
				"percent", 0.75
				));
	}


	/**
	 * This gesture performs scroll action until the given Attribute Value
	 * @param Attribute Name
	 * @param Attribute Value
	 */
	public void scrollIntoGesture(String an, String av)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))"));
	}

	public void scrollGesture()
	{
		WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='PERFORMANCE']"));
		driver.executeScript("mobile:scroll", 
				ImmutableMap.of("direction", "down", "element", ((RemoteWebElement) element).getId())
				);
	}



	/**
	 * This method is used to get the status of the App for Android and iOS both
	 */
	public void getStatus() 
	{
		driver.getStatus();
	}


	/**
	 * This method is used to enter data in text field
	 * @param element
	 * @param data
	 */
	public void enterData(String element, String data)
	{
		driver.findElement(AppiumBy.accessibilityId(element)).sendKeys(data);
	}


	/**
	 * This generic method will fetch the title of the window
	 */
	public void getWindowtitle() 
	{
		driver.getTitle();

	}


	/**
	 * This generic method will navigate the web page to specified url
	 * @param url
	 */
	public void navigateToUrl(String url) 
	{
		driver.navigate().to(url);
	}


	/**
	 * This generic method will click on back button
	 */
	public void back() 
	{
		driver.navigate().back();

	}


	/**
	 * This generic method will click on forward button
	 */
	public void forward() 
	{
		driver.navigate().forward();
	}


	public String getTexts(String element)
	{
		return driver.findElement(AppiumBy.id(element)).getText();
	}

}
