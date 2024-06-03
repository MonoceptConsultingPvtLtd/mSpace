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

public class NotificationPage 
{
	private AppiumDriver driver;
	WaitUtility wait;
	ExtentTest logging =null;
	ReportUtility report=null;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Notifications']")
	private WebElement android_notificationHeader;

	@AndroidFindBy(className="com.horcrux.svg.PathView")
	private WebElement android_notificationIcon;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='All']")
	private WebElement android_allTab;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Pre-Sales']")
	private WebElement android_preSalesTab;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Sales & Servicing']")
	private WebElement android_salesAndServicingTab;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Others']")
	private WebElement android_othersTab;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Mark all as read']")
	private WebElement android_markAllAsReadTab;

	@AndroidFindBy(className="com.horcrux.svg.PathView")
	private WebElement android_backNotificationButton;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Mark all as read']")
	private WebElement android_notificationSearchTextField;

	@AndroidFindBy(className="com.horcrux.svg.PathView")
	private WebElement android_closeSearchTextField;

	public NotificationPage(AndroidDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		wait= new WaitUtility();
		report=new ReportUtility();
		logging = UtilityInstanceTransfer.getExtentTest();
	}

	public void notificationIcon()
	{
		wait.explicitWaitVisibilityOf(driver, android_notificationIcon);
		android_notificationIcon.click();
		report.info(logging, "Click on Notification Icon");
	}

	public void backNotificationButton()
	{
		wait.explicitWaitVisibilityOf(driver, android_backNotificationButton);
		android_backNotificationButton.click();
		report.info(logging, "Click on Notification back icon");
	}

	public void performNotificationActionForSalesAndServicing()
	{
		wait.explicitWaitVisibilityOf(driver, android_salesAndServicingTab);
		android_salesAndServicingTab.click();
		report.info(logging, "Click on Sales and Servicing Tab");
	}

	public void performNotificationActionForPreSales()
	{
		wait.explicitWaitVisibilityOf(driver, android_preSalesTab);
		android_preSalesTab.click();
		report.info(logging, "Click on Pre-Sales Tab");
	}

	public void performNotificationActionForOthers()
	{
		wait.explicitWaitVisibilityOf(driver, android_othersTab);
		android_othersTab.click();
		report.info(logging, "Click on Others Tab");
	}

	public void performMarkAllAsReadAction()
	{
		wait.explicitWaitVisibilityOf(driver, android_markAllAsReadTab);
		android_markAllAsReadTab.click();
		report.info(logging, "Click on Mark All As Read button");
	}

	public void performNotificationActionForAllTab()
	{
		wait.explicitWaitVisibilityOf(driver, android_markAllAsReadTab);
		android_markAllAsReadTab.click();
		report.info(logging, "Click on Mark All As Read button");
	}

	public boolean validateNotificationPage()
	{

		System.out.println(android_notificationHeader.getText());

		boolean isNotificationHeader=false;


		if(android_notificationHeader.getText().equals("Notifications"))
		{
			isNotificationHeader=true;
			report.info(logging, "Notification Page is Displayed");
		}

		return isNotificationHeader;

	}

}
