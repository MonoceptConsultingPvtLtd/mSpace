package com.superapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.superapp.baseclass.BaseClass;
import com.superapp.pages.ApplicationLoginPage;
import com.superapp.pages.AttendanceDrawerPage;
import com.superapp.pages.CaroselScreenPage;
import com.superapp.pages.MSpaceHomePage;
import com.superapp.pages.MenuBottomLauncherNavigationPage;
import com.superapp.pages.QuickLinksPage;
import com.superapp.pages.SSOLoginPage;
import com.superapp.pages.VymoAddCATLMSPage;
import com.superapp.utils.GenerateDynamicTestNG;
import com.superapp.utils.Record;

import io.appium.java_client.android.AndroidDriver;

public class VerifyAddNewLeadFromMenuLauncherTest extends BaseClass
{
	CaroselScreenPage caroselScreen = null;
	ApplicationLoginPage applicationLogin = null;
	SSOLoginPage ssoLogin = null;
	AttendanceDrawerPage attendanceDrawer= null;
	MSpaceHomePage mspaceHomePage=null;
	MenuBottomLauncherNavigationPage addNewLeadMenuLauncher=null;
	MenuBottomLauncherNavigationPage menuLauncher=null;
	VymoAddCATLMSPage vymoPage=null;

	@Record(author = "Archit")
	@Test(dataProvider = "Datadriven")
	public void clickOnAddNewLeadFromMenuLauncher(HashMap<String, String> data) throws InterruptedException
	{
		AndroidDriver adriver= (AndroidDriver) driver;
	
		caroselScreen = new CaroselScreenPage(adriver);
		applicationLogin = new ApplicationLoginPage(adriver);
		ssoLogin = new SSOLoginPage(adriver);
		attendanceDrawer= new AttendanceDrawerPage(adriver);
		mspaceHomePage=new MSpaceHomePage(adriver);
		menuLauncher=new MenuBottomLauncherNavigationPage(adriver);
		addNewLeadMenuLauncher=new MenuBottomLauncherNavigationPage(adriver);
		vymoPage=new VymoAddCATLMSPage(adriver);
		
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
		
		addNewLeadMenuLauncher.addNewLeadLauncher();
		
		
	}

	@DataProvider(name="Datadriven")
	public Object[][] getLoginValues()
	{
		return GenerateDynamicTestNG .getTestDataa("LoginData", "Login");
	}
}
