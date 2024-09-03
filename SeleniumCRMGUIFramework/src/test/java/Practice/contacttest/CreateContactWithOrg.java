package Practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrg {

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
			Row row = sh.getRow(7);
			String orgname = row.getCell(2).toString() + randomint;
			String ContactLastName = row.getCell(3).getStringCellValue() + randomint;
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
		
		
		
		
		// navigate to contact module
         driver.findElement(By.linkText("Contacts")).click();
		
		//click on create contact button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//enter all the details & create new contact
		driver.findElement(By.name("lastname")).sendKeys(ContactLastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//switch to child window
				Set<String> set = driver.getWindowHandles();
				Iterator<String> it = set.iterator();
				while (it.hasNext()){
					String windowID = it.next();
					driver.switchTo().window(windowID);
					String actualUrl = driver.getCurrentUrl();
					if (actualUrl.contains("module=Accounts")) {
						break;
					}	
				}
				
				driver.findElement(By.name("search_text")).sendKeys(orgname);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
				
				//Switch to parent window
				Set<String> set1=driver.getWindowHandles();
				Iterator<String> it1 = set1.iterator();
				while(it1.hasNext()) {
					String WindowID = it1.next();
					driver.switchTo().window(WindowID);
					String actUrl=driver.getCurrentUrl();
					if (actUrl.contains("Contacts&action")) {
						break; 
					}
					}
				
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//verify Header message Expected result
		 headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if (headerinfo.contains(ContactLastName)) {
			System.out.println(ContactLastName + " is created====PASS");
		}else {
			System.out.println(ContactLastName + " is not created====FAIL");
		}
		
		//verify Header orgname expected result
        String actualorgname = driver.findElement(By.linkText(orgname)).getText();
		System.out.println(actualorgname);
        
		if (actualorgname.equals(orgname)) {
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
