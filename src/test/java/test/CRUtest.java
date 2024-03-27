package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CRUtest {

	public static void main(String[] args) throws SQLException {
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "vishnumth12");
		
		Statement state = con.createStatement();
		String query = "Create table thetable2 (Company varchar(20), Location varchar(20), Employees int(5))";
		String query2 = "Insert into thetable2 values('Epitome', 'Bengaluru', 200) ('Snzel', 'Hyderabad', 300) ('Maxcen', 'Kochi', 100)";
		
		try {
		int result = state.executeUpdate(query);
		
		}
		catch(SQLSyntaxErrorException sqlsee) {
		int result2 = state.executeUpdate(query2);
		}
		con.close();
	}

}
