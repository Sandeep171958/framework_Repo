package Practice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateOrgtest {

	@Test
	
	public void createOrgTest(XmlTest test) throws IOException, InterruptedException, ParseException {
		//read common data from xml file  
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(new FileReader("C:\\Users\\LENOVO\\Desktop\\AppCommonData.json"));
		
		JSONObject map= (JSONObject)obj;
		

		String Browser = test.getParameter("browser");
		String Url = test.getParameter("url");
		String Username =test.getParameter("username");
		String Password = test.getParameter("password");
		 
		 
		 //generate the random number
		 Random random = new Random();
		int randomint = random.nextInt(1000);
		 
		 //read test script data from excel file
		 FileInputStream fis1 =new FileInputStream("C:\\Users\\LENOVO\\Desktop\\testScriptdata.xlsx");
			Workbook wb=WorkbookFactory.create(fis1);
			Sheet sh = wb.getSheet("org");
			Row row = sh.getRow(1);
			String orgname = row.getCell(2).toString() + randomint;
			//System.out.println(orgname);
			wb.close();
			
		 WebDriver driver=null;
		 
		  Scanner sc=new Scanner(System.in);
		String browser = sc.next();
		  
		  if (Browser.equals("Chrome")) {
			driver=new ChromeDriver();
		  }else if (Browser.equals("edge")) {
			driver=new EdgeDriver();	
			}
		  else {
			driver=new ChromeDriver();
		}
		driver=new ChromeDriver();
		//login to app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(Url);
		
		driver.findElement(By.name("user_name")).sendKeys(Username);
		driver.findElement(By.name("user_password")).sendKeys(Password);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//enter all the details & create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//logout application
		Thread.sleep(2000);
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}

}
