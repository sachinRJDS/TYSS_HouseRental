package com.realestate.houseRentalObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;



public class ComplaintPage {
	
	@FindBy(id="name")
	private WebElement nameTextField;
	
	@FindBy(id="cmp")
	private WebElement complaintTextField;
	@FindBy(name="register")
	private WebElement submitBtn;
	
	@FindBy(xpath="//div[text()='Sent Successfully']")
	private WebElement sentSuccessfullMessage;
	
	public ComplaintPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getNameTextField() {
		return nameTextField;
	}

	public WebElement getComplaintTextField() {
		return complaintTextField;
	}
	
	
	public void getNameAndComplaint(WebDriver driver,String name,String complaint) {
		nameTextField.sendKeys(name);
		complaintTextField.sendKeys(complaint);
		submitBtn.click();
		String expected="Sent Successfully";
		boolean displayed = sentSuccessfullMessage.isDisplayed();
		Assert.assertTrue(displayed,"complaint not sent");
		Reporter.log("complaint sent successfully");
		
		
		/*if(displayed) {
			System.out.println("complaint sent successfully");
		}else {
			System.out.println("complaint not sent");
		}*/
		
		
	}
	
}
