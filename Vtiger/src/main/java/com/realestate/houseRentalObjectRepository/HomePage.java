package com.realestate.houseRentalObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	/*declaration*/
	@FindBy(linkText="Home")
	private WebElement homeTab;
	
	@FindBy(linkText="Register")
	private WebElement registerTab;
	
	@FindBy(linkText="Details/Update")
	private WebElement detailsUpdateTab;
	
	@FindBy(xpath="//b[text()='Registered Rooms: ']/child::span")
	private WebElement registeredRoomsCount;
	
	@FindBy(xpath="//div[@class='alert alert-warning']")
	private WebElement registeredRoomsLink;
	
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;
	
	/*initialisation*/
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/*utilisation*/
	public WebElement getHomeTab() {
		return homeTab;
	}

	public WebElement getRegisterTab() {
		return registerTab;
	}

	public WebElement getDetailsUpdateTab() {
		return detailsUpdateTab;
	}

	public WebElement getRegisteredRoomsLink() {
		return registeredRoomsLink;
	}
	public void getRegisteredRoomsCount() {
		 String text = registeredRoomsCount.getText();
		 System.out.println("Registered rooms count: "+text);
	}
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public String getUserName(WebDriver driver) {
		String user = driver.findElement(By.xpath("//a[text()='Darshanraj ']")).getText();
		char[] ch = user.toCharArray();
		for(int i=0;i<user.length();i++) {
			if(i==0&&ch[i]!=' '||ch[i-1]==' '&&ch[i]!=' ') {
				if(ch[i]>='a'&&ch[i]<='z') {
					ch[i]=(char)(ch[i]-32);
				}
				
			}else if(ch[i]>='A'&&ch[i]<='Z'){
				ch[i]=(char)(ch[i]+32);				
			}
		}
		String s=new String(ch);
		return s;
	}


}
