package test;

import org.testng.annotations.Test;

import Base.DriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class LandingValidations extends Launch{
	
	//WebDriver driver;
 
	/*
	 * @BeforeClass
	 * 
	 * public void beforeClass() { driver=DriverManager.getDriver(); }
	 */
 @Test 
  public void validateTitle()
  {
	  String expectedTitle="Amazon.ca: Low Prices – Fast Shipping – Millions of Items";
	  String actualTitle= driver.getTitle();
	  
	  Assert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle), "This is not the actual title");
	  
  }
  @Test

  public void validateUrl()
  {
	  String expectedUrl="https://www.amazon.ca/";
	  String actualUrl= driver.getCurrentUrl();
	  
	  Assert.assertTrue(expectedUrl.equalsIgnoreCase(actualUrl), "This is not the actual Url");
	  
  }

}
