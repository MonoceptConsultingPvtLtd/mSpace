package com.genericutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import io.appium.java_client.AppiumDriver;

public class JavaUtility 
{
	
	SimpleDateFormat sdf;
	
	/**
	 * This generic method will generate random number
	 */
	public int getRandomNumber(int boundary) 
	{
		return new Random().nextInt(boundary);
	}
	
	
	/**
	 * This generic method will return current date 
	 */
	public String getCurrentDate() 
	{
		sdf=new SimpleDateFormat();
		Calendar cal=Calendar.getInstance();
		String date=sdf.format(cal.getTime());
		return date;

	}
	
	/**
	 * This method will give current date and time
	 * @return
	 */
	public String getDateAndTime() 
	{
		String date=new SimpleDateFormat("YYYY-MM-dd hh-mm-ss").format(new Date());
		return date;
    }
	
	
}
