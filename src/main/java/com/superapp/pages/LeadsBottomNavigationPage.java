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

public class LeadsBottomNavigationPage 
{

	private AppiumDriver driver;
	WaitUtility wait;
	ExtentTest logging =null;
	ReportUtility report=null;
	

	@AndroidFindBy(accessibility="Leads")
	private WebElement android_leadsBottomLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Leads']")
	private WebElement android_leadsHeader;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='All']")
	private WebElement android_allFilter;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Hot']")
	private WebElement android_hotFilter;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Warm']")
	private WebElement android_warmFilter;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Cold']")
	private WebElement android_coldFilter;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(text(), 'Customer ID')]")
	private WebElement android_customerID;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Portfolio']")
	private WebElement android_portfolio;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Activity']]")
	private WebElement android_activity;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Policy Login']]")
	private WebElement android_policyLoginLeads;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='More']]")
	private WebElement android_moreLeads;

	
	public LeadsBottomNavigationPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		wait= new WaitUtility();
		report=new ReportUtility();
		logging = UtilityInstanceTransfer.getExtentTest();
	}
	
	
	public void leadsBottomLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_leadsBottomLauncher);
		android_leadsBottomLauncher.click();
		report.info(logging, "Click on Menu Leads Bottom Launcher");
	}
	
	public void leadsHeader()
	{
		wait.explicitWaitVisibilityOf(driver, android_leadsHeader);
		android_leadsHeader.getText();
		report.info(logging, "Get title of the page header");
	}
	
	public void allFilter()
	{
		wait.explicitWaitVisibilityOf(driver, android_allFilter);
		android_allFilter.click();
		report.info(logging, "Click on All filter");
	}
	
	public void hotFilter()
	{
		wait.explicitWaitVisibilityOf(driver, android_leadsBottomLauncher);
		android_hotFilter.click();
		report.info(logging, "Click on Hot filter");
	}
	
	public void warmFilter()
	{
		wait.explicitWaitVisibilityOf(driver, android_warmFilter);
		android_warmFilter.click();
		report.info(logging, "Click on warm filer");
	}
	
	public void coldFilter()
	{
		wait.explicitWaitVisibilityOf(driver, android_coldFilter);
		android_coldFilter.click();
		report.info(logging, "Click on cold filter");
	}
	
	public void customerID()
	{
		wait.explicitWaitVisibilityOf(driver, android_customerID);
		android_customerID.click();
		report.info(logging, "Click on Customer Profile");
	}
	
	public void portfolio()
	{
		wait.explicitWaitVisibilityOf(driver, android_portfolio);
		android_portfolio.click();
		report.info(logging, "Click on Customer's Portfolio");
	}
	
	public void activity()
	{
		wait.explicitWaitVisibilityOf(driver, android_activity);
		android_activity.click();
		report.info(logging, "Click on Customer's Activity");
	}
	
	public void policyLoginLeads()
	{
		wait.explicitWaitVisibilityOf(driver, android_policyLoginLeads);
		android_policyLoginLeads.click();
		report.info(logging, "Click on Customer's Policy Login");
	}
	
	public void moreLeads()
	{
		wait.explicitWaitVisibilityOf(driver, android_moreLeads);
		android_moreLeads.click();
		report.info(logging, "Click on Customer's More option");
	}
	
	
}


