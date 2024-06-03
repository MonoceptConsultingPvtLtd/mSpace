package com.superapp.baseclass;

import com.superapp.utils.Constants;
import com.superapp.utils.PropertyKey;
import com.superapp.utils.PropertyUtility;

public class AppData 
{
  
	static PropertyUtility p=new PropertyUtility(Constants.TEST_DEVICE_PROPERTY_FILE_PATH);
    public static String platform =p.getPropertyData(PropertyKey.PLATFORMAND);
   
	
}
