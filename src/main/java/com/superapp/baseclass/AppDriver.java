package com.superapp.baseclass;

import org.openqa.selenium.WebDriver;

public class AppDriver 
{

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static AppDriver instance = null;

    private AppDriver()
    {

    }

    public WebDriver getDriver()
    {
        return driver.get();
    }
    
    
    public static void setDriver(WebDriver Driver)
    {
        driver.set(Driver);
        System.out.println("Driver is set");
    }

	
}
