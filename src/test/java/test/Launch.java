package test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Base.DriverManager;
import utilities.readPropertyFile;

public class Launch {
	static WebDriver driver;
	DriverManager dm= new DriverManager();
	readPropertyFile file;
	Properties prop;
	

	

  @BeforeSuite
  public void beforeSuite() throws IOException {
	  file=new readPropertyFile();
	  prop= file.readPropfile();
	  dm.setup(prop.getProperty("browser"),prop.getProperty("url"));
	  driver= DriverManager.getDriver();  

  }

  @AfterSuite
  public void afterSuite() {
	  dm.teardown();
  }

}
