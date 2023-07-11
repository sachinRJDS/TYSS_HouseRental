package com.practice;
import org.testng.Reporter;
import org.testng.annotations.Test;
public class TestNGPractice {
	
	@Test(priority = 1)
	public void createCustomerTest() {
		Reporter.log("createCustomer",true);
	}
	@Test
	public void modifyCustomerTest() {
		Reporter.log("modifyCustomer",true);
	}
	@Test(priority = 3,dependsOnMethods = "createCustomerTest")
	public void deleteCustomerTest() {
		Reporter.log("deleteCustomer",true);
	}
	@Test
	public void updateCustomerTest() {
		Reporter.log("updateCustomer",true);
	}

}
