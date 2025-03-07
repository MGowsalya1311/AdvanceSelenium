package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ToInsertDataIntoDataBase {

	public static void main(String[] args) throws Throwable {

		//step 1: Register driver
		Driver driverRef = new Driver();
		
		DriverManager.registerDriver(driverRef);
		
		//step 2: Get connection to DataBase
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedata", "root", "root");
		
		//step 3: Create SQL statement
		Statement state = conn.createStatement();
		String Query1 = "insert into employee values(2,'gowsalya','mahi','Bangalore')";
		// For inserting multiple values
		//String Query1 = "insert into employee values(2,'gowsalya','mahi','Bangalore'),(3,'Nish','mahi','Blore')";
			int res = state.executeUpdate(Query1);	
		//System.out.println(res);
		//	if(res!=1) {
		if(res==1) {
			System.out.println("Row inserted successfully");
		}
		else {
			System.out.println("Row not inserted");
		}
	}

}
