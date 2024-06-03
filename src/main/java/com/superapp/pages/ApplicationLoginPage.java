package com.superapp.pages;

import org.openqa.selenium.WebDriver;
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

public class ApplicationLoginPage 
{

	public static WaitUtility wait;
	AppiumDriver driver;
	ExtentTest logging =null;
	ReportUtility report=null;
	
	@AndroidFindBy(accessibility="Login")
	private WebElement android_loginButton;
	
	public ApplicationLoginPage(AndroidDriver driver) 
	{
		this.driver=(AppiumDriver)driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		wait= new WaitUtility();
		report=new ReportUtility();
		logging = UtilityInstanceTransfer.getExtentTest();
	}
	
	public void applicationLogin()
	{   
	    wait.explicitWaitVisibilityOf(driver, android_loginButton);
	    android_loginButton.click();
		report.info(logging, "Click on MaxLife Login button");
	}
	
	
	public String applicationLoginPage()
	{
		
		String isNavigatedToApplicationLoginPage="";
		
		if(android_loginButton.isDisplayed())
		{
			isNavigatedToApplicationLoginPage="Login";
			report.info(logging, "MaxLife Application Page is Displayed");
		}

		return isNavigatedToApplicationLoginPage;
	
	}
	
}
