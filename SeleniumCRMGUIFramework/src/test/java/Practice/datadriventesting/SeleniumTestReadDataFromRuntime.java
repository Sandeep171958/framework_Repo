package Practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRuntime {
		
		@Test
		public void SeleniumTest() throws EncryptedDocumentException, IOException {

			String browser = System.getProperty("browser");
			String Url = System.getProperty("url");
			String Username = System.getProperty("username");
			String password =System.getProperty("password");
			
			 
			 
			 
			/*
			 * //read test script data from excel file FileInputStream fis1 =new
			 * FileInputStream("C:\\Users\\LENOVO\\Desktop\\testScriptdata.xlsx"); Workbook
			 * wb=WorkbookFactory.create(fis1); Sheet sh = wb.getSheet("org"); Row row =
			 * sh.getRow(1); String orgname = row.getCell(2).toString() + randomint;
			 * System.out.println(orgname); wb.close();
			 */
				
			 WebDriver driver=null;
			 
			  //String browser = sc.next();
			  
			  if (browser.equals("Chrome")) {
				driver=new ChromeDriver();
			  }else if (browser.equals("edge")) {
				driver=new EdgeDriver();	
				}
			  else {
				driver=new ChromeDriver();
			}
			driver=new ChromeDriver();
			//login to app
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("http://localhost:8888/");
			
		
		

	}

}
