package com.mobilestore;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class TestCase6 {
	
  public String url = "http://live.demoguru99.com";
  public WebDriver driver;
  public String pathdriver = "C:\\Myfirefoxdriver\\geckodriver.exe";
  public String FistName = "Arnold";
  public String MidleName = "Rufelin";
  public String LastName = "Dimi";
  public String Email = "rufelinusa@yahoo.fr";
  public String password = "rolland@123";
  
  @BeforeTest
  public void beforeTest() {
  System.setProperty("webdriver.gecko.driver", pathdriver);
  driver = new FirefoxDriver();
  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  
  }
  
 @Test
  public void f() throws Exception {
	 driver.navigate().to(url);
	 driver.manage().window().maximize();
	 
	 Thread.sleep(2000);
	 //2.Click on my Account
	 driver.findElement(By.cssSelector("div.links:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")).click();
	 
	 //3.Enter your Email and password
	 driver.findElement(By.id("email")).sendKeys("rufelinusa@yahoo.fr");
	 driver.findElement(By.id("pass")).sendKeys("rolland@123");
	 
	 //4.Click on login
	 driver.findElement(By.cssSelector("#send2 > span:nth-child(1) > span:nth-child(1)")).click();
	 //5.Click on Reorder
	 driver.findElement(By.cssSelector(".link-reorder")).click();
	 //6.Change The QTY 
	 driver.findElement(By.cssSelector(".product-cart-actions > input:nth-child(1)")).clear();
	 driver.findElement(By.cssSelector(".product-cart-actions > input:nth-child(1)")).sendKeys("10");
	 //7.Click on update
	 driver.findElement(By.cssSelector("button.btn-update:nth-child(2) > span:nth-child(1) > span:nth-child(1)")).click();
	 
	 //Verify The Grand Total is Change
	 String Vprice = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[3]/span/span")).getText();
	 String GRANDTOTAL = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span")).getText();
	 
	 if(Vprice == GRANDTOTAL ) {
		 System.out.println("Vprice =" + Vprice);
		 
	 }else {
		 System.out.println("GRANDTOTAL has changed to" + GRANDTOTAL); 
		 
	 }
	 
	 //Click on proceed Check-out
	 driver.findElement(By.cssSelector(".method-checkout-cart-methods-onepage-bottom > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
		
	 Select dropdown1 = new Select(driver.findElement(By.id("billing-address-select")));
	 dropdown1.selectByVisibleText("Rufelin Rolland Ibara, 121 Willowdale dr, Hurst, Alabama 21702, United States");
	 
	 //Click on Radio button
	 driver.findElement(By.id("billing:use_for_shipping_no")).click();
	 
	  Thread.sleep(2000);
	 //Billing information Click on Continue
	 driver.findElement(By.cssSelector("#billing-buttons-container > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
	 
	
	 
	 
	
 }
  
  @AfterTest
  public void afterTest() {
	 // driver.close();
	  
  }

}
