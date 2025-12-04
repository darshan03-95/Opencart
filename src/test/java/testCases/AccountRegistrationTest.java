package testCases;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.core.config.Loggers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups= {"Regression","Master"})
	public void testRegister() throws InterruptedException
	{
		logger.info("***** starting AccountRegistrationTest ******");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		logger.info("****** accountregistration page started******");
		AccountRegistrationPage arp = new  AccountRegistrationPage(driver);
		arp.addFirstName(randomstring().toUpperCase());
		arp.addLastName(randomstring().toUpperCase());
		arp.addEmail(randomstring() +"@gmail.com");
		arp.addTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		arp.addPassword(password);
		arp.addConfirmPassword(password);
		
		logger.info("********sekect the checkbox****************");
		arp.SelectCheckbox();
		arp.clkcontinuebtn();
		String confmsg=arp.getConfirmationMessage();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			logger.info("*********test finished***********");
		}
		else
		{
			logger.error("error logs");
			//logger.debug("debug logs");
			Assert.assertTrue(false);
		}
		
		
	}
	
}
