package test;

import org.testng.annotations.Test;

import pom.LoginAction;
import pom.NavigateActions;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@Test (priority = 2)
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
  
  
 @Test (dependsOnMethods = {"ValidSignIn"})
@Parameters({"validemail"})

  public void validLogin(String emailSend)
  {
	//  Assert.assertTrue(login.continuebutton.isEnabled(), "Sign In is not enabled");
	  login.SendEmail(emailSend);
	  driver.navigate().back();
  }


}
