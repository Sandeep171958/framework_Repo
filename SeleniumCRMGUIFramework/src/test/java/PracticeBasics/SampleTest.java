package PracticeBasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleTest {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root" );
		 System.out.println("===========done=========");
		 
		Statement stat=conn.createStatement();
		
		ResultSet resultset=stat.executeQuery("select * from leads");
		while (resultset.next()) {
			System.out.println(resultset.getString(1) + "\t"+resultset.getString(2));
			
		}
		conn.close();
	}
	}
