package com.realestate.houseRentalObjectRepository;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.houserental.genericutility.FileUtility;
import com.houserental.genericutility.WebDriverActionUtility;

public class RegisterRoomPage {
	/*declaration*/
	@FindBy(xpath="//a[text()='Apartment Registration']")
	private WebElement apartmenetRegistrationTab;
	@FindBy(id="fullname")
	private WebElement fullNameTextField;
	@FindBy(id="mobile")
	private WebElement mobileNoTextFiled;
	@FindBy(id="email")
	private WebElement emailTextFiled;
	@FindBy(id="plot_number")
	private WebElement houseNoTextField;
	@FindBy(id="rooms")
	private WebElement roomsTextFiled;
	@FindBy(id="country")
	private WebElement countryTextField;
	@FindBy(id="state")
	private WebElement stateTextField;
	@FindBy(id="city")
	private WebElement cityTextField;
	@FindBy(id="rent")
	private WebElement rentTextField;
	@FindBy(id="deposit")
	private WebElement depositTextField;
	@FindBy(id="address")
	private WebElement addressTextField;
	@FindBy(id="vacant")
	private WebElement vacantDropDown;
	@FindBy(id="image")
	private WebElement imageLink;
	@FindBy(name="register_individuals")
	private WebElement submitBtn;
	@FindBy(id="accommodation")
	private WebElement facilityTextField;
	@FindBy(id="description")
	private WebElement descriptionTextField;
	@FindBy(id="landmark")
	private WebElement landmarkTextField;
	@FindBy(id="sale")
	private WebElement saleTextField;
	@FindBy(xpath="//h2[text()='Register Room']/preceding-sibling::div")
	private WebElement successfullMessage;
	
	

	/*initialisation*/
	public RegisterRoomPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/*utilisation*/
	public WebElement getSaleTextField() {
		return saleTextField;
	}
	public WebElement getApartmenetRegistrationTab() {
		return apartmenetRegistrationTab;
	}

	public WebElement getFullNameTextField() {
		return fullNameTextField;
	}

	public WebElement getMobileNoTextFiled() {
		return mobileNoTextFiled;
	}

	public WebElement getEmailTextFiled() {
		return emailTextFiled;
	}

	public WebElement getHouseNoTextField() {
		return houseNoTextField;
	}

	public WebElement getRoomsTextFiled() {
		return roomsTextFiled;
	}

	public WebElement getCountryTextField() {
		return countryTextField;
	}

	public WebElement getStateTextField() {
		return stateTextField;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public WebElement getRentTextField() {
		return rentTextField;
	}

	public WebElement getDepositTextField() {
		return depositTextField;
	}

	public WebElement getAddressTextField() {
		return addressTextField;
	}

	public WebElement getVacantDropDown() {
		return vacantDropDown;
	}

	public WebElement getImageLink() {
		return imageLink;
	}

	public WebElement getFacilityTextField() {
		return facilityTextField;
	}

	public WebElement getDescriptionTextField() {
		return descriptionTextField;
	}

	public WebElement getLandmarkTextField() {
		return landmarkTextField;
	}

	public void getSubmitBtn() {
		submitBtn.click();
		boolean displayed = successfullMessage.isDisplayed();
		if(displayed) {
			System.out.println("home is registered");
		}else {
			System.out.println("home is already exist");
		}
		
	}
	
	/*business layer*/
	
	public void getNameMobileEmail(String fullName,String mobileNo,String email) {
		fullNameTextField.sendKeys(fullName);
		mobileNoTextFiled.sendKeys(mobileNo);
		emailTextFiled.sendKeys(email);
	}
	public void getHomeNOAvailableRoom(String randomNumber,String availableRoom) {
		houseNoTextField.sendKeys(randomNumber);
		roomsTextFiled.sendKeys(availableRoom);
	}
	public void getCountryStateCity(String country,String state,String city) {
		countryTextField.sendKeys(country);
		stateTextField.sendKeys(state);
		cityTextField.sendKeys(city);
	}
	public void getRentDepositFacility(String rent,String deposit,String facility) {
		rentTextField.sendKeys(rent);
		depositTextField.sendKeys(deposit);
		facilityTextField.sendKeys(facility);
	}
	public void getDescriptionLandmarkAddress(String description,String landmark,String address) {
		descriptionTextField.sendKeys(description);
		landmarkTextField.sendKeys(landmark);
		addressTextField.sendKeys(address);
	}
	public void getVacantImage(String vacant,String path) throws IOException {
		WebDriverActionUtility wLib=new WebDriverActionUtility();
		wLib.select(vacantDropDown, vacant);
		FileUtility fLib=new FileUtility();
		String location = fLib.getPropertyFilePath(path);
		File f=new File(location);
		String absoluteFile = f.getAbsolutePath();
		imageLink.sendKeys(absoluteFile);
	}

	
	
	

}
