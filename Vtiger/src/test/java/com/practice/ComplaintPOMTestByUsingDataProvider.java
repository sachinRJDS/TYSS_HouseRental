package com.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.houserental.genericutility.BaseClass;
import com.houserental.genericutility.ExcelUtility;
import com.houserental.genericutility.FileUtility;
import com.houserental.genericutility.JavaUtility;
import com.houserental.genericutility.WebDriverActionUtility;
import com.realestate.houseRentalObjectRepository.AdminComplaintListPage;
import com.realestate.houseRentalObjectRepository.AdminHomePage;
import com.realestate.houseRentalObjectRepository.ComplaintPage;
import com.realestate.houseRentalObjectRepository.HomePage;
import com.realestate.houseRentalObjectRepository.LoginPage;
import com.realestate.houseRentalObjectRepository.RegisterRoomPage;
import com.realestate.houseRentalObjectRepository.UserApartmentListPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.houserental.genericutility.ListenersImplimentation.class)
public class ComplaintPOMTestByUsingDataProvider extends BaseClass{
	@Test(dataProvider = "object")
	public  void mainTest(String testCaseId,String name,String mobile,String emailId,String homeNo,String availableRooms,String country,String state,String city,String rent,String deposit,String Address) throws IOException {
		/*object */
		LoginPage lLib=new LoginPage(driver);
		HomePage hLib=new HomePage(driver);
		RegisterRoomPage rLib=new RegisterRoomPage(driver);
		UserApartmentListPage uaLib=new UserApartmentListPage(driver);
		ComplaintPage cLib=new ComplaintPage(driver);
		AdminHomePage aLib=new AdminHomePage(driver);
		AdminComplaintListPage aComPage=new AdminComplaintListPage();

		/*get random number and phone number*/
		String randomNumber = jLib.getRandomNumber()+"";
		String mobileNo = jLib.getRandomPhoneNumber()+"";

		/*read username*/
		String user = hLib.getUserName(driver);

		/*click on register tab*/
		hLib.getRegisterTab().click();

		/*enter all the mandatory text field*/
		String pathOfTheExcelFile = fLib.getPropertyFilePath("registerexcelpath");

		rLib.getNameMobileEmail(name, mobileNo, emailId);
		rLib.getHomeNOAvailableRoom(randomNumber, availableRooms);
		rLib.getCountryStateCity(country, state, city);
		rLib.getRentDepositFacility(rent, deposit, "");
		rLib.getDescriptionLandmarkAddress(rent, "", Address);
		rLib.getVacantImage("Vacant", "imagepath");
		rLib.getSubmitBtn();


		/*click on details/update tab*/
		hLib.getDetailsUpdateTab().click();

		/*click on complaint button*/
		uaLib.getComplaintBtn().click();

		/*enter the room name and complaint*/
		String complaint = eLib.getExcelDataBasedOnTestID(pathOfTheExcelFile, "Sheet3", "tc_02", "Complaint")+randomNumber;
		cLib.getNameAndComplaint(driver,homeNo, complaint);

		/*logout*/
		hLib.getLogoutLink().click();

		/*click on login tab*/
		lLib.getLoginBtn().click();
		loginToAdmin();

		/*click on complaint list tab*/
		aLib.getComplaintListTab().click();

		/*verify the user raised complaint*/
		aComPage.verifyUserRaisedComplaint(driver, homeNo, complaint, user);				
	}
	@DataProvider
	public Object[][] object() throws IOException{
		String path = fLib.getPropertyFilePath("registerexcelpath");

		int lastRowNumber = eLib.getLastRowNumber(path, "Sheet1");
		int lastCellNumber = eLib.getLastCellNumber(path, "Sheet1", 1);

		Object[][]obj=new Object[1][lastCellNumber];
		for(int i=0;i<lastCellNumber;i++) {
			obj[0][i]=eLib.getExcelDataBasedOnRowAndCol(path, "Sheet1", 1, i);
		}
		System.out.println("success");
		return obj;

	}

}
