package homerental_automationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.houserental.genericutility.BaseClass;
import com.houserental.genericutility.ExcelUtility;
import com.houserental.genericutility.FileUtility;
import com.houserental.genericutility.JavaUtility;
import com.houserental.genericutility.WebDriverActionUtility;
import com.realestate.houseRentalObjectRepository.AdminApartmentListPage;
import com.realestate.houseRentalObjectRepository.AdminHomePage;
import com.realestate.houseRentalObjectRepository.UserApartmentListPage;
import com.realestate.houseRentalObjectRepository.HomePage;
import com.realestate.houseRentalObjectRepository.LoginPage;
import com.realestate.houseRentalObjectRepository.RegisterRoomPage;
import com.realestate.houseRentalObjectRepository.SearchPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterHomeInPOMTest extends BaseClass {
	@Test(groups = {"smoketest"},retryAnalyzer = com.houserental.genericutility.RetryImplementation.class)
	public  void registerHomeTest() throws Throwable {
		RegisterRoomPage rLib=new RegisterRoomPage(driver);
		SearchPage sLib=new SearchPage(driver);
		AdminHomePage aLib=new AdminHomePage(driver);
		UserApartmentListPage uaLib=new UserApartmentListPage(driver);
		AdminApartmentListPage aaLib=new AdminApartmentListPage(driver);
		HomePage hLib=new HomePage(driver);
		LoginPage lLib=new LoginPage(driver);
		
		/*get random number and phone number*/
		String randomNumber = jLib.getRandomNumber()+"";
		String mobileNo = jLib.getRandomPhoneNumber()+"";
		
		/*click on register tab*/
		hLib.getRegisterTab().click();
		
		/*enter all the mandatory text field*/
		String pathOfTheExcelFile = fLib.getPropertyFilePath("registerexcelpath");
		String name = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet1", "tc_05", "FullName")+randomNumber;
		String emailId = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet1", "tc_05", "Email_ID")+randomNumber;
		String homeNo = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet1", "tc_05", "House_No");
		String availableRooms = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet1", "tc_05", "Available_Rooms");
		String country = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet1", "tc_05", "Country");
		String state = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet1", "tc_05", "State");
		String city = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet1", "tc_05", "City");
		String rent = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet1", "tc_05", "Rent ");
		String deposit = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet1", "tc_05", "Deposit");
		String Address = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet1", "tc_05", "Address");
		
		rLib.getNameMobileEmail(name, mobileNo, emailId);
		rLib.getHomeNOAvailableRoom(randomNumber, availableRooms);
		rLib.getCountryStateCity(country, state, city);
		rLib.getRentDepositFacility(rent, deposit, "");
		rLib.getDescriptionLandmarkAddress(rent, "", Address);
		rLib.getVacantImage("Vacant", "imagepath");
		rLib.getSubmitBtn();
		
		/*click on home tab*/
		hLib.getHomeTab().click();
		hLib.getRegisteredRoomsCount();
		hLib.getRegisteredRoomsLink().click();
		uaLib.getVerifyRegisteredRoom(driver,name);
		//hLib.getVerifyRegisteredRoom(name);
		
		/*click on details/update*/
		hLib.getDetailsUpdateTab().click();
		uaLib.getVerifyRegisteredRoom(driver,name);
		
		/*click on logout link*/
		hLib.getLogoutLink().click();
		
		/*searching user registered home */
		lLib.getSearchBtn();
		sLib.getRoomTextField(availableRooms);
		sLib.getLocationTextField(city);
		sLib.getSearchBtn();
		sLib.getVerifyRegisteredRoom(driver, name);
				
		/*login as a admin*/
		lLib.getLoginBtn().click();
		loginToAdmin();
		
		/*admin home page*/
		aLib.getRoomsForRentCount();
		aLib.getRoomsForRentLink().click();
		aaLib.getVerifyRegisteredRoomInHome(driver, name);
		
		/*details/update page*/
		aLib.getDetailsUpdateTab(driver);
		aaLib.getVerifyRegisteredRoomInDetails(driver, name);
		
		
		
		
	}

}
