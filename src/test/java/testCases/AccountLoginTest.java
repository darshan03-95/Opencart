package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class AccountLoginTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void TestLogin()
	{
		try 
		{
		logger.info("***********TC02LoginTeststarts**************");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.ClickLogin();
		
		AccountLoginPage alp= new AccountLoginPage(driver);
		alp.addEmail(p.getProperty("email"));
		alp.addPassword(p.getProperty("password"));
		alp.clickLoginButton();
		alp.getConfirmationMessage();
		
		
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("************** TC02 LoginTest End**************");
	}

}
