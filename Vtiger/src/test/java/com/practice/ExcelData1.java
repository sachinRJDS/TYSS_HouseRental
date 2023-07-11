package com.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.houserental.genericutility.ExcelUtility;
import com.houserental.genericutility.FileUtility;
import com.houserental.genericutility.JavaUtility;
import com.realestate.houseRentalObjectRepository.RegisterRoomPage;

public class ExcelData1 {
	public void getExcelDataBasedOnTestId() throws EncryptedDocumentException, IOException {
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		//RegisterRoomPage rLib=new RegisterRoomPage(driver);
		
		String randomNumber = jLib.getRandomNumber()+"";
		String mobileNo = jLib.getRandomPhoneNumber()+"";
		
		
		
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
		
	/*	rLib.getNameMobileEmail(name, mobileNo, emailId);
		rLib.getHomeNOAvailableRoom(randomNumber, availableRooms);
		rLib.getCountryStateCity(country, state, city);
		rLib.getRentDepositFacility(rent, deposit, "");
		rLib.getDescriptionLandmarkAddress(rent, "", Address);
		rLib.getVacantImage("Vacant", "imagepath");*/
	}


}
