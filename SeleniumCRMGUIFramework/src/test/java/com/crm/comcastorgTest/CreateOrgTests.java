package com.crm.comcastorgTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.generic.baseUtility.BaseClass1;

public class CreateOrgTests extends BaseClass1 {
	
	@Test
	public void CreateOrgTest() {
		System.out.println("execute CreateOrgTest & verify");
	}
	@Test
	public void createOrgwithIndustry() {
		System.out.println("execute createOrgwithIndustry & verify");
	}
	
}
