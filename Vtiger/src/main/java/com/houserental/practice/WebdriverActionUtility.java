package com.houserental.practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.houserental.genericutility.FileUtility;

public class WebdriverActionUtility {
	FileUtility fLib=new FileUtility();
	int time;
	
public	WebdriverActionUtility(WebDriver driver) throws IOException{
		String path = fLib.getPropertyFilePath("userpropertypath");
		String timeout = fLib.getPropertyData(path, "timeout");
	    time = Integer.parseInt(timeout);
		
	}
	
	public void waitForElementVisisble(WebDriver driver) throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public void waitForPage(WebDriver driver,String pageURL) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.urlContains(pageURL));
	}
	public void waitForElement(WebDriver driver,WebElement we) {
		
		
	}

}