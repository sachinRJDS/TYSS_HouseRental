package com.realestate.houseRentalObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	/* declartion*/
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginBtn;
	
	@FindBy(id="exampleInputEmail1")
	private WebElement usernameTextField;
	
	@FindBy(id="exampleInputPassword1")
	private WebElement passwordTextField;
	
	@FindBy(name="login")
	private WebElement submitBtn;
	
	@FindBy(xpath="//a[text()='Search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerTab;

	/*initialisation*/
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*utilisation*/
	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	/*business libraries*/
	public void loginToApplication(String username,String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		submitBtn.click();
	}
	public WebElement getRegisterTab() {
		return registerTab;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	
}
