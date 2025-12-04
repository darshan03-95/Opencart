package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	// constructor
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	// locators
	@FindBy(xpath="//a[@title='My Account']") WebElement lnkMyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkRegister;
	@FindBy(xpath="//a[@href='http://localhost/Opencartsite/index.php?route=account/login']") WebElement lnkLogin;
	
	// action methods
	
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	public void clickRegister()
	{
		lnkRegister.click();
	}
	public void ClickLogin()
	{
		lnkLogin.click();	}
	
}
