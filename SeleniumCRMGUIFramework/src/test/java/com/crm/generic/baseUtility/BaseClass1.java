package com.crm.generic.baseUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass1 {

	
	@BeforeSuite
	public void configBS(){
		System.out.println("====connect Dto DB , Report config====");
	}
	
	@BeforeClass
	public void configBeforeClass() {
		System.out.println("======launch the browser======");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println(" ======login====");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("=======logout=======");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("=====close the browser====");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("====close Db, Report backup=======");
	}

}
