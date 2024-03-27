package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDatabase {

	public static void main(String[] args) throws SQLException {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "vishnumth12");
		
		Statement state = con.createStatement();
		String query = "Insert into thetable values ('Zenna', 'API', '1 month')";
		
		int result = state.executeUpdate(query);
		
		System.out.println(result);
		
		con.close();
	}

}
