package com.practice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImp implements IRetryAnalyzer{
	
	 int count=0;
	 int retryCount=3;
	@Override
	public boolean retry(ITestResult result) {
	 if(count<retryCount) {
		 count++;
		return true;
	 }
	 return false;
	}

}
