package practice.hometest;

import java.lang.reflect.Method;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class HomePageSampleTest {
	@Test
	public void HomepageTest(Method mtd) {
 
		Reporter.log(mtd.getName() + "Test Starts");
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		Reporter.log(mtd.getName() + " Test Ends");
	}

	@Test
	public void verigyLogoinHomePageTest(Method mtd) {

		Reporter.log(mtd.getName() + "Test Starts");

		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		Reporter.log("step-3",true);
		Reporter.log("step-4",true);
		Reporter.log(mtd.getName() + "Test ends");
	}

}
