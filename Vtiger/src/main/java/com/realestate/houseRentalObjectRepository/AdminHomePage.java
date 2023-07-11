package com.realestate.houseRentalObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	/*declaration*/
	@FindBy(linkText="Home")
	private WebElement homeTab;

	@FindBy(linkText="Register")
	private WebElement registerTab;

	@FindBy(linkText="Details/Update")
	private WebElement detailsUpdateTab;

	@FindBy(xpath="//b[text()='Rooms for Rent: ']/child::span")
	private WebElement roomsForRentCount;

	@FindBy(xpath="//a[text()='Send SMS']")
	private WebElement sendSMSTab;

	@FindBy(xpath="//b[text()='Rooms for Rent: ']")
	private WebElement roomsForRentLink;


	@FindBy(xpath="//a[text()='Complaint List']")
	private WebElement complaintListTab;



	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;

	@FindBy(xpath="//b[text()='Owner Name: ']/parent::p")
	private List<WebElement> verifyRegisteredRoom;
	
	@FindBy(xpath="//b[text()='Registered Users: ']")
	private WebElement registeredUserLink;

	/*initialisation*/
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*utilisation*/
	public WebElement getHomeTab() {
		return homeTab;
	}

	public WebElement getRegisterTab() {
		return registerTab;
	}

	public void getDetailsUpdateTab(WebDriver driver) {
		JavascriptExecutor j1=(JavascriptExecutor) driver;
		j1.executeScript("window.scrollTo(0,0)");

		detailsUpdateTab.click();
	}

	public void getRoomsForRentCount() {
		String text = roomsForRentCount.getText();
		System.out.println("Rooms for rent count:"+text);
	}
	public WebElement getRoomsForRentLink() {
		return roomsForRentLink;
	}
	public WebElement getSendSMSTab() {
		return sendSMSTab;
	}

	public WebElement getComplaintListTab() {
		return complaintListTab;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	public WebElement getRegisteredUserLink() {
		return registeredUserLink;
	}
	
	

}
