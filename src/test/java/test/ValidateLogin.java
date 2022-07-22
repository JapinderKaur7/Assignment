package test;

import org.testng.annotations.Test;

import pom.LoginAction;
import pom.NavigateActions;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class ValidateLogin extends Launch{
	LoginAction login;
	NavigateActions actns;

  @BeforeClass  
  public void beforeClass() {
	  login= new LoginAction(driver);
  }
  @Test
  public void ValidSignIn() throws InterruptedException
  {
	  login.SignIn();

  }
  
  @Parameters({"validemail"})
 @Test (dependsOnMethods = {"ValidSignIn"})
  public void validLogin(String emailSend)
  {
	//  Assert.assertTrue(login.continuebutton.isEnabled(), "Sign In is not enabled");
	  login.SendEmail(emailSend);
	  driver.get("https://www.amazon.ca/");
	 // driver.navigate().back();
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }


}
