package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteSelectQueryUsingJDBCTest {

	public static void main(String[] args) throws Throwable {
		
		//Register driver
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//establish connection 
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo","root","root");
		
		// create statement
		
		Statement statement = connection.createStatement();

		// execute query 
		
		ResultSet result = statement.executeQuery("select *  from student ;");
		
		// fetch the data from query
		
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
			
		}
		
		// close database
		
		connection.close();

	}

}
