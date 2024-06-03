package com.superapp.utils;

import com.genericutility.JavaUtility;

public class Constants 
{

	static JavaUtility j=new JavaUtility();
	static String date=j.getDateAndTime();
	
	public static final String TEST_APPLICATION_PROPERTY_FILE_PATH="./src/test/resources/PropertyFile/AppDetails.properties"; 
	public static final String TEST_DEVICE_PROPERTY_FILE_PATH="./src/test/resources/PropertyFile/DeviceDetails.properties"; 
	public static final String TEST_GENERIC_PROPERTY_FILE_PATH="./src/test/resources/PropertyFile/Generic.properties"; 
	public static final String TEST_EXCEL_FILE_PATH="./src/test/resources/ExcelFile/ExcelData.xlsx";
	public static final String TEST_SCREENSHOT_FILE_PATH="./src/test/resources/Screenshot/picture_"+date+".png";
	public static final String TEST_SERVICE_LOGS_FILE_PATH="./src/test/resources/ServiceLogs/Logs.txt";
	public static final String EXTENT_REPORT_PATH="./src/test/resources/Reports/Reports_"+date;
	
}
