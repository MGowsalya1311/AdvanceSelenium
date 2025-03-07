package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ToFetchDataFromDataBase {

	public static void main(String[] args) throws Throwable {


		//step 1: Register driver
		Driver driverRef = new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		//step 2: Get connection to DataBase
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedata", "root", "root");
		
		//step 3: Create SQL statement
		Statement state = conn.createStatement();
		String Query = "select * from employee";
		
		//step 4: execute Statement/query
		ResultSet result = state.executeQuery(Query);
			
		while(result.next()) {
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		conn.close();
	
	
	}

}
