package pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import appHook.Hooks;
import appHook.TestContext;

public class Login_Page {
	
	private TestContext context;
	private WebDriverWait wait;
	static WebDriver driver;
	Actions actions;
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
	
	@FindBy(xpath = "//label[@for='username']/span[1]")public WebElement usernameLabel;
    @FindBy(xpath ="//label[@for='password']/span[1]")public WebElement passwordLabel;
    @FindBy(xpath ="//div[@class='message']") public WebElement applicationerror;
    @FindBy(css =("img[class='images']")) public WebElement logo;
    @FindBy(xpath=("//mat-card//p")) public WebElement LMStext ;
    @FindBy(xpath = "//input[@id='password' or @id='username']")public List<WebElement> InputFields;
    @FindBy(xpath=("//mat-form-field[2]//label/span[2]"))public WebElement passwrdask;
    @FindBy(xpath=("//mat-form-field[1]//label/span[2]")) public WebElement userask;
    @FindBy(xpath=("//mat-card-content/form")) public WebElement form;
	
    @FindBy(xpath = "//mat-select") public WebElement dropdown;
    @FindBy(css = "mat-option") public List<WebElement> allOptions;
    
	 public Login_Page(WebDriver driver,TestContext context){
	    	this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        this.context = context;
	        this.actions = new Actions(driver);
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
		    
	public void AdminRoleStaff() {		 		 
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
	
	 public void LoginMouseAction() {		 
		 	actions.moveToElement(Username).click().sendKeys(Login.get(0).get("username")).perform();;
			actions.moveToElement(Password).click().sendKeys(Login.get(0).get("password")).perform();;			 
			actions.moveToElement(roleDropdwn).click().perform(); 
		    actions.moveToElement(AdminRole).click().perform(); 
			actions.moveToElement(LoginBtn).click().perform();
		}
	 
	 public void LoginKeyAction() {
		 	actions.moveToElement(Username).click().sendKeys(Login.get(0).get("username")).perform();
		 	actions.sendKeys(Keys.TAB).sendKeys(Login.get(0).get("password")).perform();	
		 	actions.sendKeys(Keys.TAB).perform();
		 	actions.sendKeys(Keys.ARROW_DOWN).click().perform();;
		    actions.sendKeys(Keys.ENTER).perform();		
		}
	 
	 public void Inputs(String Cred) {		 
		 if(Cred.equals("valid")) {
			 Username.sendKeys(Login.get(0).get("username"));
			 Password.sendKeys(Login.get(0).get("password"));}
		 else if(Cred.equals("invalid")) {
			 Username.sendKeys(Login.get(1).get("username"));
			 Password.sendKeys(Login.get(1).get("password"));}
		 else if(Cred.equals("Emptyusername")) 
			 Password.sendKeys(Login.get(2).get("password"));
		 else if(Cred.equals("Emptypassword")) 
			 Username.sendKeys(Login.get(3).get("username"));
		 roleDropdwn.click();
		 AdminRole.click();
		 LoginBtn.click();		 
	}
	 
	 public int StatusCode() {
			try {				
				URL url = new URL(driver.getCurrentUrl());
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				int responseCode = connection.getResponseCode();
				return responseCode;
			} catch (Exception e) {
				return 0;}
		}	
	 
}
