package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Commonmethods;

public class SearchForMobile{
	private WebDriver driver;
	Commonmethods common= new Commonmethods(driver);
	
	public SearchForMobile(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
@CacheLookup
@FindBy(id="twotabsearchtextbox")
public WebElement searchBox;

@CacheLookup
@FindBy(id="nav-search-submit-button")
public WebElement submitButton;

@CacheLookup
@FindBy(xpath="(//div[@class='sg-col-inner'])[1]")
public WebElement SearhResult;

@CacheLookup
@FindBy(xpath="//span[contains(text(),'Samsung Galaxy S10 128GB+8GB RAM Prism Black - For GSM Network - Unlocked (Renewed)')]")
public WebElement mobileSelection;

@CacheLookup
@FindBy(xpath="(//span[contains(text(),'$314.96')])[1]")
public WebElement mobilePrice;

@CacheLookup
@FindBy(xpath="//div[contains(text(),'Select delivery location')]")
public WebElement DeliveryLocation;

@CacheLookup
@FindBy(id="GLUXZipUpdateInput_0")
public WebElement firstThreeDigitPinCode;

@CacheLookup
@FindBy(id="GLUXZipUpdateInput_1")
public WebElement LastThreeDigitPinCode;


@CacheLookup
@FindBy(xpath="//span[@class='a-button a-button-span12']")   ////div[@role='button']
public WebElement ApplyButton;


@CacheLookup
@FindBy(id="ape_Detail_hero-quick-promo_Desktop_iframe")
public WebElement thatframe;

@CacheLookup
@FindBy(tagName="iframe")
public List<WebElement> AllFrames;

@CacheLookup
@FindBy(xpath="//div[@data-testid='dealBadgeFixed']")      //("//div[@data-testid='dealBadgeFixed']")
public WebElement frameLink;

@CacheLookup
@FindBy(id="add-to-cart-button")
public WebElement AddtoCart;

@CacheLookup
@FindBy(xpath="//span[contains(text(),'Added to Cart')]")
public WebElement AddedToCartMessage;

@CacheLookup
@FindBy(xpath="(//input[@class='a-button-input'])[1]")
public WebElement ProceedToCheckoutButton;

	public void enterSearchMobile()
	{
		Actions act= new Actions(driver);
		act.moveToElement(searchBox).sendKeys("samsung galaxy s10");
	}

	
	public void selectMobile() throws InterruptedException
	{
//		Actions act= new Actions(driver);
//		act.moveToElement(mobileSelection);
		mobileSelection.click();
		
	}
	
	public void DeliveryLocationofMobile()
	{
		DeliveryLocation.click();
		firstThreeDigitPinCode.sendKeys("l8e");
		LastThreeDigitPinCode.sendKeys("5e7");
		ApplyButton.click();
	}
	
	public void clickFrame()
	{
		List<WebElement> frames=  AllFrames;   //list of frames
	
	//Switch to frame to perform function
	for (WebElement webElement: frames)  
	{
		String str= webElement.getAttribute("id");   //get the id of all frames
		System.out.println(str);
		String ele=  thatframe.getText();
		if(str.contains(ele))   //if id is ele
		{
			driver.switchTo().frame(str);   // switch to iframeResult
			frameLink.click();
			break;
		}
		
	}
	}
	public void AddToCartButton()
	{
		AddtoCart.click();
	}
	public void ProceedToCheckout()
	{
		ProceedToCheckoutButton.click();
	}
	}
