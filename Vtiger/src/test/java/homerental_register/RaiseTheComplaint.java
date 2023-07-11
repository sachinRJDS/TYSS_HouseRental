package homerental_register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RaiseTheComplaint {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost/House_Rental/");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("Shbz");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Rjds123");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//a[text()='Details/Update']")).click();
		Thread.sleep(2000);
		
				
	    driver.findElement(By.xpath("//p[text()='Mahesh']/../../../a[text()='Edit']")).click();
		int k=RegisterHome.t;
		String ss="fan"+k;
		
		driver.findElement(By.id("accommodation")).sendKeys(ss);
		driver.findElement(By.id("description")).sendKeys("we deduct the 5000rs for painting purpose when your vacant the home");
		driver.findElement(By.id("other")).sendKeys("--");
		driver.findElement(By.id("landmark")).sendKeys("qspider");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.xpath("//div[@class='alert alert-warning']")).click();
		String accommondation="Accommodation: "+"fan";
		String acc = driver.findElement(By.xpath("//p[text()='Mahesh']/../../child::div[3]/p[1]")).getText();
		if(acc.equals(accommondation)) {
			System.out.println("updated successfully");
		}else {
			System.out.println("not updated");
		}
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		//search
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		driver.findElement(By.id("keywords")).sendKeys("3bhk");
		driver.findElement(By.id("location")).sendKeys("bangalore");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		String accommondation1="Accommodation: "+"fanfan";
		String acc1 = driver.findElement(By.xpath("//p[text()='Mahesh']/../../child::div[3]/p[1]")).getText();
		if(acc1.equals(accommondation1)) {
			System.out.println("registered home is updated in searched page");
		}else {
			System.out.println("registered home is not updated in searched page");
		}
		
		
		//admin
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//b[text()='Rooms for Rent: ']")).click();
		String acc2 = driver.findElement(By.xpath("//p[text()='Mahesh']/../../child::div[3]/p[text()='fanfan']")).getText();
		if(acc2.equals(accommondation1)) {
			System.out.println("registered home is updated in admin apartment list");
		}else {
			System.out.println("registered home is not updated in admin apartment list");
		}
		
		
		driver.findElement(By.linkText("Details/Update")).click();
		String acc3 = driver.findElement(By.xpath("//p[text()='Mahesh']/../../child::div[3]/p[text()='fanfan']")).getText();
		if(acc3.equals(accommondation1)) {
			System.out.println("registered home is updated in details/update page of admin");
		}else {
			System.out.println("registered home is not updated in deatils/update page of admin");
		}
		
		
	}

}
