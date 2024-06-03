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

public class AttendanceDrawerPage 
{

	private AppiumDriver driver;
	WaitUtility wait;
	ExtentTest logging =null;
	ReportUtility report=null;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Regularize Attendance']")
	private WebElement android_validateAttendance;

	@AndroidFindBy(accessibility = "I will do it later")
	private WebElement android_attendanceLater;

	@AndroidFindBy(xpath= "//android.widget.TextView[contains(@text, 'Login')]")
	private WebElement android_maxLifeLoginLogo;


	public AttendanceDrawerPage(AndroidDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		wait= new WaitUtility();
		report=new ReportUtility();
		logging = UtilityInstanceTransfer.getExtentTest();
	}

	public boolean validateAttendance()
	{
		boolean isRegularizedAttendanceButton=false;
		
		if(android_validateAttendance.getText().equals("Regularize Attendance"))
		{
			isRegularizedAttendanceButton=true;
			report.info(logging, "Attendance Drawer is popped");
		}

		return isRegularizedAttendanceButton;
	}

	public void markAttendanceLater()
	{
		wait.explicitWaitVisibilityOf(driver, android_attendanceLater);
		android_attendanceLater.click();	
		report.info(logging, "Click on I Will do it Later option");
	}
	
	public void markAttendance()
	{
		wait.explicitWaitVisibilityOf(driver, android_attendanceLater);
		android_validateAttendance.click();	
		report.info(logging, "Click on Regularize Attendance option");
	}

}
