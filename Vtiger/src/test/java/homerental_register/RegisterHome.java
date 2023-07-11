package homerental_register;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisterHome {
	
	static int t;
	static {
		Random r=new Random();
		t=r.nextInt(100);		
	}
	static String name="Owner Name: Mahesh"+t;
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
		String text1 = driver.findElement(By.xpath("//b[text()='Registered Rooms: ']/child::span")).getText();
		int a=Integer.parseInt(text1);
		
		
		Random r=new Random();
		String s1="";
		String[]s2=new String[10];
		for(int i=0;i<10;i++) {
			String n = r.nextInt(10)+"";
			s2[i]=n;			
		}
		for(int i=0;i<s2.length;i++) {
			s1=s1+s2[i];
		}
		
		
		
		
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("fullname")).sendKeys("Mahesh"+t);
		driver.findElement(By.id("mobile")).sendKeys(s1);
		driver.findElement(By.id("email")).sendKeys("mahesh"+t+"@gmail.com");
		driver.findElement(By.id("plot_number")).sendKeys(t+"");
		driver.findElement(By.id("rooms")).sendKeys("3bhk");
		driver.findElement(By.id("country")).sendKeys("india");
		driver.findElement(By.id("state")).sendKeys("karnataka");
		driver.findElement(By.id("city")).sendKeys("bangalore");
		driver.findElement(By.id("rent")).sendKeys("rent");
		driver.findElement(By.id("deposit")).sendKeys("20000");
		driver.findElement(By.id("address")).sendKeys("#79 basavanagudi");
		WebElement we = driver.findElement(By.id("vacant"));
		Select s=new Select(we);
		s.selectByVisibleText("Vacant");
		File f=new File("C:\\Users\\mkits\\OneDrive\\Pictures\\Screenshots\\Screenshot (1).png");
		String absolutePath = f.getAbsolutePath();
		driver.findElement(By.id("image")).sendKeys(absolutePath);
	    driver.findElement(By.name("register_individuals")).click();
	    boolean message = driver.findElement(By.xpath("//h2[text()='Register Room']/preceding-sibling::div")).isDisplayed();
	    if(message) {
	    	System.out.println("Registration successfull. Thank you");
	    }else {
	    	System.out.println("This address is already exists");
	    }
	    
	    
	     driver.findElement(By.linkText("Home")).click();
	     String text = driver.findElement(By.xpath("//b[text()='Registered Rooms: ']/child::span")).getText();
	     int b=Integer.parseInt(text);
	     if(a!=b) {
	    	 System.out.println("count is updated");
	     }else {
	    	 System.out.println("count is not updated");    
	     }
	     driver.findElement(By.xpath("//div[@class='alert alert-warning']")).click();
	     
	     
	     int c=0;
	    List<WebElement> all = driver.findElements(By.xpath("//b[text()='Owner Name: ']/parent::p"));
	   for(WebElement we1:all) {
		   String ownerName = we1.getText();
		 if(ownerName.equals(name)) {
			 c++;
			 break;
		 }
	   }
	   if(c==1) {
		   System.out.println("owner registered room is present in apartment list");
	   }else {
		   System.out.println("owner registered room is not present in apartment list");
	   }
	   
	   //driver.findElement(By.linkText("Register")).click();
	   driver.findElement(By.linkText("Details/Update")).click();
	   int d=0;
	   List<WebElement> all1 = driver.findElements(By.xpath("//b[text()='Owner Name: ']/parent::p"));
	   for(WebElement we2:all1) {
		   String ownerName = we2.getText();
		 if(ownerName.equals(name)) {
			 d++;
			 break;
		 }
	   }
	   if(d==1) {
		   System.out.println("owner registered room is present in details/update page");
	   }else {
		   System.out.println("owner registered room is not present in details/update page");
	   }
	   driver.findElement(By.xpath("//a[text()='Logout']")).click();
	   
	   
	   //search
	   driver.findElement(By.xpath("//a[text()='Search']")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.id("keywords")).sendKeys("3bhk");
	   driver.findElement(By.id("location")).sendKeys("bangalore");
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//button[text()='Search']")).click();
	   Thread.sleep(2000);
	   JavascriptExecutor j=(JavascriptExecutor) driver;
	   j.executeScript("window.scrollBy(0,700)");
	   int y = driver.findElement(By.xpath("//b[text()='Owner Name: ']/parent::p[text()='Mahesh']")).getLocation().getY();
	   JavascriptExecutor j1=(JavascriptExecutor) driver;
	   j1.executeScript("window.scrollBy(0,"+y+")");
	   int h=0;
	   List<WebElement> all3 = driver.findElements(By.xpath("//b[text()='Owner Name: ']/parent::p"));
	   for(WebElement we2:all3) {
		   String ownerName = we2.getText();
			 h++;
			 break;
		 }
	   
	   if(d==1) {
		   System.out.println("owner registered room is present in searched page");
	   }else {
		   System.out.println("owner registered room is not present in searched page");
	   }	   
	     
	   //admin
	  driver.findElement(By.xpath("//a[text()='Login']")).click();
	  driver.findElement(By.id("exampleInputEmail1")).sendKeys("admin");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//b[text()='Rooms for Rent: ']")).click();
		  int e=0;
		   List<WebElement> all2 = driver.findElements(By.xpath("//b[text()='Owner Name: ']/parent::p"));
		   for(WebElement we2:all2) {
			   String ownerName = we2.getText();
			 if(ownerName.equals(name)) {
				 e++;
				 break;
			 }
		   }
		   if(e==1) {
			   System.out.println("owner registered room is present in apartment list page of admin");
		   }else {
			   System.out.println("owner registered room is not present in apartment list page of admin");
		   }
	    
		   driver.findElement(By.linkText("Details/Update")).click();
		   int g=0;
		   List<WebElement> all4 = driver.findElements(By.xpath("//b[text()='Owner Name: ']/parent::p"));
		   for(WebElement we2:all4) {
			   String ownerName = we2.getText();
			 if(ownerName.equals(name)) {
				 g++;
				 break;
			 }
		   }
		   if(g==1) {
			   System.out.println("owner registered room is present in details/update page of admin");
		   }else {
			   System.out.println("owner registered room is not present in details/update page of admin");
		   }
		   System.out.println(name+"***");
		   driver.close();
	}

}
