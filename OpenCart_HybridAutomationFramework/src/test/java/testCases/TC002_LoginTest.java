package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAcocuntPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups= {"Sanity", "Master"})
	public void loginTest() {
		logger.info("***** Starting login test : TC002_LoginTest*****");
		
		try {
			
			// home page 
			HomePage home = new HomePage(driver);
			home.clickMyAccount();
			home.clickLogin();
			
			// login page
			LoginPage loginpage = new LoginPage(driver);
			loginpage.setEmail("abc@gmail.com");
			loginpage.setPassword("pwd");
			loginpage.clickLogin();
			
			// my account 
			MyAcocuntPage myaccount  = new MyAcocuntPage(driver);
			boolean targetpage = myaccount.isMyAccountExist(); // true or false
			
			Assert.assertTrue(targetpage);
			
			
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("******** Test case finished ***********");
	}
	
}
