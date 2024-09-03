package Practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class CreateContactWithSupportDateTest {

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
			Sheet sh = wb.getSheet("contact");
			Row row = sh.getRow(4);
			String lastname = row.getCell(2).toString() + randomint;
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
		
		//navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on create contact button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//enter all the details & create new contact
          Date dateobj=new Date();
		
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sim.format(dateobj);
		
		Calendar ca1=sim.getCalendar();
		ca1.add(Calendar.DAY_OF_MONTH,30);
		String dateRequires = sim.format(ca1.getTime());
		
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(actDate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(dateRequires);
		
		//Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//verify StartDate&EndDate Expected result
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		
		if (actStartDate.contains(actDate)) {
			System.out.println(actDate + " is created====PASS");
		}else {
			System.out.println(actDate + " is not created====FAIL");
		}
		
		//verify EndDate
        String actEnddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		
		if (actEnddate.contains(dateRequires)) {
			System.out.println(dateRequires + " is created====PASS");
		}else {
			System.out.println(dateRequires + " is not created====FAIL");
		}
		
		//logout application
		Thread.sleep(2000);
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		


	}

}
