package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups= {"Regression", "Master"})
	public void verify_account_registration() throws InterruptedException {
		
		try {
		logger.info("*******Starting Test-TC001_AccountRegistrationTest ********** ");
		
		HomePage homepage = new HomePage(driver);	
		homepage.clickMyAccount();
		logger.info("Cicked on my account");
		Thread.sleep(3000);
		logger.info("Cicked on Register");
		homepage.clickRegister();
		
		AccountRegistrationPage acpage = new AccountRegistrationPage(driver);
		logger.info("Providing user details...");
		acpage.setFirstname(randomString().toUpperCase());
		acpage.setLastname(randomString().toUpperCase());
		acpage.setEmail(randomString() + "@gmail.com");
		acpage.setPassword(randomString());
		acpage.setSubscribe();
		acpage.setAgree();
		acpage.setContinueButton();
		logger.info("validating account success message....");
		String message = acpage.getMsgConfirmation();
		Assert.assertEquals(message,"Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.info("Test Failed..");
			logger.debug("debug test..");
			Assert.fail();
		}
	}
	 

}
