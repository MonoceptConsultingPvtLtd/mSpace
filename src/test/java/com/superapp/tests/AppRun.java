package com.superapp.tests;

import org.testng.annotations.Test;

import com.superapp.utils.GenerateDynamicTestNG;

public class AppRun 
{
	@Test
	public void runApp() 
	{
		GenerateDynamicTestNG.generateTestNGXMLFromExcel();
	}

}
