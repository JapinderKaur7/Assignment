package test;

import org.testng.annotations.Test;

import pom.SearchForMobile;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;

public class ValidateMobileSearch extends Launch {
	SearchForMobile mobile;

  @BeforeClass
  public void beforeClass() {
	  mobile= new SearchForMobile(driver);
  }
  
  @Test (groups= {"Regression"})
  public void ValidationMobileSearch() throws InterruptedException
  {
	  Assert.assertTrue(mobile.searchBox.isEnabled(), "Search box id not enabled");
	  Assert.assertTrue(mobile.searchBox.getAttribute("aria-label").contains("Search"), "Not correct search box");
	  mobile.searchBox.sendKeys("samsung galaxy s10");
	  Thread.sleep(3000);
  }
  @Test (dependsOnMethods = {"ValidationMobileSearch"})
  public void ValidateMobileSearchPage() throws InterruptedException
  {
	  Assert.assertTrue(mobile.submitButton.isDisplayed(), "Search button is not available");
	  Assert.assertTrue(mobile.submitButton.getAttribute("class").contains("nav-input nav-progressive-attribute"), "This is not correct search button");
	  mobile.submitButton.click();
	  Thread.sleep(1000);
	  
	 // String ExpectedResult="1-48 of 307 results for \"samsung galaxy s10\"";
	 // String actualResult= mobile.SearhResult.getText();
	   
	 // Assert.assertTrue(ExpectedResult.contains(actualResult), "This is not the search result page of Samsung galaxy s10");
  }
  
  
  @Test (dependsOnMethods = {"ValidateMobileSearchPage"})
  public void SelectMobile() throws InterruptedException
  {
	  //String expectedResult= "Samsung Galaxy S10 128GB Unlocked - White (Renewed)";
	  //String actualResult=mobile.mobileSelection.getText();
	  //System.out.println(actualResult);
	  //Assert.assertTrue(expectedResult.contains(actualResult), "This is not correct product");
	  mobile.selectMobile();
	  Thread.sleep(1000);
  }
  @Test (dependsOnMethods = {"SelectMobile"}, groups = {"Regression"}) 
  
  public void ValidateMobilePrice()
  {
	  String ExpectedPrice= "$314.96";
	  String actualPrice= mobile.mobilePrice.getText();
	  
	  Assert.assertTrue(ExpectedPrice.contains(actualPrice), "The price of the mobile is not correct");
  }
  
  @Test (dependsOnMethods = {"ValidateMobilePrice"})

  public void ValidateDeliveryLocation()
  {
	  mobile.DeliveryLocationofMobile();
  }
//    @Test (dependsOnMethods = {"ValidateDeliveryLocation"})
//  
//  public void iframeClick()
//  {
//	  mobile.clickFrame();
//  }
//
  @Test (dependsOnMethods = {"ValidateDeliveryLocation"})

  public void AddToCartValidation()
  {
	  mobile.AddToCartButton();
	  String ExpectedMessage="Added to Cart";
	  String actualMessage= mobile.AddedToCartMessage.getText();
	  
	  Assert.assertTrue(ExpectedMessage.contains(actualMessage), "The product is not added to cart");
	  
	  mobile.ProceedToCheckout();
	  
  }

}
