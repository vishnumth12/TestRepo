package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		
		//Step 1: Register Driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Step 2: Connection for database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "vishnumth12");
		
		//Step 3: Create statement
		Statement state = con.createStatement();
		String query = "select * from thetable";
		
		//Step 4: Execute Query
		ResultSet result = state.executeQuery(query);
		
		while(result.next()) {
			System.out.println(result.getString(1)+" "+ result.getString(2)+" "+ result.getString(3));
		}
		
		//Step 5: Close Connection
		con.close();
	}
}
