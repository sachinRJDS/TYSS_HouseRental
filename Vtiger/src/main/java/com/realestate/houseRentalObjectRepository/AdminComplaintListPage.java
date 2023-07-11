package com.realestate.houseRentalObjectRepository;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AdminComplaintListPage {
	
	public void verifyUserRaisedComplaint(WebDriver driver,String houseNo,String complaint,String user) {
		String room = driver.findElement(By.xpath("//tr/td[text()='"+houseNo+"']")).getText();
		String user2 = driver.findElement(By.xpath("//tr/td[3][text()='"+user+"']")).getText();
		String com1 = driver.findElement(By.xpath("//tr/td[2][text()='"+complaint+"']")).getText();
		Assert.assertTrue(room.equals(houseNo)&&user2.equals(user)&&com1.equals(complaint), "user raised complaint is not present in admin complaint list");
		Reporter.log("user raised complaint is present in admin complaint list",true);
	/*	if(room.equals(houseNo)&&user2.equals(user)&&com1.equals(complaint)) {
			System.out.println("user raised complaint is present in admin complaint list");
		}else {
			System.out.println("user raised complaint is not present in admin complaint list");
		}*/
	}

}
