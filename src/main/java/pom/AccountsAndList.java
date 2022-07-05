package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.DriverManager;
import utilities.Commonmethods;

public class AccountsAndList {
	
	WebDriver driver;
    Commonmethods common = new Commonmethods(DriverManager.getDriver());



	public AccountsAndList(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	@CacheLookup
	@FindBy(xpath="//span[contains(text(),'Account & Lists')]")                  //nav-link-accountList
	public WebElement AccountsList;
	
	@CacheLookup
	@FindBy(xpath="//div[@id='nav-al-wishlist']")
	public WebElement container;
	
	
	public void NavigateToActions()
	{
		
		Actions act= new Actions(driver);
		act.moveToElement(AccountsList).build().perform();
		common.higlightement(AccountsList);
		
		
		
		
	}

}
