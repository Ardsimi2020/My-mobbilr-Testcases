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

public class TestCase7 {
  //Go to the url or web page 
  public String url = "http:\\live.demoguru99.com";
  public WebDriver driver;
  public String pathdriver = "C:\\Myfirefoxdriver\\geckodriver.exe";
  
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
	  
	  //Click on Mobile
	  driver.findElement(By.cssSelector("li.level0:nth-child(1) > a:nth-child(1)")).click();
	  
	  // add the iphone to Cart
	  driver.findElement(By.cssSelector("li.item:nth-child(2) > div:nth-child(2) > div:nth-child(4) > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
	  
	  // Enter Discount Code
	  driver.findElement(By.id("coupon_code")).clear();
	  driver.findElement(By.id("coupon_code")).sendKeys("GURU50");
	  
	  //Click on Apply to generate the discount
	  driver.findElement(By.cssSelector(".button-wrapper > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
	  
	  //select the Country
	Select dropdown = new Select(driver.findElement(By.id("country")));
	 dropdown.selectByVisibleText("United States");
	 
	 
	 // select The State or region
	 new Select(driver.findElement(By.id("region_id"))).selectByIndex(57);
	 
	 // Enter The ZipCode
	 driver.findElement(By.id("postcode")).clear();

	 driver.findElement(By.id("postcode")).sendKeys("76053");
	 
	 //Apply for the Discount
	//driver.findElement(By.cssSelector(".button-wrapper > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).
	 
	 Thread.sleep(2000);
	 //Click on Estimate
	 driver.findElement(By.cssSelector("div.buttons-set:nth-child(3) > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
	 
	  //Verify if the Discount is generated
	  String Unitprice = driver.findElement(By.cssSelector(".product-cart-price > span:nth-child(1) > span:nth-child(1)")).getText();
	  String Discount = driver.findElement(By.cssSelector("#shopping-cart-totals-table > tbody:nth-child(3) > tr:nth-child(2) > td:nth-child(2) > span:nth-child(1)")).getText();
	  String GrandTotal = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span")).getText();
	  
	  
	  if (Unitprice == GrandTotal ) {
		  
		  System.out.println("Grand Total has changed to" + " " + GrandTotal );
		  
	  }else {
		  
		  System.out.println("The Discount of 5% has not been Applied to Grand Total.");
		  
	
	  }
	  
	 /* try {
		  System.out.println("price =" + price);
		  System.out.println("discount=" + Discount);
	 
		  assertEquals(price, Discount);
	  
	  } catch (Exception e) {
	  e.printStackTrace();
	  }*/
	 
	 //Click on proceed to checkout
	driver.findElement(By.cssSelector(".method-checkout-cart-methods-onepage-bottom > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
	 
	 //*Enter your Email
	driver.findElement(By.cssSelector("#login-email")).clear();
	driver.findElement(By.cssSelector("#login-email")).sendKeys("rufelinusa@yahoo.fr");
	 
	 //Enter your password
	 driver.findElement(By.id("login-password")).sendKeys("rolland@123");
	 
	 //click on login
	driver.findElement(By.cssSelector(".col-2 > div:nth-child(3) > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
	 
	 
	  
	  //Thread.sleep(3000);
	/* driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button/span/span")).click();
     driver.findElement(By.cssSelector("#login-email")).sendKeys("rufelinusayahoo.fr");
     
     driver.findElement(By.cssSelector("#login-password")).sendKeys("rolland@123");
     driver.findElement(By.cssSelector(".col-2 > div:nth-child(3) > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
     */
	
	
     //select the address
     //Select drpdown = new Select(driver.findElement(By.cssSelector("#billing-address-select")));
     //drpdown.selectByVisibleText("Rufelin Rolland Ibara");
     
	//Switch to New Window
	
	for (String handle: driver.getWindowHandles()) {
		driver.switchTo().window(handle);
	}
	
	  //Click on radio button
     
		 // driver.findElement(By.xpath("//*[@id=\"billing:use_for_shipping_no\"]")).click();
		  
		  //Click on Continue
		 // Thread.sleep(2000);
	      //driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button/span/span")).click();
      
	//Ship to New Address
	
	Select NewAddress = new Select(driver.findElement(By.xpath("//*[@id=\"billing-address-select\"]")));
	 NewAddress.selectByVisibleText("New Address");
	 
	 // Enter your First Name
	 driver.findElement(By.id("billing:firstname")).clear();
	 driver.findElement(By.id("billing:firstname")).sendKeys("Arnold");
	 
	 //Enter your MidleName initial
	 driver.findElement(By.name("billing[middlename]")).clear();
	 driver.findElement(By.id("billing:middlename")).sendKeys("R");
	 
	 //Enter your Last Name
	 driver.findElement(By.id("billing:lastname")).clear();
	 driver.findElement(By.name("billing[lastname]")).sendKeys("Dimi");
	 
	 //Enter your City  Address
	 driver.findElement(By.id("billing:street1")).clear();
	 driver.findElement(By.name("billing[street][]")).sendKeys("1500 Sylvan Dr");
	 
	 //Enter your City Name
	 driver.findElement(By.id("billing:city")).clear();
	 driver.findElement(By.name("billing[city]")).sendKeys("Hurst");
	 
	 //Enter your State or Select the State
	 new Select(driver.findElement(By.id("billing:region_id"))).selectByVisibleText("Texas");
	 
	 //Enter your Zipcode
	 driver.findElement(By.name("billing[postcode]")).clear();
	 driver.findElement(By.id("billing:postcode")).sendKeys("76053");
	 
	 //dropdown and Select the States
	 Select dropdown3 = new Select(driver.findElement(By.id("billing:country_id")));
	 dropdown3.selectByVisibleText("United States");
	 
	 //Enter the phone number
	 driver.findElement(By.name("billing[telephone]")).clear();
	 driver.findElement(By.id("billing:telephone")).sendKeys("2406088227");
	 
	 
	 
	 Thread.sleep(2000);
	 
	 //Billing information Click on continue button
	 driver.findElement(By.cssSelector("#billing-buttons-container > button:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
	 
	 Select dropdown4 = new Select(driver.findElement(By.id("shipping-address-select")));
	 dropdown4.selectByVisibleText("Rufelin Rolland Ibara, 121 Willowdale dr, Hurst, Alabama 21702, United States");
	 
	 Thread.sleep(2000);
	 //Shipping information Click on continue
	 driver.findElement(By.cssSelector("#shipping-buttons-container > button:nth-child(2) > span:nth-child(1) > span:nth-child(1)")).click();
	 
	 Thread.sleep(2000);
	 // Shipping Method Click on continue button
	 driver.findElement(By.cssSelector("#shipping-method-buttons-container > button:nth-child(2) > span:nth-child(1) > span:nth-child(1)")).click();
	 
	 //click on money order
	 driver.findElement(By.cssSelector("#p_method_checkmo")).click();
	 
	 Thread.sleep(2000);
	 //PAYMENT INFORMATION Click on continue button
	 driver.findElement(By.cssSelector("#payment-buttons-container > button:nth-child(2) > span:nth-child(1) > span:nth-child(1)")).click();
	 
	 Thread.sleep(2000);
	 //Click on placed order
	 driver.findElement(By.cssSelector(".btn-checkout > span:nth-child(1) > span:nth-child(1)")).click();
	 
	 
	 
  }
 
  @AfterTest
  public void afterTest() {
  }

}
