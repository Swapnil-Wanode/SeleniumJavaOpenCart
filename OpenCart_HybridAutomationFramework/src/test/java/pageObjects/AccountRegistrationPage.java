package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='input-newsletter']")
	WebElement subscribe;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement agree;
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement continueButton;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	public void setFirstname(String fname) {
		firstname.sendKeys(fname);
	}
	public void setLastname(String lname) {
		lastname.sendKeys(lname);
	}
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	public void setSubscribe() {
		subscribe.click();
	}
	public void setAgree() {
		agree.click();
	}
	public void setContinueButton() {
		continueButton.click();
	}
	public String getMsgConfirmation() {
		try {
			return(msgConfirmation.getText());
		} catch (Exception e) {
			return(e.getMessage());
		}
	}
	
	
	

}
