package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadDataFromMyDatabase {

	@org.testng.annotations.Test
	public void readFromDB() throws SQLException, InterruptedException {
		
	Driver driver = new Driver();
	
	DriverManager.registerDriver(driver);
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "vishnumth12");
	
	Thread.sleep(4000);
	
	String s = "Select * from thetable;";
	
	Statement st = con.createStatement();
	
	ResultSet r = st.executeQuery(s);
	
		
	if(r.next()) {
		
		System.out.println(r.getString("Name"));
		
	}
	
	con.close();
	
	}
	
}
