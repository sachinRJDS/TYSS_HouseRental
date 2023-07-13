package com.houserental.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimentation extends BaseClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
      test = report.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getName());
		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String name = result.getName();
		TakesScreenshot t=(TakesScreenshot) sdriver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+name+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
		
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.PASS, result.getName());
		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("ExtentReport/Report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ExtentReport");
		spark.config().setReportName("Sachin");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows10");
		report.setSystemInfo("execuited by", "sachin");
		report.setSystemInfo("reviewed by", "sanjay");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
