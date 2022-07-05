package test;

import org.testng.annotations.Test;

import Base.DriverManager;
import utilities.readPropertyFile;

import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class Launch {
	WebDriver driver;
	DriverManager dm= new DriverManager();
	readPropertyFile file;
	Properties prop;
	

	
  @Test
  public void f() {
  }
  @BeforeSuite
  public void beforeSuite() throws IOException {
	  file=new readPropertyFile();
	  prop= file.readPropfile();
	  dm.setup(prop.getProperty("browser"),prop.getProperty("url"));
	  driver= DriverManager.getDriver();  

  }

  @AfterSuite
  public void afterSuite() {
	 // dm.teardown();
  }

}
