//1-Get the URL http:demo.guru99.com/test/newtours/index.php
//2-Maximize the page
//3-Expected Page Title is "Mercury Tours"
//4-Verify if the Actual Title is the same as the expected Title
//5-Click on Register Navigation Tab 
//6-on the dropdown menu select the Country ANGOLA
//7-Next Select Country ARUBA
//8-Click Back on Menu Navigation tab



package com.mobilestore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ResgisterTest {
	
	public String url = "http://demo.guru99.com/test/newtours/index.php";
	public WebDriver driver;
	
  @Test
  public void TestRegisterpage() throws InterruptedException {
	 
	  
	  //Lannch Chromedriver
	  System.setProperty("webdriver.chrome.driver","C:\\MyChromedriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	
	  //  Maximize the page to have full size
	  driver.navigate().to(url);
	  driver.manage().window().maximize();
	  
	  String ExpectedTitle = "Welcome: Mercury Tours";
	  String ActualTitle = driver.getTitle();
	  
	  Assert.assertEquals(ActualTitle, ExpectedTitle);
	  driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
	  
	  Select Country = new Select(driver.findElement(By.name("country")));
	  Country.selectByVisibleText("ANGOLA");
	  Thread.sleep(4000);
	  Country.selectByValue("ARUBA");
	  
	 driver.navigate().back();
	 Thread.sleep(3000);
	// driver.close();
	  
	  //driver.findElement(By.name("country")).click();
	  
	  
	  
	  
  }
}
