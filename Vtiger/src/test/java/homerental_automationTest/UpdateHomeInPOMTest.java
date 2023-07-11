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
import com.realestate.houseRentalObjectRepository.EditPage;
import com.realestate.houseRentalObjectRepository.HomePage;
import com.realestate.houseRentalObjectRepository.LoginPage;
import com.realestate.houseRentalObjectRepository.RegisterRoomPage;
import com.realestate.houseRentalObjectRepository.SearchPage;
import com.realestate.houseRentalObjectRepository.UserApartmentListPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.houserental.genericutility.ListenersImplimentation.class)
public class UpdateHomeInPOMTest extends BaseClass{
	@Test(groups = {"regressiontest","smoketest"},retryAnalyzer = com.houserental.genericutility.RetryImplementation.class)
	public void updateHomeTest() throws Throwable {
		LoginPage lLib=new LoginPage(driver);
		HomePage hLib=new HomePage(driver);
		RegisterRoomPage rLib=new RegisterRoomPage(driver);
		SearchPage sLib=new SearchPage(driver);
		AdminHomePage aLib=new AdminHomePage(driver);
		UserApartmentListPage uaLib=new UserApartmentListPage(driver);
		AdminApartmentListPage aaLib=new AdminApartmentListPage(driver);
		EditPage editLib=new EditPage(driver);
		AdminHomePage adminLib=new AdminHomePage(driver);
		
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
		hLib.getRegisteredRoomsLink().click();
		aaLib.getEditButton(driver, name);
		
		/*read the update data from the excel*/
		String accommodation = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet2", "tc_02", "Accommondation")+randomNumber;
		String description = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet2", "tc_02", "Description")+randomNumber;
		String other = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet2", "tc_02", "Other")+randomNumber;
		String landmark = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet2", "tc_02", "Landmark")+randomNumber;
		
		/*enter the mandatory fields*/
		editLib.setAccommodationDescriptionOtherLandmark(accommodation, description, other, landmark);
		editLib.getSubmitBtn().click();
		
		/*verify updated data in details/update page*/
		hLib.getDetailsUpdateTab().click();
		uaLib.verifyUpdatedData(driver, accommodation, name);
	
		/*logout*/
		hLib.getLogoutLink().click();
		
		/*click on search tab */
		lLib.getSearchBtn().click();
		
		/*verify updated data in searched page*/
		sLib.getRoomTextField(availableRooms);
		sLib.getLocationTextField(city);
		sLib.getSearchBtn();
		sLib.verifyUpdatedData(driver, accommodation, name);
		
		/*click on login tab*/
		//lLib.getLoginBtn().click();
		
		/*login as a admin*/
		lLib.getLoginBtn().click();
		loginToAdmin();
		
		/*verify updated data in details/update page*/
		adminLib.getDetailsUpdateTab(driver);
		aaLib.verifyUpdatedData(driver, accommodation, name);		
	}
/*	@Test
	public void newTest() {
		System.out.println("hi");
	}*/

}
