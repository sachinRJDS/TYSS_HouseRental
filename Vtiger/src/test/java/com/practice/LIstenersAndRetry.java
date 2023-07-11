package com.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.houserental.genericutility.BaseClass;

public class LIstenersAndRetry extends BaseClass {
	@Test(retryAnalyzer = com.practice.RetryImp.class)
	public void demoTest() {
		System.out.println("hi******");
		Assert.fail();
	}
	//(retryAnalyzer = com.practice.RetryImp.class)
	//@Listeners(com.practice.ListenersImpl.class)
}
