package com.superapp.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.superapp.baseclass.BaseClass;
import com.superapp.pages.ApplicationLoginPage;
import com.superapp.pages.CaroselScreenPage;
import com.superapp.pages.SSOLoginPage;
import com.superapp.pages.MSpaceHomePage;
import com.superapp.pages.AttendanceDrawerPage;
import com.superapp.utils.GenerateDynamicTestNG;
import com.superapp.utils.Record;

import io.appium.java_client.android.AndroidDriver;

public class LoginTest extends BaseClass
{
	
	CaroselScreenPage caroselScreen=null;
	ApplicationLoginPage applicationLogin = null;
	SSOLoginPage ssoLogin = null;
	AttendanceDrawerPage attendanceDrawer= null;
	MSpaceHomePage mspaceHomePage=null;
	
	@Record(author = "Archit")
	@Test(dataProvider = "Datadriven", groups = "Sanity")
	public void loginTest(HashMap<String, String> data) throws InterruptedException
	{
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
	}
	
	@DataProvider(name="Datadriven")
	public Object[][] getLoginValues()
	{
		
		return GenerateDynamicTestNG .getTestDataa( "LoginData", "Login");
	}
	
}