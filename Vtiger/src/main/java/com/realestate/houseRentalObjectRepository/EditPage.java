package com.realestate.houseRentalObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage {
	/*declaration*/
	@FindBy(id="accommodation")
	private WebElement accommodationTextField;	
	@FindBy(id="description")
	private WebElement descriptionTextField;
	@FindBy(id="other")
	private WebElement otherTextField;
	@FindBy(id="landmark")
	private WebElement landmarkTextField;
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement submitBtn;
	
	/*initialisation*/
	public EditPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/*utilisation*/
	public WebElement getAccommodationTextField() {
		return accommodationTextField;
	}

	public WebElement getDescriptionTextField() {
		return descriptionTextField;
	}

	public WebElement getOtherTextField() {
		return otherTextField;
	}

	public WebElement getLandmarkTextField() {
		return landmarkTextField;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void setAccommodationDescriptionOtherLandmark(String accommodation,String description,String other,String landmark) {
		accommodationTextField.sendKeys(accommodation);
		descriptionTextField.sendKeys(description);
		otherTextField.sendKeys(other);
		landmarkTextField.sendKeys(landmark);
		System.out.println("updatd");
	}
	

}
