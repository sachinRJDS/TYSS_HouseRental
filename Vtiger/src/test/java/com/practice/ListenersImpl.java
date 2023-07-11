package com.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.houserental.genericutility.BaseClass;

public class ListenersImpl extends BaseClass implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		 String name = result.getName();
		 TakesScreenshot t=(TakesScreenshot) sdriver;
		 File src = t.getScreenshotAs(OutputType.FILE);
		 File dest=new File("./Demoscreenshot/"+name+".png");
		 try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
		}
	}

}
