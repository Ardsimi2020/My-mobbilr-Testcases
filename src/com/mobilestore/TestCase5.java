package com.mobilestore;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TestCase5 {
	
	public String url = "http://live.demoguru99.com";
	  public WebDriver driver;
	  public String pathdriver = "C:\\Myfirefoxdriver\\geckodriver.exe";
	  public String FistName = "Arnold";
	  public String LastName = "Dimi";
	  public String Email = "rufelinusa@yahoo.fr";
	  public String password = "rolland@123";

 
  
     @BeforeTest
     public void beforeTest() {
  System.setProperty("webdriver.gecko.driver",pathdriver); 
  driver = new FirefoxDriver();
 		
  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  
    }

   @Test
   public void f() throws Exception {
   driver.navigate().to(url);
   driver.manage().window().maximize();
   
  Thread.sleep(3000);
   
   //2.Click on my Account Link
   driver.findElement(By.cssSelector("div.links:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")).click();
   
   //3.Application login
	  driver.findElement(By.id("email")).sendKeys("rufelinusayahoo.fr");
	  driver.findElement(By.id("email")).clear();
	  driver.findElement(By.id("email")).sendKeys("rufelinusa@yahoo.fr");
	  driver.findElement(By.id("pass")).sendKeys("rolland@123");
	  driver.findElement(By.cssSelector("html#top.js.no-touch.localstorage.no-ios body.customer-account-login div.wrapper div.page div.main-container.col1-layout div.main div.col-main div.account-login form#login-form.scaffold-form div.col2-set div.col-2.registered-users div.buttons-set button#send2.button span span")).click();
	  
	  //4.Click on My order
	  driver.findElement(By.cssSelector("div.block-content:nth-child(2) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")).click();
	  
	  //5.Click on my View order
	 // driver.findElement(By.cssSelector("div.block-content:nth-child(2) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1)")).click();
	  
	  //5.Click on review my order
	 driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[6]/span/a[1]")).click();
	 
      //6.Click on print order
	// driver.findElement(By.cssSelector(".link-print")).click();
	 
	// driver.close();
	  
	  
	  
    
	  
	  
   }
  
  
  
  @AfterTest
  public void afterTest() {
  }

}
