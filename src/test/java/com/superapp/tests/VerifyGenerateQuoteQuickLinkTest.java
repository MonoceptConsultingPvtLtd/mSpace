package com.superapp.tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericutility.WaitUtility;
import com.superapp.baseclass.BaseClass;
import com.superapp.pages.ApplicationLoginPage;
import com.superapp.pages.AttendanceDrawerPage;
import com.superapp.pages.CaroselScreenPage;
import com.superapp.pages.GenerateQuotePage;
import com.superapp.pages.MSpaceHomePage;
import com.superapp.pages.NotificationPage;
import com.superapp.pages.QuickLinksPage;
import com.superapp.pages.SSOLoginPage;
import com.superapp.utils.GenerateDynamicTestNG;
import com.superapp.utils.GestureUtility;
import com.superapp.utils.Record;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class VerifyGenerateQuoteQuickLinkTest extends BaseClass
{

	CaroselScreenPage caroselScreen = null;
	ApplicationLoginPage applicationLogin = null;
	SSOLoginPage ssoLogin = null;
	AttendanceDrawerPage attendanceDrawer= null;
	QuickLinksPage quickLink = null;
	MSpaceHomePage mspaceHomePage=null;
	GenerateQuotePage generateQuotePage=null;

	@Record(author = "Narada")
	@Test(dataProvider = "Datadriven")
	public void clickOnGenerateQuoteQuickLinkTest(HashMap<String, String> data) throws InterruptedException
	{
		
		AndroidDriver adriver= (AndroidDriver) driver;
		
		caroselScreen = new CaroselScreenPage(adriver);
		applicationLogin = new ApplicationLoginPage(adriver);
		ssoLogin = new SSOLoginPage(adriver);
		attendanceDrawer= new AttendanceDrawerPage(adriver);
		quickLink = new QuickLinksPage(adriver);
		mspaceHomePage=new MSpaceHomePage(adriver);
		generateQuotePage=new GenerateQuotePage(adriver);
		
		caroselScreen.applicationPrivacySettings();

		Assert.assertEquals(applicationLogin.applicationLoginPage(),"Login");
		applicationLogin.applicationLogin();

		Assert.assertEquals(ssoLogin.ssoLoginPage(), true);
		System.out.println(data.get("SSO ID"));
		System.out.println(data.get("Password"));
		ssoLogin.ssoLoginDetails(data.get("SSO ID"),data.get("Password"));
		
		Assert.assertEquals(ssoLogin.validateBiometricPopUp(), true);
		ssoLogin.completeBiometric();
		
		Assert.assertEquals(mspaceHomePage.skipGestureInHomePage(), true);
		mspaceHomePage.skipGesture();
		
		quickLink.generateQuote();
		Assert.assertEquals("Generate Quote",generateQuotePage.validateGenerateQuoteHeader() );
		
	}

	@DataProvider(name="Datadriven")
	public Object[][] getLoginValues()
	{

		return GenerateDynamicTestNG .getTestDataa("LoginData", "Login");
	}

}
