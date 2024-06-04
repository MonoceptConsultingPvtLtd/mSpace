package com.superapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.superapp.baseclass.BaseClass;
import com.superapp.pages.ApplicationLoginPage;
import com.superapp.pages.AttendanceDrawerPage;
import com.superapp.pages.CaroselScreenPage;
import com.superapp.pages.GenerateQuotePage;
import com.superapp.pages.MSpaceHomePage;
import com.superapp.pages.MenuBottomLauncherNavigationPage;
import com.superapp.pages.SSOLoginPage;
import com.superapp.utils.DriverAndroid;
import com.superapp.utils.GenerateDynamicTestNG;
import com.superapp.utils.Record;

import io.appium.java_client.android.AndroidDriver;

public class GenerateQuoteContinueButtonCloseValidationTest extends BaseClass
{
	CaroselScreenPage caroselScreen = null;
	ApplicationLoginPage applicationLogin = null;
	SSOLoginPage ssoLogin = null;
	AttendanceDrawerPage attendanceDrawer= null;
	MSpaceHomePage mspaceHomePage=null;
	MenuBottomLauncherNavigationPage menuLauncher=null;
	MenuBottomLauncherNavigationPage generateQuoteMenuLauncher=null;
	GenerateQuotePage generateQuotePage=null;
	DriverAndroid contextHandles=null;


	@Record(author = "Narada")
	@Test(dataProvider = "Datadriven")
	public void generateQuoteContinueButtonCloseValidationTest(HashMap<String, String> data) throws InterruptedException
	{

		AndroidDriver adriver= (AndroidDriver) driver;

		caroselScreen = new CaroselScreenPage(adriver);
		applicationLogin = new ApplicationLoginPage(adriver);
		ssoLogin = new SSOLoginPage(adriver);
		attendanceDrawer= new AttendanceDrawerPage(adriver);
		mspaceHomePage=new MSpaceHomePage(adriver);
		generateQuoteMenuLauncher=new MenuBottomLauncherNavigationPage(adriver);
		menuLauncher=new MenuBottomLauncherNavigationPage(adriver);
		generateQuotePage=new GenerateQuotePage(adriver);
		contextHandles=new DriverAndroid(adriver);

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
		
		menuLauncher.menuLauncher();

		generateQuoteMenuLauncher.generateQuoteLauncher();
		
		generateQuotePage.generateQuoteCoachMark();
		
		Assert.assertEquals("Generate Quote",generateQuotePage.validateGenerateQuoteHeader());
	
		generateQuotePage.selectLeadsFromGenerateQuotePage();
		
		Assert.assertEquals("Generate Quote",generateQuotePage.validateGenerateQuoteHomePageHeader());

		generateQuotePage.generateQuoteCloseSymbol();
		
		Assert.assertEquals("Want to exit journey?",generateQuotePage.validateGenerateQuoteCloseDrawer());
		
		generateQuotePage.continueGenerateQuote();
		
		Assert.assertEquals("Generate Quote",generateQuotePage.validateGenerateQuoteHomePageHeader());
	}

	@DataProvider(name="Datadriven")
	public Object[][] getLoginValues()
	{

		return GenerateDynamicTestNG .getTestDataa("LoginData", "Login");
	}
}
