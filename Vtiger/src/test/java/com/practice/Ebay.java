package com.practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.houserental.genericutility.FileUtility;
import com.realestate.houseRentalObjectRepository.HomePage;
import com.realestate.houseRentalObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ebay {
	WebDriver driver;
	FileUtility fLib=new FileUtility();
	
	@Test(dataProvider = "object")
	public void test(String url,String username,String password) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		LoginPage lLib=new LoginPage(driver);
		HomePage hLib=new HomePage(driver);
		driver.get(url);
		lLib.getLoginBtn().click();
		lLib.loginToApplication(username, password);
		Thread.sleep(5000);
		hLib.getLogoutLink().click();			
	}	
	@DataProvider
	public Object[][] object() throws IOException{
		String path = fLib.getPropertyFilePath("userpropertypath");
		String url = fLib.getPropertyData(path, "url");
		String username = fLib.getPropertyData(path, "username");
		String password = fLib.getPropertyData(path, "password");
		
		String adminPath = fLib.getPropertyFilePath("adminpropertypath");
		String adminURL = fLib.getPropertyData(adminPath, "url");
		String adminUN = fLib.getPropertyData(adminPath, "username");
		String adminPW = fLib.getPropertyData(adminPath, "password");
		
		
		
		Object[][]obj=new Object[2][3];
		obj[0][0]=url;
		obj[0][1]=username;
		obj[0][2]=password;
		
		obj[1][0]=adminURL;
		obj[1][1]=adminUN;
		obj[1][2]=adminPW;
		
				
		return obj;
	}
}
