package com.realestate.houseRentalObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;



public class AdminApartmentListPage {
	String name;
	/*declaration*/	
	@FindBy(xpath="//b[text()='Owner Name: ']/parent::p")
	private List<WebElement> verifyRegisteredRoom;


	/*initialisation*/
  public AdminApartmentListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
  
  /*utilisation*/
  public void  getVerifyRegisteredRoomInDetails(WebDriver driver,String userName) {
		String name="Owner Name: "+userName;
		String text = driver.findElement(By.xpath("//p[text()='"+userName+"']")).getText();
		Assert.assertEquals(text, name,"user registered home is not verified in admin details page and fail");
		Reporter.log("user registered home is verified in admin details page and pass",true);
		/*if(text.equals(name)) {
			System.out.println("user registered home is verified in admin details page and pass");
		}else {
			System.out.println("user registered home is not verified in admin details page and fail");
		}
		/*int count=0;
		for(WebElement we:verifyRegisteredRoom) {
			if(we.getText().equals(name)){
				count++;
				break;
			}
		}
		int y = driver.findElement(By.xpath("//p[text()='"+userName+"']")).getLocation().getY();
		JavascriptExecutor j1=(JavascriptExecutor) driver;
		j1.executeScript("window.scrollBy(0,"+y+")");
		if(count==1) {
			System.out.println("user registered home is verified in admin details page and pass");
		}else {
			System.out.println("user registered home is not verified in admin details page and fail");
		}*/

	}
  
  public void  getVerifyRegisteredRoomInHome(WebDriver driver,String userName) {
		String name="Owner Name: "+userName;
		String text = driver.findElement(By.xpath("//p[text()='"+userName+"']")).getText();
		Assert.assertEquals(text, name,"user registered home is not verified in admin home page and fail");
		Reporter.log("user registered home is verified in admin home page and pass",true);
		/*if(text.equals(name)) {
			System.out.println("user registered home is verified in admin home page and pass");
		}else {
			System.out.println("user registered home is not verified in admin home page and fail");
		}
		
		int count=0;
		for(WebElement we:verifyRegisteredRoom) {
			if(we.getText().equals(name)){
				count++;
				break;
			}
		}
		int y = driver.findElement(By.xpath("//p[text()='"+userName+"']")).getLocation().getY();
		JavascriptExecutor j1=(JavascriptExecutor) driver;
		j1.executeScript("window.scrollBy(0,"+y+")");
		if(count==1) {
			System.out.println("user registered home is verified in admin home page and pass");
		}else {
			System.out.println("user registered home is not verified in admin home page and fail");
		}*/

	}
  
  public void getEditButton(WebDriver driver,String name) {
	  driver.findElement(By.xpath("//p[text()='"+name+"']/../../../a[text()='Edit']")).click();
  }
  public void verifyUpdatedData(WebDriver driver,String accommodation,String name) {
		String expected="Accommodation: "+accommodation;
		String actual = driver.findElement(By.xpath("//p[text()='"+name+"']/../../child::div[3]/p[1]")).getText();
		Assert.assertEquals(actual, expected,"data is not updated in admin apartment lis page and fail");
		Reporter.log("data is updated in admin apartment list page and pass",true);
	/*	if(actual.equals(expected)) {
			System.out.println("data is updated in admin apartment list page and pass");
		}else {
			System.out.println("data is not updated in admin apartment lis page and fail");
		}*/
	}


}
