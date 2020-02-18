package com.mobilestore;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCase3 {
	public String url = "http://live.demoguru99.com";
	public WebDriver driver;
	public String pathdriver = "C:\\MyChromedriver\\chromedriver.exe";
	
 
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver",pathdriver);
	  driver = new ChromeDriver();
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
  }
  
  @Test
  public void MobileRegistrationAcount() throws Exception {
	  // Call or Navigate to the url page
	  driver.get(url);
	  
	  //Maximize the url page
	  driver.manage().window().maximize();
	  
	  //Click on my Account Link
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
	  Thread.sleep(200);
	  
	  //switch to new window
	  for ( String handle: driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
	  } 
	 //Click on Create An Account link
     driver.findElement(By.xpath("//*[@id=\"login-form\"]/div/div[1]/div[2]/a/span/span")).click();
     Thread.sleep(200);
		  
	// Switch to a new Window
	for (String handle: driver.getWindowHandles()) {
			  
	 driver.switchTo().window(handle);
}
	// fill new User information
	driver.findElement(By.name("firstname")).sendKeys("rufelin");
	driver.findElement(By.id("middlename")).sendKeys("arnold");
	driver.findElement(By.name("lastname")).sendKeys("dimi");
	
	driver.findElement(By.id("password")).sendKeys("Rolland@123");
	driver.findElement(By.name("confirmation")).sendKeys("Rolland@123");
	
	// Click on Registration
	driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button/span/span")).click();
	
	//fail to Register. Email address is required.please navigate back and Enter the Email address
	Thread.sleep(6000);
	
	//Navigate back
	driver.navigate().back();
	
	//Click on on Create an Account link
	driver.findElement(By.xpath("//*[@id=\"login-form\"]/div/div[1]/div[2]/a/span/span")).click();
	Thread.sleep(200);
	
	driver.findElement(By.name("firstname")).sendKeys("rufelin");
	driver.findElement(By.id("middlename")).sendKeys("arnold");
	driver.findElement(By.name("lastname")).sendKeys("dimi");
	driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys("usa00@gmail.com");
	driver.findElement(By.id("password")).sendKeys("rolland@123");
	driver.findElement(By.name("confirmation")).sendKeys("rolland@123");
	
	//Click on Register
	driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button/span/span")).click();
	Thread.sleep(6000);
	
	//Verify Registration is done
	String ExpectedMsg = "Thank you for registering with Main Website Store.";
	String ActualMsg = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span")).getText();
	System.out.println(ActualMsg);
	
	
	
	for (String handle: driver.getWindowHandles()) {
		 driver.switchTo().window(handle);
		}
	
	//Click on TV Menu
	driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"wishlist-view-form\"]/div/div/button[1]/span/span")).click();
	driver.findElement(By.name("emails")).sendKeys("us00a@gmail.com");
	driver.findElement(By.id("message")).sendKeys("I'm invite you  to check this out thanks");
	driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button/span/span")).click();
  
	//Verify Expected Result
	String ExpectedMsg1 = "Your Wishlist has been shared.";
	String ActualMsg2 = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
	System.out.println(ActualMsg2);
	
	Assert.assertEquals(ActualMsg, ExpectedMsg);
	Assert.assertEquals(ActualMsg2, ExpectedMsg1);
	Thread.sleep(6000);

  }
	
		  
  @AfterTest
  public void afterTest() {
	 // driver.close();
	  
	  
  }

}
