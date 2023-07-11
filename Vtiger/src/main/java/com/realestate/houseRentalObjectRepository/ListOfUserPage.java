package com.realestate.houseRentalObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class ListOfUserPage {
	public void verifyRegisteredUser(WebDriver driver,String fullname,String email,String username) {
		String name = driver.findElement(By.xpath("//tr/td[1][text()='"+fullname+"']")).getText();
		String email1 = driver.findElement(By.xpath("//tr/td[2][text()='"+email+"']")).getText();
		String user = driver.findElement(By.xpath("//tr/td[3][text()='"+username+"']")).getText();
		String role = driver.findElement(By.xpath("//tr/td[4][text()='user']")).getText();
		
		Assert.assertTrue(name.equals(fullname)&&email1.equals(email)&&user.equals(username), "user id is not verified and fail");
		Reporter.log("user id is verified and pass",true);
		/*if(name.equals(fullname)&&email1.equals(email)&&user.equals(username)) {
			System.out.println("user id is verified and pass");
		}else {
			System.out.println("user id is not verified and fail");
		}*/
		
	}

}
