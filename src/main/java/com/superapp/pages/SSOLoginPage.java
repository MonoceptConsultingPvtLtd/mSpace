package com.superapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.genericutility.ActionsUtility;
import com.genericutility.DriverActionUtility;
import com.genericutility.WaitUtility;
import com.superapp.report.ReportUtility;
import com.superapp.report.UtilityInstanceTransfer;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SSOLoginPage 
{
	
	WaitUtility wait;
	AppiumDriver driver;
	ExtentTest logging =null;
	ReportUtility  report=null;
	ActionsUtility action = new ActionsUtility();
	
	@AndroidFindBy(accessibility = "SSO ID")
	private WebElement android_ssoID;
	
	@AndroidFindBy(accessibility = "Password")
	private WebElement android_password;
	
	@AndroidFindBy(accessibility= "Login")
	private WebElement android_loginButton;
	
	@AndroidFindBy(xpath="android.view.ViewGroup[@index='2']")
	private WebElement android_eyeIcon;
	
	@AndroidFindBy(className="android.widget.ImageView")
	private WebElement android_rememberMe;
	
	@AndroidFindBy(xpath="android.widget.TextView[@text='Forgot password?']")
	private WebElement android_forgetPassword;
	
	@AndroidFindBy(xpath= "//android.widget.TextView[contains(@text, 'Login')]")
	private WebElement android_maxLifeLoginLogo;
	
	@AndroidFindBy(accessibility="I will do it later")
	private WebElement android_biometricLaterOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Enable Biometric']")
	private WebElement android_enableBiometricOption;
	
	
	public SSOLoginPage(AndroidDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		wait= new WaitUtility();
		report=new ReportUtility();
		logging = UtilityInstanceTransfer.getExtentTest();
	}
	
	public void ssoLoginDetails(String ssoid,String ssopassword) throws InterruptedException
	{   
		
		action.initializeAction(driver);
		
	    wait.explicitWaitVisibilityOf(driver, android_ssoID);
	    android_ssoID.click();
		report.info(logging, "Click on SSOID Text Field");
		
		wait.explicitWaitVisibilityOf(driver, android_ssoID);
	    android_ssoID.clear();
	    report.info(logging, "Clearing the SSOID Field");
	
	    wait.explicitWaitVisibilityOf(driver, android_ssoID);
		action.sendValues(ssoid);
		report.info(logging, "Enter SSOID in SSOID Field");
		
	    wait.explicitWaitVisibilityOf(driver, android_password);
	    android_password.click();
		report.info(logging, "Click on Password Text Field");
		
		wait.explicitWaitVisibilityOf(driver, android_ssoID);
		android_password.clear();
		 report.info(logging, "Clearing the Password Field");
	    
		wait.explicitWaitVisibilityOf(driver, android_password);
		action.sendValues(ssopassword);
		report.info(logging, "Enter Password in Password Field");
		
		((HidesKeyboard) driver).hideKeyboard();
		
	    wait.explicitWaitVisibilityOf(driver, android_loginButton);
	    android_loginButton.click();
		report.info(logging, "Click SSO Login Button");
		
	}
	
	
	public void completeBiometric() throws InterruptedException
	{
		wait.explicitWaitVisibilityOf(driver, android_biometricLaterOption);
		android_biometricLaterOption.click();
		report.info(logging, "Click on I will do it Later option for Biometric");
		Thread.sleep(9000);
	}
	
	public boolean ssoLoginPage()
	{
		
		boolean isNavigatedToSSOLoginPage=false;
		
		if(android_maxLifeLoginLogo.getText().equalsIgnoreCase("Login with\n"+"Max Life ID"))
		{  
			isNavigatedToSSOLoginPage=true;
			report.info(logging, "Logo is Available");
		}

		return isNavigatedToSSOLoginPage;
	
	}
	
	public boolean validateBiometricPopUp()
	{

		System.out.println(android_enableBiometricOption.getText());

		boolean isBiometricDrawerPopUp=false;

		if(android_enableBiometricOption.getText().equals("Enable Biometric"))
		{
			isBiometricDrawerPopUp=true;
			report.info(logging, "Biometric Authentication Drawer is popped");
		}

		return isBiometricDrawerPopUp;

	}
	
	
}
