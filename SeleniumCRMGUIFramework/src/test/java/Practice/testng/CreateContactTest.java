 package Practice.testng;

import org.testng.annotations.Test;

public class CreateContactTest {
	
	@Test(invocationCount=5)
	public void createContactTest() {
		System.out.println("execute createContactTest");
	}
	@Test
	public void createContactWithMobileNumber() {
		System.out.println("execute createContactWithMobileNumber");

}
}
