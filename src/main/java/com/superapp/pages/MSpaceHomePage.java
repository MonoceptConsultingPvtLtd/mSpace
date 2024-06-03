package com.superapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.genericutility.WaitUtility;
import com.superapp.report.ReportUtility;
import com.superapp.report.UtilityInstanceTransfer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MSpaceHomePage 
{
	public static WaitUtility wait;
	AppiumDriver driver;
	ExtentTest logging =null;
	ReportUtility report=null;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Skip']")
	private WebElement android_skipGesture;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Today's schedule']")
	private WebElement android_todaysScheduleHeader;
	
	@AndroidFindBy(id="profileIcon")
	private WebElement android_profileIcon;

	public MSpaceHomePage(AndroidDriver driver) 
	{
		this.driver=(AppiumDriver)driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		wait= new WaitUtility();
		report=new ReportUtility();
		logging = UtilityInstanceTransfer.getExtentTest();
	}

	public void skipGesture()
	{   
		wait.explicitWaitVisibilityOf(driver, android_skipGesture);
		android_skipGesture.click();
		report.info(logging, "Click on Skip Gesture which is visible in mSpace Home Page");
	}

	public boolean skipGestureInHomePage()
	{

		boolean isGestureInHomePage=false;

		if(android_skipGesture.isDisplayed())
		{
			isGestureInHomePage=true;
			report.info(logging, "Skip gesture option is Displayed");
		}

		return isGestureInHomePage;

	}


}
