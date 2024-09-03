package com.crm.comcast.contactTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.crm.generic.baseUtility.BaseClass1;

public class CreateContactTests extends BaseClass1 {

	@Test
	public void CreateContact() {
		System.out.println("execute CreateContact & verify");
	}
	@Test
	public void createContactWithDate() {
		System.out.println("execute createContactWithDate & verify");
	}
	
}
