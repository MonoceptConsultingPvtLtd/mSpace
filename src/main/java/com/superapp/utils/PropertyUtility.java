package com.superapp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility 
{

		FileInputStream fis=null;
		FileOutputStream fos=null;
		Properties p=null;
		
		
		public PropertyUtility(String path) 
		{
			initialize(path);		
		}
		
		public void initialize(String path) 
		{

			try 
			{
				fis=new FileInputStream(path);
				p=new Properties();
				p.load(fis);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		
		public void set(String path) 
		{
			try 
			{
				fos=new FileOutputStream(path,true);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		
		
	/**
	 * This method is used to fetch the data from property files
	 */
		public String getPropertyData(PropertyKey key) 
		{
			String k=key.name().toLowerCase();
			String data=p.getProperty(k,"").trim();
			return data;
		}
		
		
		
		/**
		 * This method is used to write the data to property files
		 */
		public void setPropertyData(String key,String value) 
		{
			p.setProperty(key, value);
			try 
			{
				p.store(fos, "New Data Added");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}

		}
	
	
}
