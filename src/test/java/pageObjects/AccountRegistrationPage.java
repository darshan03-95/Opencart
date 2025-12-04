package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']") WebElement txt_FirstName;
	@FindBy(xpath="//input[@name='lastname']") WebElement txt_LastName;
	@FindBy(xpath="//input[@name='email']") WebElement txt_Email;
	@FindBy(xpath="//input[@name='telephone']") WebElement Telephone;
	@FindBy(xpath="//input[@name='password']") WebElement Password;
	@FindBy(xpath="//input[@name='confirm']") WebElement Confirm_Password;
	@FindBy(xpath="//input[@name='agree']") WebElement Select_Checkbox;
	@FindBy(xpath="//input[@value='Continue']") WebElement ContinueButton;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement Confirmation_Message;

	public void addFirstName(String firstname)
	{
		txt_FirstName.sendKeys(firstname);
	}
	
	public void addLastName(String lastname)
	{
		txt_LastName.sendKeys(lastname);
	}
	
	public void addEmail(String email)
	{
		txt_Email.sendKeys(email);
	}
	
	public void addTelephone(String telephone)
	{
		Telephone.sendKeys(telephone);
	}
	
	public void addPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	
	public void addConfirmPassword(String pwd)
	{
		Confirm_Password.sendKeys(pwd);
	}
	
	public void SelectCheckbox()
	{
		Select_Checkbox.click();
	}
	
	public void clkcontinuebtn()
	{
		ContinueButton.click();
	}
	
	public String getConfirmationMessage()
	{
		Confirmation_Message.getText();
		return(Confirmation_Message.getText());
	}
	
	

}
