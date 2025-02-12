package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAcocuntPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass{

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class, groups= "datadriven")
	public void loginTest(String email, String password, String status) {
		logger.info("***** Starting login test : TC003_LoginDataDrivenTest *****");
		
		try {
			
			// home page 
			HomePage home = new HomePage(driver);
			home.clickMyAccount();
			home.clickLogin();
			
			// login page
			LoginPage loginpage = new LoginPage(driver);
			loginpage.setEmail(email);
			loginpage.setPassword(password);
			loginpage.clickLogin();
			
			// my account 
			MyAcocuntPage myaccount  = new MyAcocuntPage(driver);
			boolean targetpage = myaccount.isMyAccountExist(); // true or false
			
			if(status.equalsIgnoreCase("valid")) {
				if(targetpage==true) {
					myaccount.clickLogout();
					Assert.assertTrue(true);
				}
				else {
					Assert.assertTrue(false);
				}
			}
			
			if(status.equalsIgnoreCase("invalid")) {
				if(targetpage==true) {
					myaccount.clickLogout();
					Assert.assertTrue(false);
				}
				else {
					Assert.assertTrue(true);
				}
			}
			
			
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("******** Test case finished ***********");
	}
	
	
}
