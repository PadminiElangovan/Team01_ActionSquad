package pages;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import appHook.Hooks;
import appHook.TestContext;

public class Login_Page {
	
	private TestContext context;
	private WebDriverWait wait;
	WebDriver driver;
	SoftAssert softAssert;
	List<Map<String, String>> Login = Hooks.Login;
	
	
	@FindBy(xpath = "//input[@id='username']") public WebElement Username;
	@FindBy(xpath = "//input[@id='password']") public WebElement Password;
	@FindBy(xpath = "//div[@id='mat-select-value-1']") public WebElement roleDropdwn;
	@FindBy(xpath = "//span[text()=' Admin ']") public WebElement AdminRole;
	@FindBy(xpath = "//span[text()=' Staff ']") public WebElement StaffRole;
	@FindBy(xpath = "//span[text()=' Student ']") public WebElement StudentRole;
	@FindBy(xpath = "//button[@id='login']") public WebElement LoginBtn;
	@FindBy(tagName = "mat-error") public List<WebElement> ErrMsg;
	@FindBy(partialLinkText = "Forgot") public List<WebElement> ForgotPswd;
		
	
	 public Login_Page(WebDriver driver,TestContext context){
	    	this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        this.context = context;
	        PageFactory.initElements(driver, this);
	    }
	 
	 public void AdminLogin() {		 		 
		 Username.sendKeys(Login.get(0).get("username"));
		 Password.sendKeys(Login.get(0).get("password"));
		 roleDropdwn.click();
		 AdminRole.click();
		 LoginBtn.click(); 
	 }
	 public void UsrPswd() {
		 Username.sendKeys(Login.get(0).get("username"));
		 Password.sendKeys(Login.get(0).get("password"));
		 LoginBtn.click(); 
	 }
	 public void InputCred() {
		 Username.sendKeys(Login.get(0).get("username"));
		 Password.sendKeys(Login.get(0).get("password"));
	 }
	 public boolean errmsg() {	  
		 boolean status = ErrMsg.isEmpty();
		 return status;
	}
	public void AdminRoleStaff() throws InterruptedException {		 		 
		 Username.sendKeys(Login.get(0).get("username"));
		 Password.sendKeys(Login.get(0).get("password"));
		 roleDropdwn.click();
		 StaffRole.click();
		 LoginBtn.click(); 
	 }
	public void AdminRoleStudent() {		 		 
		 Username.sendKeys(Login.get(0).get("username"));
		 Password.sendKeys(Login.get(0).get("password"));
		 roleDropdwn.click();
		 StudentRole.click();
		 LoginBtn.click(); 
	 }
	

}
