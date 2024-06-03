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

public class CaroselScreenPage 
{

	WaitUtility wait;
	AppiumDriver driver;
	ExtentTest logging =null;
	ReportUtility  report=null;
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement android_whileUsingAppFirst;
	
	@AndroidFindBy(id="com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement android_whileUsingAppSecond;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement android_okButton;
	
	
	public CaroselScreenPage(AndroidDriver driver) 
	{  
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		wait= new WaitUtility();
		report=new ReportUtility();
		logging = UtilityInstanceTransfer.getExtentTest();

	}
	
	public void applicationPrivacySettings() throws InterruptedException
	{
		Thread.sleep(3000);
		
		wait.explicitWaitVisibilityOf(driver, android_whileUsingAppFirst);
		android_whileUsingAppFirst.click();
		report.info(logging, "Click on While Using App Only option");
		
		wait.explicitWaitVisibilityOf(driver, android_whileUsingAppSecond);
		android_whileUsingAppSecond.click();
		report.info(logging, "Click on While Using App Only option");
		Thread.sleep(3000);
	}
	
	
}
