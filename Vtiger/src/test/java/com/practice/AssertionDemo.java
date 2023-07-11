package com.practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {
	@Test
	public void assertTest() {
		int a=10;
		int b=20;
		Assert.assertTrue(a<b, "fail");
		Reporter.log("pass");
	}

}
