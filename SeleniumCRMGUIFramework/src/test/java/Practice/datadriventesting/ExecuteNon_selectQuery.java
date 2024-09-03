package Practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExecuteNon_selectQuery {

	
		public static void main(String[] args) throws SQLException {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root" );
			 System.out.println("===========done=========");
			 
			Statement stat=conn.createStatement();
			
			int result = stat.executeUpdate("insert into leads values('minit','singh','tp')");
			System.out.println(result);
			
			
			conn.close();
		}
}
		
