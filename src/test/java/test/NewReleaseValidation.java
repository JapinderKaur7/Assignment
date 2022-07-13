package test;

import org.testng.annotations.Test;

import pom.NavigateActions;

import org.testng.annotations.BeforeClass;

import org.testng.Assert;


@Test(priority = 4)
public class NewReleaseValidation extends Launch {
	NavigateActions actions;
 
  @BeforeClass
  public void beforeClass() {
	  actions= new NavigateActions(driver);
	  
  }
  @Test(priority = 4)
  
  	public void ValidateNewReleases()
  	{
  		Assert.assertTrue(actions.NewReleases.isDisplayed(), "New Releases is not on the page");
  		actions.NewReleases();
  		String expectedURL=  "https://www.amazon.ca/gp/new-releases/?ref_=nav_cs_newreleases";
  		String actualURL= driver.getCurrentUrl();
  		Assert.assertTrue(expectedURL.contains(actualURL), "This is not New Releases Page");
  		driver.navigate().back();
  	}


}
