package com.superapp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;




public class GenerateDynamicTestNG 
{

	Workbook wb;

	static String path=Constants.TEST_EXCEL_FILE_PATH;
	/************** To the Data for TestCase ******************/
	public static synchronized HashMap<String, String> getTestData( String sheetName, String testName) 
	{
		HashMap<String, String> dataTable = null;

		try 
		{
			ExcelUtility readdata = new ExcelUtility(path);


			// Find Start Row of TestCase
			int startRowNum = 0;
			while (!readdata.getCellData(sheetName, 0, startRowNum).equalsIgnoreCase(testName))
			{
				startRowNum++;
			}

			int startTestColumn = startRowNum + 1;
			int startTestRow = startRowNum + 2;

			// Find Number of Rows of TestCase
			int rows = 0;
			while (!readdata.getCellData(sheetName, 0, startTestRow + rows).equals("")) 
			{
				rows++;
			}

			// Find Number of Columns in Test
			int colmns = 0;
			while (!readdata.getCellData(sheetName, colmns, startTestColumn).equals("")) 
			{
				colmns++;
			}

			// Define Two Object Array
			//dataSet = new Object[rows][1];

			int dataRowNumber = 0;
			for (int rowNumber = startTestRow; rowNumber <= startTestColumn + rows; rowNumber++) 
			{
				dataTable = new HashMap<>();
				for (int colNumber = 0; colNumber < colmns; colNumber++) 
				{
					String key = readdata.getCellData(sheetName, colNumber, startTestColumn);
					String value = readdata.getCellData(sheetName, colNumber, rowNumber);
					dataTable.put(key, value);
				}
				//dataSet[dataRowNumber][0] = dataTable;
				//dataRowNumber++;
			}
		} 
		catch (Exception e) 
		{

			e.printStackTrace();
		}
		//return dataSet;
		return dataTable;
	}

	/************** To the Data for TestCase ******************/
	public static synchronized Object[][] getTestDataa( String sheetName, String testName) 
	{
		Object[][] dataSet = null;
		
		try 
		{
			ExcelUtility readdata = new ExcelUtility(path);
				// Find Start Row of TestCase
			int startRowNum = 0;
			while (!readdata.getCellData(sheetName, 0, startRowNum).equalsIgnoreCase(testName)) 
			{
				startRowNum++;
			}

			int startTestColumn = startRowNum + 1;
			int startTestRow = startRowNum + 2;

			// Find Number of Rows of TestCase
			int rows = 0;
			while (!readdata.getCellData(sheetName, 0, startTestRow + rows).equals("")) 
			{
				rows++;
			}

			// Find Number of Columns in Test
			int colmns = 0;
			while (!readdata.getCellData(sheetName, colmns, startTestColumn).equals("")) 
			{
				colmns++;
			}

			// Define Two Object Array
			dataSet = new Object[rows][1];
			HashMap<String, String> dataTable = null;
			int dataRowNumber = 0;
			for (int rowNumber = startTestRow; rowNumber <= startTestColumn + rows; rowNumber++) 
			{
				dataTable = new HashMap<>();
				for (int colNumber = 0; colNumber < colmns; colNumber++) 
				{
					String key = readdata.getCellData(sheetName, colNumber, startTestColumn);
					String value = readdata.getCellData(sheetName, colNumber, rowNumber);
					dataTable.put(key, value);
				}
				dataSet[dataRowNumber][0] = dataTable;
				dataRowNumber++;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return dataSet;
	}


	public static void generateTestNGXMLFromExcel() {

	    try {
	        FileInputStream fis = new FileInputStream(new File(path));
	        Workbook workbook = WorkbookFactory.create(fis);

	        // Assuming data is on the first sheet
	        Sheet sheet = workbook.getSheet("Platform");

	        // Create a new TestNG object
	        TestNG testNG = new TestNG();

	        // Create a new XML suite
	        XmlSuite suite = new XmlSuite();
	        suite.setName("Dynamic Test Suite");

	        // Add listeners to the suite
	        suite.addListener("com.superapp.report.ExtentReportListener");

	        // Loop through the rows in the Excel sheet
	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);

	            // Assuming column index 1 contains the class name and column index 2 contains the execution status
	            Cell classNameCell = row.getCell(0);
	            Cell executionStatusCell = row.getCell(3);

	            String className = classNameCell.getStringCellValue();
	           
	            String executionStatus = executionStatusCell.getStringCellValue();
	           

	            // If the execution status is "yes", add the test class to the XML test
	            if (executionStatus.equalsIgnoreCase("Y")) {
	                XmlTest test = new XmlTest(suite);
	                test.setName("com.superapp.tests."+className);

	                // Add the test class to the XML test
	                XmlClass xmlClass = new XmlClass("com.superapp.tests."+className);
	                test.getXmlClasses().add(xmlClass);
	            }
	        }

	        // Add the XML suite to the TestNG object
	        testNG.setXmlSuites(Collections.singletonList(suite));

	        // Set the output directory for the generated XML file
	        String outputDirectory = System.getProperty("user.dir") + "/Dynamic";
	        testNG.setOutputDirectory(outputDirectory);

	        // Create the output directory if it doesn't exist
	        File directory = new File(outputDirectory);
	        if (!directory.exists()) {
	            directory.mkdirs();
	        }

	        // Generate the TestNG XML file
	        String xmlFilePath = outputDirectory + "/testng.xml";
	        String xmlString = suite.toXml();
	        try (FileWriter writer = new FileWriter(xmlFilePath)) {
	            writer.write(xmlString);
	        }

	        System.out.println("TestNG XML generated successfully.");

	        // Run the TestNG tests
	        testNG.run();

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}




	public static HashMap<String, String> getSheetName() 
	{
		HashMap<String, String> d = null;
		Workbook workbook = null;

		
		try 
		{
			File f=new File(path);
			FileInputStream fis = new FileInputStream(f);
			workbook=WorkbookFactory.create(fis);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		Sheet sheet=workbook.getSheetAt(0);
		int cnum=sheet.getRow(0).getLastCellNum();
		int rnum=sheet.getLastRowNum();
		for (int i=1;i<=rnum;i++) 
		{
			String status=sheet.getRow(i).getCell(3).toString();
			if(status.equalsIgnoreCase("y")) 
			{
				String platform= sheet.getRow(i).getCell(1).toString();
				String deviceName= sheet.getRow(i).getCell(2).toString();

				d = getTestData(platform, deviceName);
			}


		}
		return d;
	}
}
