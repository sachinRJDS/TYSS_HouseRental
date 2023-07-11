package homerental_automationTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.houserental.genericutility.BaseClass;
import com.houserental.genericutility.ExcelUtility;
import com.houserental.genericutility.FileUtility;
import com.houserental.genericutility.JavaUtility;
import com.realestate.houseRentalObjectRepository.AdminHomePage;
import com.realestate.houseRentalObjectRepository.HomePage;
import com.realestate.houseRentalObjectRepository.ListOfUserPage;
import com.realestate.houseRentalObjectRepository.LoginPage;
import com.realestate.houseRentalObjectRepository.UserRegistrationPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.houserental.genericutility.ListenersImplimentation.class)
public class RegisterUserToApplicationInPOMTest extends BaseClass {
	@Test(groups = {"smoketest","regressiontest"},retryAnalyzer = com.houserental.genericutility.RetryImplementation.class)
	public void registerUserTest() throws IOException, InterruptedException {
	    LoginPage lLib=new LoginPage(driver);
		JavaUtility jLib=new JavaUtility();
		UserRegistrationPage uLib=new UserRegistrationPage(driver);
		AdminHomePage aHomeLib=new AdminHomePage(driver);
		ListOfUserPage listOfUserLib=new ListOfUserPage();
		HomePage hLib=new HomePage(driver);
		
		/*click on logout link*/
		hLib.getLogoutLink().click();
		
		/*enter the url*/
		String pathOfTheFile = fLib.getPropertyFilePath("userpropertypath");
		String URL = fLib.getPropertyData(pathOfTheFile, "url");
		driver.get(URL);
		
		/*click on register tab*/
		lLib.getRegisterTab().click();
		
		/*get random number and phone number*/
		String randomNumber = jLib.getRandomNumber()+"";
		int ran = jLib.getRandomNumber();
		String mobileNo = jLib.getRandomPhoneNumber()+"";
		
		/*read the data from the excel file*/
		String excelPath = fLib.getPropertyFilePath("registerexcelpath");
		String fullname = eLib.getExcelDataBasedOnTestID(excelPath, "Sheet4", "tc_02", "fullname")+randomNumber+ran;
		String username = eLib.getExcelDataBasedOnTestID(excelPath, "Sheet4", "tc_02", "username")+randomNumber+ran;
		String email = eLib.getExcelDataBasedOnTestID(excelPath, "Sheet4", "tc_02", "email")+randomNumber+ran;
		String password = eLib.getExcelDataBasedOnTestID(excelPath, "Sheet4", "tc_02", "password");
		
		/*enter the mandatory fields*/
		uLib.getFullnameUsernameEmail(fullname, username, email);
		uLib.getMobilenoPasswordConfirmPass(mobileNo, password, password);
		uLib.getSubmitBtn(driver);
		
		/*login as a admin*/
		lLib.getLoginBtn().click();
		loginToAdmin();
		
		/*click on registered user link*/
		aHomeLib.getRegisteredUserLink().click();
		
		/*verify registered user*/
		listOfUserLib.verifyRegisteredUser(driver, fullname, email, username);
		
	}

}
