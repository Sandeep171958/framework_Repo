package Practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	public ExtentReports report;
	@BeforeSuite
	public void configBS() {
		 //spark report config
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suit results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add Env information and createTest
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "Windows-10");
		report.setSystemInfo("Browser", "Chrome-100");
	}
	
	@AfterSuite
	public void configAS() {
		report.flush();
	}
	
	@Test
	 public void createContactTest() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("createContactTest");
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "createContact");
		if ("HDFCd".equals("HDFC")) {
			test.log(Status.PASS, "contact is Created");
			
		}else {
			test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
		}
		driver.close();
		
	}
	
//	@Test
//	 public void createContactWithOrg() {
//		
//		ExtentTest test = report.createTest("createContactWithOrg");
//		
//		test.log(Status.INFO, "login to app");
//		test.log(Status.INFO, "navigate to contact page");
//		test.log(Status.INFO, "createContact");
//		if ("HDFC".equals("HDFC")) {
//			test.log(Status.PASS, "contact is Created");
//			
//		}else {
//			test.log(Status.FAIL, "contact is not created");
//		}
//		
//	}
//	
//	@Test
//	 public void createContactWithPhoneNumber() {
//		
//		ExtentTest test = report.createTest("createContactWithPhoneNumber");
//		
//		test.log(Status.INFO, "login to app");
//		test.log(Status.INFO, "navigate to contact page");
//		test.log(Status.INFO, "createContact");
//		if ("HDFC".equals("HDFC")) {
//			test.log(Status.PASS, "contact is Created");
//			
//		}else {
//			test.log(Status.FAIL, "contact is not created");
//		}
//		
//		
//	}



}
