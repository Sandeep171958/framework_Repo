package Practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleUnitTestCheckProjectInBackend {
	
	@Test
	public void projectCheckTest() throws SQLException {
		String expedtedprojectname = "ss";
		
		boolean flag = false;
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root" );
		 System.out.println("===========done=========");
		 
		Statement stat=conn.createStatement();
		
		ResultSet resultset=stat.executeQuery("select * from leads");
		while (resultset.next()) {
			String actualprojectname = resultset.getString(3);
			if (expedtedprojectname.equals(actualprojectname)) {
				flag=true;
			System.out.println(expedtedprojectname + " is available");
			
		}
		}
			if (flag==false) {
				System.out.println(expedtedprojectname+ " is not available");
				//Assert.fail();
			}
		conn.close();
	}
		

}

