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

public class VYMOHomePage 
{

	public static WaitUtility wait;
	AppiumDriver driver;
	ExtentTest logging =null;
	ReportUtility report=null;
	
	@AndroidFindBy(id="com.getvymo.android:id/menu_filters")
	private WebElement vymoFilterIcon;
	
	public VYMOHomePage(AndroidDriver driver) 
	{
		this.driver=(AppiumDriver)driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		wait= new WaitUtility();
		report=new ReportUtility();
		logging = UtilityInstanceTransfer.getExtentTest();
	}
	
	public boolean validateVYMOHomePage()
	{
		return vymoFilterIcon.isDisplayed();
	}
}
