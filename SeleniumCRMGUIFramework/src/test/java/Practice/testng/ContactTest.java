package Practice.testng;

import org.testng.annotations.Test;

public class ContactTest {
	@Test
	public void createContactTest() {
		System.out.println("execute createContact---->HDFC");
	}
	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest() {
		
		System.out.println("execute modifyContactTest-->HDFC=>ICICI_1");
	}
	@Test(dependsOnMethods= "modifyContactTest")
	public void deleteContactTest() {
	
		System.out.println("execute deleteContactTest UPI");
	}

}
