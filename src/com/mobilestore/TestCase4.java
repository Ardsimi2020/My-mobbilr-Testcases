package com.mobilestore;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TestCase4 {
 
  public String url = "http://live.demoguru99.com";
  public WebDriver driver;
  public String pathdriver = "C:\\ChromeDriver\\chromedriver.exe";
  public String firstName = "rufelin"; 
  public String LastName = "dimi";
  public String Email = "usa@gmail.com";
  public String Password = "rolland@123";
  
  
	 @BeforeTest
	  public void beforeTest() {
      System.setProperty("webdriver.chrome.driver",pathdriver);
	  driver = new ChromeDriver();
		 
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		
	  }
	 
	 @Test
  public void testTestCase4() throws Exception {
	driver.navigate().to(url);
	driver.manage().window().maximize();
	
	//2.Click on my Account link
	driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
	
	Thread.sleep(3000);
	
	for (String handle : driver.getWindowHandles()) {
		driver.switchTo().window(handle);
	}
	
	// 3.login in application using previous created credential
	driver.findElement(By.id("email")).sendKeys("usa@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("rolland@123");
	driver.findElement(By.xpath("//*[@id=\"send2\"]/span/span")).click();
	
	//4.Click on my Wishlist
	driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"wishlist-view-form\"]/div/div/button[2]")).click();
	Thread.sleep(3000);
	
	Select drpdown = new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
	drpdown.selectByVisibleText("United States");
	
	new Select(driver.findElement(By.xpath("//*[@id=\"region_id\"]"))).selectByVisibleText("Texas");
	driver.findElement(By.id("postcode")).sendKeys("76053");
	Thread.sleep(3000);
	
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
	driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]/div/button")).click();
	
	//10..Verify Shipping Cost is added to total
	String VflatRatePrice = "$5.00";
	String shippingCostIncluded = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[2]/td[2]/span")).getText();
	
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
	driver.findElement(By.xpath("//*[@id=\"billing:company\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"billing:company\"]")).sendKeys("n/a");
	
	//12.Billing Information
	driver.findElement(By.xpath("//*[@id=\"billing:street1\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"billing:street1\"]")).sendKeys("1600 sylvan Dr");
	
	//Enter the Second Address
	driver.findElement(By.xpath("//*[@id=\"billing:street2\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"billing:street2\"]")).sendKeys("None");
	//Enter the City
	driver.findElement(By.xpath("//*[@id=\"billing:city\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"billing:city\"]")).sendKeys("hurst");
	
	//Select State
	new Select(driver.findElement(By.xpath("//*[@id=\"billing:region_id\"]"))).selectByVisibleText("Texas");
	
	//enter The zipcode
	driver.findElement(By.xpath("//*[@id=\"billing:postcode\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"billing:postcode\"]")).sendKeys("75053");
	
	//select Country
	Thread.sleep(2000);
	new Select(driver.findElement(By.xpath("//*[@id=\"billing:country_id\"]"))).selectByVisibleText("United States");
	
	//Enter The Telephone Number
	driver.findElement(By.xpath("//*[@id=\"billing:telephone\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"billing:telephone\"]")).sendKeys("240-608-8227");
	
	//Enter The Fax Number
	driver.findElement(By.xpath("//*[@id=\"billing:fax\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"billing:fax\"]")).sendKeys("None");
	
	driver.findElement(By.xpath("//*[@id=\"billing:use_for_shipping_no\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"billing:use_for_shipping_no\"]")).click();
	
	Thread.sleep(4000);
	driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button/span/span")).click();
	
	
	
		
		 
}
	 
  @AfterTest
  public void afterTest() {
	  
  }

}
