package com.realestate.houseRentalObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import junit.framework.Assert;

public class UserRegistrationPage {

	@FindBy(id="fullname")
	private WebElement fullnameTextField;
	@FindBy(id="username")
	private WebElement usernameTextField;
	@FindBy(id="email")
	private WebElement emailTextField;
	@FindBy(id="mobile")
	private WebElement mobileTextField;
	@FindBy(id="password")
	private WebElement passwordTextField;
	@FindBy(id="c_password")
	private WebElement confirmPasswordTextField;
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitBtn;


	/*initialization*/
	public UserRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*utilization*/

	public WebElement getFullnameTextField() {
		return fullnameTextField;
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getMobileTextField() {
		return mobileTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}	

	/*business layer*/
	public void getFullnameUsernameEmail(String fullname,String username,String email) {
		fullnameTextField.sendKeys(fullname);
		usernameTextField.sendKeys(username);
		emailTextField.sendKeys(email);
	}
	public void getMobilenoPasswordConfirmPass(String mobile,String pass,String confirmPass) {
		mobileTextField.sendKeys(mobile);
		passwordTextField.sendKeys(pass);
		confirmPasswordTextField.sendKeys(confirmPass);
	}
	public void getSubmitBtn(WebDriver driver) throws InterruptedException {
		submitBtn.click();
		//Thread.sleep(2000);
		String excpected="Registration successfull. Now you can login";
		String actual = driver.findElement(By.xpath("//div[text()='Registration successfull. Now you can login']")).getText();
		/*	Assert.assertEquals(actual, excpected,"user id is already exist");
		Reporter.log("Registration successfull. Now you can login");*/

		if(actual.equals(excpected)) {
			System.out.println("Registration successfull. Now you can login");
		}else {
			System.out.println("user id is already exist");
		}
	}

}

