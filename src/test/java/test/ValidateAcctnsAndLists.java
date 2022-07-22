package test;

import org.testng.annotations.Test;

import pom.NavigateActions;

import org.testng.annotations.BeforeTest;

import org.testng.Assert;


public class ValidateAcctnsAndLists extends Launch{
	NavigateActions accnts;
	
  @BeforeTest
 public void beforeClass() {
	accnts= new NavigateActions(driver);
  }
  @Test  
  public void ValidateAccountsAndLists() throws InterruptedException
  {
	  Assert.assertTrue(accnts.AccountsList.isDisplayed(), "Accounts and Lists is not available on Page");
	  Assert.assertTrue(accnts.AccountsList.getText().contains("Account & Lists"),"Not Correct Link");
	  accnts.NavigateToAccountsActions();
  }

@Test (dependsOnMethods = {"ValidateAccountsAndLists"})
  public void ValidationCreateWishList() throws InterruptedException
  {
	  accnts.CreateWishList();
	  String expectedTitle= "Wish List";
	  String actualTitle= driver.getTitle();
	  Assert.assertTrue(expectedTitle.contains(actualTitle), "This is not 'create a wishlist' page..");
	  driver.navigate().back();
  }
 
}
