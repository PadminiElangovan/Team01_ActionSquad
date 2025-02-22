package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import appHook.TestContext;

public class Logout_Page {
	WebDriver driver;
	private TestContext context;
	private WebDriverWait wait;
	@FindBy(xpath = "//button[@id ='logout']") public WebElement logoutButton;
	@FindBy(id = "error_message") public WebElement errorMessage;

		public Logout_Page(WebDriver driver,TestContext context) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        this.context = context;
	        PageFactory.initElements(driver, this);
	}
		
		  
	    
	    public  void clickLogout() {
	       	logoutButton.click();
				}
	    public  boolean isErrorMessageDisplayed() {
	        return errorMessage.isDisplayed();
	    }
	    public  boolean IsAlertPresent() {
	    	
	    if (IsAlertPresent())
	    	return true;
	    else
	    	return false;
	    }

}
