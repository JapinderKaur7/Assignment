package test;

import org.testng.annotations.Test;

import pom.AccountsAndList;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class ValidateNavigation extends Launch{
	AccountsAndList accnts;
	
  @Test
  public void f() {
  }
  @BeforeClass
  
  
  public void beforeClass() {
	  accnts= new AccountsAndList(driver);
  }
  @Test
  
  
  public void getText()
  {
	  String ele= accnts.AccountsList.getText();
	  System.out.println(ele);
	  String ele2= accnts.container.getAttribute("class");
	  System.out.println(ele2);
  }

@AfterClass
  public void afterClass() {
	  

  }

}
