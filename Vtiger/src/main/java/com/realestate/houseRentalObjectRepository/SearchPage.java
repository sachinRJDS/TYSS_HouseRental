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

import com.houserental.genericutility.WebDriverActionUtility;

public class SearchPage {
	
	/*declaration*/
	@FindBy(id="keywords")
	private WebElement roomTextField;
	
	@FindBy(id="location")
	private WebElement locationTextField;
	
	@FindBy(xpath="//button[text()='Search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//b[text()='Owner Name: ']/parent::p")
	private List<WebElement> verifyRegisteredRoom;
	
	/*initialisation*/
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getRoomTextField(String room) {
		 roomTextField.sendKeys(room);
	}

	public void getLocationTextField(String location) {
		locationTextField.sendKeys(location);
	}

	public void getSearchBtn() throws Throwable {
		WebDriverActionUtility wLib=new WebDriverActionUtility();
		wLib.waitAndClick(searchBtn);
		
	}
	public void  getVerifyRegisteredRoom(WebDriver driver,String userName) {
		String name="Owner Name: "+userName;
		int count=0;
		String text = driver.findElement(By.xpath("//p[text()='"+userName+"']")).getText();
		Assert.assertEquals(text, name,"user registered home is not verified in searched page and fail");
		Reporter.log("user registered home is verified in searched page and pass");
		
		
		/*for(WebElement we:verifyRegisteredRoom) {
			if(we.getText().equals(name)){
				count++;
				break;
			}
		}*/
		int y = driver.findElement(By.xpath("//p[text()='"+userName+"']")).getLocation().getY();
		JavascriptExecutor j1=(JavascriptExecutor) driver;
		j1.executeScript("window.scrollBy(0,"+y+")");
	/*	if(count==1) {
			System.out.println("user registered home is verified in searched page and pass");
		}else {
			System.out.println("user registered home is not verified in searched page and fail");
		}*/
	}
	public void verifyUpdatedData(WebDriver driver,String accommodation,String name) {
		String expected="Accommodation: "+accommodation;
		String actual = driver.findElement(By.xpath("//p[text()='"+name+"']/../../child::div[3]/p[1]")).getText();
		Assert.assertEquals(actual, expected,"data is not updated in searched page and fail");
		Reporter.log("data is updated in searched page and pass",true);
		
		/*if(actual.equals(expected)) {
			System.out.println("data isupdated in searched page and pass");
		}else {
			System.out.println("data is not updated in searched page and fail");
		}*/
	}
}
