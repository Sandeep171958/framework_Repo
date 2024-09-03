package Practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest1 {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		

		FileInputStream fis=new FileInputStream("C:\\Users\\LENOVO\\Desktop\\commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		String Browser = prop.getProperty("browser");
		String Url = prop.getProperty("url");
		String Username = prop.getProperty("username");
		String Password = prop.getProperty("password");
		 
		 
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
		 
		  //Scanner sc=new Scanner(System.in);
		//String browser = sc.next();
		  
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
		
		//verify Header message Expected result
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if (headerinfo.contains(orgname)) {
			System.out.println(orgname + " is created====PASS");
		}else {
			System.out.println(orgname + " is not created====FAIL");
		}
		//verify orgname info Expected result
		String actualorgnameinfo = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		if (actualorgnameinfo.equals(orgname)) {
			System.out.println(orgname + " is created====pass");
		}
		else {
			System.out.println(orgname + " is not created====fail");
		}
		//logout application
		Thread.sleep(2000);
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}




	
	}


