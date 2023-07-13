package com.houserental.genericutility;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.realestate.houseRentalObjectRepository.HomePage;
import com.realestate.houseRentalObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	/*static {
		System.setProperty("webdriver.edge.driver", "./src/main/resources/driver/msedgedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./src/main/resources/driver/geckodriver.exe");
	}*/
	public static WebDriver sdriver;
	public WebDriver driver=null;
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public DataBaseUtility dLib=new DataBaseUtility();
	public WebDriverActionUtility wLib=new WebDriverActionUtility();
	public String pathOfTheFile;


	@BeforeSuite(groups = {"regressiontest","smoketest"})
	public void connectToDB() throws SQLException {
		dLib.connectDB();	
		Reporter.log("connected to database",true);
	}
	@BeforeClass(groups = {"regressiontest","smoketest"})
	public void launchTheBrowser() throws IOException {
		/* welcome */
		WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().setup();
		pathOfTheFile = fLib.getPropertyFilePath("userpropertypath");
	   // String browser = fLib.getPropertyData(pathOfTheFile, "browser");
	   String url = fLib.getPropertyData(pathOfTheFile, "url");
		String browser = System.getProperty("browser");
		//String url = System.getProperty("url");
		switch(browser) {
		case "chrome" :driver=new ChromeDriver();
		break;
		case "firefox":driver=new FirefoxDriver();
		break;
		case "edge":driver=new EdgeDriver();
		break;
		default:driver=new ChromeDriver();		
		}
		sdriver=driver;
		driver.manage().window().maximize();
		driver.get(url);
		wLib.waitForElementVisible(driver);
		Reporter.log("Browser is launched",true);
	}
	
	@BeforeMethod(groups = {"regressiontest","smoketest"})
	public void loginToApplication() throws IOException {
		 LoginPage lLib=new LoginPage(driver);
		String username = fLib.getPropertyData(pathOfTheFile, "username");
		String password = fLib.getPropertyData(pathOfTheFile, "password");
		lLib.getLoginBtn().click();
		lLib.loginToApplication(username, password);	


	}
	@AfterMethod(groups = {"regressiontest","smoketest"})
	public void logoutFromTheApplication() {
		HomePage hLib=new HomePage(driver);
		hLib.getLogoutLink().click();
		Reporter.log("logout successfully",true);
		}

	@AfterClass(groups = {"regressiontest","smoketest"})
	public void closeTheBrowser() {
		driver.quit();
		Reporter.log("browser is closed",true);
	}
	@AfterSuite(groups = {"regressiontest","smoketest"})
	public void closeDB() throws SQLException {
	 	dLib.closeDB();
		Reporter.log("Database connection is closed");

	}
	public void loginToAdmin() throws IOException {
		LoginPage lLib=new LoginPage(driver);
		String pathOfAdmin = fLib.getPropertyFilePath("adminpropertypath");
		String USERNAME1 = fLib.getPropertyData(pathOfAdmin, "username");
		String PASSWORD1 = fLib.getPropertyData(pathOfAdmin, "password");
		lLib.loginToApplication(USERNAME1, PASSWORD1);
	}

}