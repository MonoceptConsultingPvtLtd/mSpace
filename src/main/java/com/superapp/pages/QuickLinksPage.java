package com.superapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.genericutility.WaitUtility;
import com.superapp.report.ReportUtility;
import com.superapp.report.UtilityInstanceTransfer;
import com.superapp.utils.GestureUtility;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class QuickLinksPage 
{

	private AppiumDriver driver;
	WaitUtility wait;
	ExtentTest logging =null;
	ReportUtility report=null;
	GestureUtility gesture= null;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"Add New Lead\"]/android.view.ViewGroup")
	private WebElement android_addNewLead;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"Generate Quote\"]/android.view.ViewGroup")
	private WebElement android_generateQuote;
	
	@AndroidFindBy(accessibility="Policy Login")
	private WebElement android_policyLogin;
	
	@AndroidFindBy(accessibility="Track\n"+"Application")
	private WebElement android_trackApplication;
	
	@AndroidFindBy(accessibility="Service\n"+"Requests")
	private WebElement android_serviceRequests;
	
	@AndroidFindBy(accessibility="Policy\n"+"Servicing")
	private WebElement android_policyServicing;
	
	@AndroidFindBy(accessibility="Compare\n"+"Plans")
	private WebElement android_comparePlans;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"Got it!\"]/android.widget.TextView")
	private WebElement android_generateQuoteCoachMark;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"Skip\"]/android.widget.TextView")
	private WebElement android_policyLoginCoachMark;
	
	
	public QuickLinksPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		wait= new WaitUtility();
		report=new ReportUtility();
		logging = UtilityInstanceTransfer.getExtentTest();
		gesture= new GestureUtility(driver);
	
	}
	
	
	public void addNewLead()
	{
		wait.explicitWaitVisibilityOf(driver, android_addNewLead);
		android_addNewLead.click();
		report.info(logging, "Click on Add New Lead Quick link");
	}
	
	public void generateQuote()
	{
		wait.explicitWaitVisibilityOf(driver, android_generateQuote);
		android_generateQuote.click();
		report.info(logging, "Click on Generate Quote Quick link");
		wait.explicitWaitVisibilityOf(driver, android_generateQuoteCoachMark);
		android_generateQuoteCoachMark.click();
		report.info(logging, "Click on Generate Quote Got it! Coach Mark");
	}
	
	public void policyLogin()
	{
		wait.explicitWaitVisibilityOf(driver, android_policyLogin);
		android_policyLogin.click();
		report.info(logging, "Click on Policy Login Quick link");	
		wait.explicitWaitVisibilityOf(driver, android_policyLoginCoachMark);
		android_policyLoginCoachMark.click();
		report.info(logging, "Click on Generate Quote Got it! Coach Mark");
	}
	
	public void trackApplication()
	{
		wait.explicitWaitVisibilityOf(driver, android_trackApplication);
		android_trackApplication.click();
		report.info(logging, "Click on Track Application Quick link");
	}
	
	public void serviceRequests()
	{
		wait.explicitWaitVisibilityOf(driver, android_serviceRequests);
		android_serviceRequests.click();
		report.info(logging, "Click on Service Request Quick link");
	}
	
	public void policyServicing()
	{
		wait.explicitWaitVisibilityOf(driver, android_policyServicing);
		android_policyServicing.click();
		report.info(logging, "Click on Policy Servicing Quick link");
	}
	
	public void comparePlans()
	{
		wait.explicitWaitVisibilityOf(driver, android_comparePlans);
		android_comparePlans.click();
		report.info(logging, "Click on Compare Plans Quick link");
	}
	
	
	public void navigateToGenerateQuotePage() throws InterruptedException
	{
		
		Thread.sleep(3000);
		gesture.scrollIntoGesture(null, null);
		report.info(logging, "Scrolling till Generate Quote quick link is visible");
		
		wait.explicitWaitVisibilityOf(driver, android_generateQuote);
		android_generateQuote.click();
		report.info(logging, "Click on Generate Quote Quick link");
	}
	
	public void validateAutoLoginToVYMO()
	{
		report.info(logging, "Auto Login to VYMO is completed after clicking on Add New Lead");
	}
	
}
