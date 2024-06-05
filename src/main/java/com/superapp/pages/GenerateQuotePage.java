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

public class GenerateQuotePage 
{
	WaitUtility wait;
	AppiumDriver driver;
	ExtentTest logging =null;
	ReportUtility  report=null;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Generate Quote']")
	private WebElement android_generateQuoteHeader;

	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"Got it!\"]/android.widget.TextView")
	private WebElement android_generateQuoteCoachMark;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
	private WebElement android_searchButtonGenerateQuote;

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search...']")
	private WebElement android_generateQuoteSearchTextField;

	@AndroidFindBy(className="android.widget.EditText")
	private WebElement android_generateQuoteClearSearchField;

	@AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"TM, Test Calendar Meeting, Not Interested, 1d ago\"]/android.widget.TextView[1]")
	private WebElement android_generateQuoteSelectLeadFromGenerateQuote;

	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[7]/android.view.View/android.view.View/android.view.View")
	private WebElement android_generateQuoteProposerDrawer;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Generate Quote']")
	private WebElement android_generateQuoteHomePageHeader;

	@AndroidFindBy(className="com.horcrux.svg.PathView")
	private WebElement android_generateQuoteHomePageCloseSymbol;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Want to exit journey?']")
	private WebElement android_generateQuoteHomePageExitMessagePopUp;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Yes, Exit']")
	private WebElement android_generateQuoteHomePageExitButton;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='No, Continue']")
	private WebElement android_generateQuoteHomePageContinueButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='No, Continue']")
	private WebElement android_generateQuoteSelectPlanButton;

	public GenerateQuotePage(AndroidDriver driver) 
	{  
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		wait= new WaitUtility();
		report=new ReportUtility();
		logging = UtilityInstanceTransfer.getExtentTest();
	}

	public String validateGenerateQuoteHeader()
	{
		String generateQuoteHeader=android_generateQuoteHeader.getText();
		return generateQuoteHeader;
	}

	public void generateQuoteCoachMark()
	{
		wait.explicitWaitVisibilityOf(driver, android_generateQuoteCoachMark);
		android_generateQuoteCoachMark.click();
		report.info(logging, "Click on Got It Coach Mark");
	}

	public void searchFuntionality()
	{
		wait.explicitWaitVisibilityOf(driver, android_searchButtonGenerateQuote);
		android_searchButtonGenerateQuote.click();
		report.info(logging, "Click on Search Button");
		android_generateQuoteSearchTextField.sendKeys("Test Calendar Meeting");
		report.info(logging, "Enter Leads Name");
		android_generateQuoteClearSearchField.clear();
		report.info(logging, "Clear Leads Name");
	}

	public void selectLeadsFromGenerateQuotePage()
	{
		wait.explicitWaitVisibilityOf(driver, android_generateQuoteSelectLeadFromGenerateQuote);
		android_generateQuoteSelectLeadFromGenerateQuote.click();
		report.info(logging, "Select the lead from the Generate Quote");
		wait.explicitWaitVisibilityOf(driver, android_generateQuoteProposerDrawer);
		android_generateQuoteProposerDrawer.click();
		report.info(logging, "Select the Proposer/Insurer from Pop Up");
	}

	public String validateGenerateQuoteHomePageHeader()
	{
		String generateQuoteHomePageHeader=android_generateQuoteHomePageHeader.getText();
		return generateQuoteHomePageHeader;
	}

	public void generateQuoteCloseSymbol()
	{
		wait.explicitWaitVisibilityOf(driver, android_generateQuoteHomePageCloseSymbol);
		android_generateQuoteHomePageCloseSymbol.click();
		report.info(logging, "Click on close Symbol X");
	}

	public String validateGenerateQuoteCloseDrawer()
	{
		wait.explicitWaitVisibilityOf(driver, android_generateQuoteHomePageExitMessagePopUp);
		String validateGenerateQuoteCloseDrawer=android_generateQuoteHomePageExitMessagePopUp.getText();
		report.info(logging, "Close Validation Pop-Up is displayed");
		return validateGenerateQuoteCloseDrawer;
	}
	
	public void exitGenerateQuote()
	{	
		wait.explicitWaitVisibilityOf(driver, android_generateQuoteHomePageExitButton);
		android_generateQuoteHomePageExitButton.click();
		report.info(logging, "Yes, Exit button is clicked and Generate Quote page is exited");
	}
	
	public void continueGenerateQuote()
	{	
		wait.explicitWaitVisibilityOf(driver, android_generateQuoteHomePageContinueButton);
		android_generateQuoteHomePageContinueButton.click();
		report.info(logging, "Yes, Continue button is clicked and returns back to the Generate Quote Home Page");
	}
	
	public void selectPlanButton()
	{
		wait.explicitWaitVisibilityOf(driver, android_generateQuoteSelectPlanButton);
		android_generateQuoteSelectPlanButton.click();
		report.info(logging, "Click on Select Plan Button");
	}

}
