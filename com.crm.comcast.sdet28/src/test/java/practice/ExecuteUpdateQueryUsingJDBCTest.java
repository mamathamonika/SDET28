package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateQueryUsingJDBCTest {

	public static void main(String[] args) throws Throwable {
		
		// register driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Establish connection		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");
		
		//create statement		
		Statement statement = connection.createStatement();
		
		//modify data in database		
		int result = statement.executeUpdate("insert into student values (103,'CAN','SOCIAL');");
		
		//verification data added into database
		if(result==1)
		{
			System.out.println("dad added to database");
		}
		
		else		
		{
			System.out.println("dad added to database");
		}

		//close connection
		connection.close();
	}

}
