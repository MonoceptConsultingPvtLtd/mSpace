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

public class MenuBottomLauncherNavigationPage 
{

	private AppiumDriver driver;
	WaitUtility wait;
	ExtentTest logging =null;
	ReportUtility report=null;
	

	@AndroidFindBy(accessibility="Menu")
	private WebElement android_menuLauncher;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Add New Lead']")
	private WebElement android_addNewLeadLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Generate Quote']")
	private WebElement android_generateQuoteLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Compare Plan']")
	private WebElement android_comparePlansLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Policy Login']")
	private WebElement android_policyLoginLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Track Policy Applications']")
	private WebElement android_trackPolicyApplicationLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Policy Servicing']")
	private WebElement android_policyServicingLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Service Requests']")
	private WebElement android_serviceRequestsLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Policy Briefcase']")
	private WebElement android_policyBriefcaseLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sales Reports & Summary']")
	private WebElement android_salesReportsAndSummaryLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Training & Learning']")
	private WebElement android_trainingAndLearningLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='IT Helpdesk']")
	private WebElement android_iTHelpdeskLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Helpdesk']")
	private WebElement android_helpdeskLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Reports']")
	private WebElement android_reportsLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Process Guidelines']")
	private WebElement android_processGuidelinesLauncher;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Download Forms']")
	private WebElement android_downloadFormsLauncher;
	

	public MenuBottomLauncherNavigationPage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		wait= new WaitUtility();
		report=new ReportUtility();
		logging = UtilityInstanceTransfer.getExtentTest();
	}
	
	
	public void menuLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_menuLauncher);
		android_menuLauncher.click();
		report.info(logging, "Click on Menu Bottom Launcher");
	}
	
	public void addNewLeadLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_addNewLeadLauncher);
		android_addNewLeadLauncher.click();
		report.info(logging, "Click on Add New Lead Launcher");
	}
	
	public void generateQuoteLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_generateQuoteLauncher);
		android_generateQuoteLauncher.click();
		report.info(logging, "Click on Generate Quote Launcher");
	}
	
	public void comparePlansLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_comparePlansLauncher);
		android_comparePlansLauncher.click();
		report.info(logging, "Click on Compare Plans Launcher");
	}
	
	public void policyLoginLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_policyLoginLauncher);
		android_policyLoginLauncher.click();
		report.info(logging, "Click on Policy Login Launcher");
	}
	
	public void trackPolicyApplicationLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_trackPolicyApplicationLauncher);
		android_trackPolicyApplicationLauncher.click();
		report.info(logging, "Click on Track Policy Application Launcher");
	}
	
	public void policyServicingLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_policyServicingLauncher);
		android_policyServicingLauncher.click();
		report.info(logging, "Click on Policy Servicing Launcher");
	}
	
	public void serviceRequestsLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_serviceRequestsLauncher);
		android_serviceRequestsLauncher.click();
		report.info(logging, "Click on Service Requests Launcher");
	}
	
	
	public void policyBriefcaseLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_policyBriefcaseLauncher);
		android_policyBriefcaseLauncher.click();
		report.info(logging, "Click on Policy Briefcase Launcher");
	}
	
	public void salesReportsAndSummaryLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_salesReportsAndSummaryLauncher);
		android_salesReportsAndSummaryLauncher.click();
		report.info(logging, "Click on Sales Reports And Summary Launcher");
	}
	
	public void trainingAndLearningLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_trainingAndLearningLauncher);
		android_trainingAndLearningLauncher.click();	
		report.info(logging, "Click on Training And Learning Launcher");
	}
	
	public void iTHelpdeskLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_iTHelpdeskLauncher);
		android_iTHelpdeskLauncher.click();
		report.info(logging, "Click on ITHelpdesk Launcher");
	}
	
	public void helpdeskLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_helpdeskLauncher);
		android_helpdeskLauncher.click();
		report.info(logging, "Click on helpdesk Launcher");
	}
	
	public void reportsLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_reportsLauncher);
		android_reportsLauncher.click();
		report.info(logging, "Click on Reports Launcher");
	}
	
	public void processGuidelinesLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_processGuidelinesLauncher);
		android_processGuidelinesLauncher.click();
		report.info(logging, "Click on Process Guidelines Launcher");
	}
	
	public void downloadFormsLauncher()
	{
		wait.explicitWaitVisibilityOf(driver, android_downloadFormsLauncher);
		android_downloadFormsLauncher.click();
		report.info(logging, "Click on Downloads Forms Launcher");
	}
	
	
}
