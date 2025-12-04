package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLoginPage extends BasePage {
	
	public AccountLoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='email']") WebElement txt_email;
	@FindBy(xpath="//input[@name='password']") WebElement txt_password;
	@FindBy(xpath="//input[@type='submit']") WebElement Login_Button;
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement Confirmation_Msg;
	
	public void addEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void addPassword(String password) 
	{
		txt_password.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		Login_Button.click();
	}
	
	public void getConfirmationMessage()
	{
		Confirmation_Msg.getText();
	}

}
