package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest {
	
	@Test
	public void HomepageTest(Method mtd) {

		System.out.println(mtd.getName() + "Test Starts");
		String expectedPage = "Home..";

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		//Hard Assert
		Assert.assertEquals(actTitle, expectedPage);
		driver.close();

		System.out.println(mtd.getName() + " Test Ends");
	}
	
	@Test
	public void verigyLogoinHomePageTest(Method mtd) {
		
		System.out.println(mtd.getName() + "Test Starts");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
	  boolean status = driver.findElement(By.xpath("//img[@src='test/logo/vtiger-crm-logo.gif']")).isEnabled();
		//Hard Assert
	 Assert.assertTrue(status);
	 driver.close();
	  System.out.println(mtd.getName() + "Test ends");
	}

}
