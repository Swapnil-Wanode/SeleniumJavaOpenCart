package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testclass {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/en-gb?route=common/home");
		driver.manage().window().maximize();
		
//		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
//		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		// Explicit wait setup
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Click on 'My Account'
        WebElement myAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='My Account']")));
        myAccount.click();

        // Click on 'Register'
        WebElement registerLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Register']")));
        registerLink.click();
	
	}
}
