package com.mobilestore;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class TestCase4A {
  
  public String url = "http://live.demoguru99.com";
  public WebDriver driver;
  public String pathdriver = "C:\\Myfirefoxdriver\\geckodriver.exe";
  public String firstName = "Arnold"; 
  public String LastName = "Dimi";
  public String Email = "rufelinusa@yahoo.fr";
  public String Password = "rolland@123";
  
  
	 @BeforeTest
	  public void beforeTest() {
      System.setProperty("webdriver.gecko.driver",pathdriver);
	  driver = new FirefoxDriver();
	  
		 
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		
	  }
	 
	 @Test
  public void testTestCase4() throws Exception {
	driver.navigate().to(url);
	driver.manage().window().maximize();
	
	//2.Click on my Account link
	driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
	
	Thread.sleep(3000);
	// 3.login in application using previous created credential
	driver.findElement(By.id("email")).sendKeys("rufelinusa@yahoo.fr");
	driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("rolland@123");
	driver.findElement(By.xpath("//*[@id=\"send2\"]/span/span")).click();
	
	//4.Click on my Wishlist
	driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
	driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/table/tbody/tr/td[5]/div/button")).click();
	Thread.sleep(3000);
	
	
	
	
	Select drpdown = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
	drpdown.selectByVisibleText("United States");
	//Thread.sleep(2000);
	//Enter The City Name
	//driver.findElement(By.id("shipping:city")).sendKeys("Hurst");
	
	new Select(driver.findElement(By.xpath("//*[@id=\"region_id\"]"))).selectByVisibleText("Texas");
	driver.findElement(By.id("postcode")).sendKeys("76053");
	Thread.sleep(6000);
	
	//7.Click on Estimate
	driver.findElement(By.xpath("//*[@id=\"shipping-zip-form\"]/div/button/span/span")).click();
	
	//8.Verify Shipping generated
	String sflatRate = "Flat Rate";
	String Rate = driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]/dl/dt")).getText();
	
	try {
	System.out.println("sflatRate =" + sflatRate);
	System.out.println("Rate ="+Rate);
	
	assertEquals(sflatRate, Rate);
	} catch (Exception e) {
		e.printStackTrace();
	}
	String sflatRatePrice = "Fixed - $5.00";
	String flatRatePrice = driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]/dl/dd/ul/li/label")).getText();
	
	try {
    System.out.println("sFlatRatePrice =" + sflatRatePrice);
    System.out.println("flatRatePrice =" + flatRatePrice);
    assertEquals(sflatRatePrice, flatRatePrice);
    
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	//9.select Shipping Cost if already selected as default Update Total
	driver.findElement(By.xpath("//*[@id=\"s_method_flatrate_flatrate\"]")).click();
	driver.findElement(By.name("do")).click();
	
	//10..Verify Shipping Cost is added to total
	String VflatRatePrice = "$5.00";
	String shippingCostIncluded = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tbody/tr[2]/td[2]/span")).getText();
	
	try {
		System.out.println("VflaratePrice = "+ VflatRatePrice );
		System.out.println("shippingCostIncluded ="+ shippingCostIncluded);
		
		assertEquals(VflatRatePrice, shippingCostIncluded);
	} catch (Exception e) {
		e.printStackTrace();
		 }
	
	//11.Click proceed to Check-out
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[1]/ul/li/button")).click();
		
		//Company Name
		driver.findElement(By.xpath("//*[@id=\"billing:firstname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"billing:firstname\"]")).sendKeys(firstName);
		
		driver.findElement(By.xpath("//*[@id=\"billing:middlename\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"billing:middlename\"]")).sendKeys("Rufelin");

		driver.findElement(By.xpath("//*[@id=\"billing:lastname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"billing:lastname\"]")).sendKeys(LastName);

		driver.findElement(By.cssSelector("#billing\\:company")).clear();

	
		//12.Billing Information
		driver.findElement(By.xpath("//*[@id=\"billing:street1\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"billing:street1\"]")).sendKeys("1600 Sylvan Dr");
		//driver.findElement(By.xpath("//*[@id=\"shipping:street2\"]")).clear();
		
		 
		
		new Select(driver.findElement(By.xpath("//*[@id=\"billing:country_id\"]"))).selectByVisibleText("United States");
		
		
		//Enter the City
		driver.findElement(By.xpath("//*[@id=\"billing:city\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"billing:city\"]")).sendKeys("Hurst");
		
		//Select State
		new Select(driver.findElement(By.xpath("//*[@id=\"billing:region_id\"]"))).selectByVisibleText("Texas");
		
		//enter The ZipCode
		driver.findElement(By.xpath("//*[@id=\'billing:postcode\']")).clear();
		driver.findElement(By.xpath("//*[@id=\'billing:postcode\']")).sendKeys("76053");
		
		//select Country
		Thread.sleep(2000);
		new Select(driver.findElement(By.xpath("//*[@id=\"billing:country_id\"]"))).selectByVisibleText("United States");
		
		//Enter The Telephone Number
		driver.findElement(By.xpath("//*[@id=\"billing:telephone\"]")).clear();
		driver.findElement(By.cssSelector("#billing\\:telephone")).sendKeys("240-608-8227");
		
		//Enter The fax Number
		driver.findElement(By.xpath("//*[@id=\"billing:fax\"]")).clear();
		
		Thread.sleep(3000);
	  //  driver.findElement(By.cssSelector("#billing-buttons-container > button:nth-child(1)")).click();
	    
	    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button/span/span")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[2]/div[2]/form/div/button/span/span")).click();
		
		for ( String handle: driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		
		

//========================================
		//Shipping Address
//========================================
		driver.findElement(By.name("shipping[firstname]")).clear();
		driver.findElement(By.xpath("//*[@id=\"shipping:firstname\"]")).sendKeys("Rufelin");
		
		driver.findElement(By.xpath("//*[@id=\"shipping:middlename\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"shipping:middlename\"]")).sendKeys("Rolland");
		
		driver.findElement(By.xpath("//*[@id=\"shipping:lastname\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"shipping:lastname\"]")).sendKeys("Ibara");
		
		driver.findElement(By.xpath("//*[@id=\"shipping:street2\"]")).clear();
		
		
		driver.findElement(By.xpath("//*[@id=\"shipping:street1\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"shipping:street1\"]")).sendKeys("121 Willowdale dr");
		
		driver.findElement(By.name("shipping[city]")).clear();
		driver.findElement(By.name("shipping[city]")).sendKeys("Hurst");
		
		
		driver.findElement(By.name("shipping[region_id]")).sendKeys("Texas");
		
		driver.findElement(By.xpath("//*[@id=\"shipping:postcode\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"shipping:postcode\"]")).sendKeys("21702");
		Thread.sleep(2000);
		
		// Dropdown to Select The Country
		new Select(driver.findElement(By.xpath("//*[@id=\"shipping:country_id\"]"))).selectByVisibleText("United States");
		
	   //Enter the telephone Number
		driver.findElement(By.xpath("//*[@id=\"shipping:telephone\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"shipping:telephone\"]")).sendKeys("240-608-3243");
		
		//Fax Number
		driver.findElement(By.xpath("//*[@id=\"shipping:fax\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"shipping:fax\"]")).sendKeys("240-608-3242");
		
		Thread.sleep(2000);
		// Click on continue Button
		driver.findElement(By.cssSelector("#shipping-buttons-container > button:nth-child(2) > span:nth-child(1) > span:nth-child(1)")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[3]/div[2]/form/div[3]/button/span/span")).click();
		driver.findElement(By.id("p_method_checkmo")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/div[2]/button/span/span")).click();
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[5]/div[2]/div/div[2]/div/button")).click();
		
		
		
			 
	 } 
  @AfterTest
  public void afterTest() {
  }

}
