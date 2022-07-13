package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
	public static WebDriver driver;
	
	public void setup(String browser, String url)
	{
		String path= System.getProperty("user.dir");
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",path+"\\Driver\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Automation\\Workspace\\SeleniumProject\\Drivers\\msedgedriver.exe");  //setting property of driver
			driver= new EdgeDriver();  //call chrome Constructor to activate the driver
			//driver.get("https://www.comit.org/");
			}
	
	else
	{
		System.out.println("Pass correct browser parameters "+browser);
	}

	      // driver.get("https://www.walmart.ca/en");
		
		if(url!="")
		{
			driver.get(url);
		}else
		{
			driver.get("about:blank");
		}
		
	
	driver.manage().window().maximize();    //Manage browser properties   .maximize () will maximize the size of windows
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   //request to script to not do any action and wait for max 5 seconds until the HTML is loaded
}
public static WebDriver getDriver()    //synchronise the drivers at one place. Need not to call Webdriver driver all the time.
{
	return driver;
}

public void teardown() {
	driver.quit();
}
	
	

}
