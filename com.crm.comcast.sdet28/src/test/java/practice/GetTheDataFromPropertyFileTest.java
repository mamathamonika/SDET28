package practice;

import java.io.FileInputStream;
import java.util.Properties;

public class GetTheDataFromPropertyFileTest {

	public static void main(String[] args) throws Exception {
		
		// java object representation of physical property file
		FileInputStream fis = new FileInputStream("./src/test/resources/data.properties");
		
		// create object for property class
		Properties property = new Properties();
		
		//load key and values from property object
		property.load(fis);
		
		//fetch the data
		String browser = property.getProperty("browser");
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		
		System.out.println(browser);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		

	}

}
