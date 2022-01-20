package com.crm.comcast.GenericUtility;

	import java.io.FileInputStream;
	import java.util.Properties;

	/**
	 * 
	 * @author Mamatha
	 *
	 */

	public class FileUtility {
		
	/**
	 * this method fetch the data from property file based on key passed
	 * @param key
	 * @return
	 * @throws Throwable 
	 */

		public String getPropertyFileData(String key) throws Throwable
		{
		FileInputStream fis = new FileInputStream(IpathConstants.PROPERTY_FILE_PATH);
		Properties property = new Properties();
		property.load(fis);
		return property.getProperty(key);
		
	}
}


