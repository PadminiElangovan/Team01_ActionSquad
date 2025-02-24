package pages;

import java.io.IOException;
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
import org.testng.asserts.SoftAssert;

import appHook.Hooks;
import appHook.TestContext;

public class Login_Page {
	
	private TestContext context;
	private WebDriverWait wait;
	WebDriver driver;
	SoftAssert softAssert;
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
    @FindBy(xpath ="//*[@id='main-frame-error']") public WebElement applicationerror;
    @FindBy(css =("img[class='images']")) public WebElement logo;
    @FindBy(xpath=("//*[text()='Please login to LMS application']")) public WebElement LMStext ;
    @FindBy(xpath = "//input[@id='password' or @id='username']")public List<WebElement> textFields;
    @FindBy(xpath=("//*[@id='mat-form-field-label-3']/span[2]"))public WebElement passwrdask;
    @FindBy(xpath=("//*[@id='mat-form-field-label-1']/span[2]")) public WebElement userask;
	
    @FindBy(xpath = "//mat-select") public WebElement dropdown;

    // Locate all dropdown options
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
	 public String applicationerrmsg() {
		    
		     
		        wait.until(ExpectedConditions.visibilityOf(applicationerror));

		        
		        return applicationerror.getText().trim();}
		    
		       
		    
	 
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
	

	
	public String spellcheckerUser() {
	    wait.until(ExpectedConditions.visibilityOf(usernameLabel));
	    
	    String text = usernameLabel.getText().trim();  // Try getting visible text
	    if (text.isEmpty()) {
	        text = usernameLabel.getAttribute("placeholder"); // Try placeholder
	    }
	    if (text.isEmpty()) {
	        text = usernameLabel.getAttribute("value"); // Try input value
	    }

	    System.out.println("Extracted Username Label Text: '" + text + "'");
	    return text;
	}


	public String spellcheckerPassword() {
	    wait.until(ExpectedConditions.visibilityOf(passwordLabel));
	    String text = passwordLabel.getText().trim();
	    System.out.println("Extracted Password Label Text: '" + text + "'");
	    return text.isEmpty() ? passwordLabel.getAttribute("innerText").trim() : text;
	}

	public String spellcheckLoginButton() {
	    wait.until(ExpectedConditions.visibilityOf(LoginBtn));
	    String text = LoginBtn.getText().trim();
	    System.out.println("Extracted Login Button Label Text: '" + text + "'");
	    return text.isEmpty() ? LoginBtn.getAttribute("innerText").trim() : text;
	}

    public boolean islogoDisplayed() {
		return logo.isDisplayed();
		
	 }
    private String LMS_MSg;
    public String LmsContentMsg(){
        
    	return LMS_MSg= LMStext.getText();
    }
    public int CountTextFields(){
       
        return textFields.size();
    }
    
    public String FirstTextField() {
        if (!textFields.isEmpty()) {
            WebElement firstTextField = textFields.get(0);
            String placeholder = firstTextField.getAttribute("ng-reflect-placeholder");
            System.out.println("FIRST TEXT FIELD: " + placeholder);
            return placeholder;
        } else {
            System.out.println("No text fields found!");
            return null;
        }
    }
    public boolean isroleDropdwnPresent() {
    	try {
            return roleDropdwn.isDisplayed(); 
        } catch (NoSuchElementException e) {
            return false; 
        }
}
    
    	public boolean isAsteriskUserDisplayed() {
    	    try {
    	        return userask.isDisplayed(); 
    	    } catch (NoSuchElementException e) {
    	        return false; 
    	        
    	    }
      }
    	public boolean isAsteriskPassDisplayed(){
    		try {
    	        return passwrdask.isDisplayed(); 
    	    } catch (NoSuchElementException e) {
    	        return false; // Returns false if the element is not found
    	        
    	    }
      }
  
  public boolean isloginBtnVisible(){
	  try {
	        return LoginBtn.isDisplayed(); 
	    } catch (NoSuchElementException e) {
	        return false; }
	        
	    }
 
  public boolean isLoginButtonCentered() {
		String loginAlignment = LoginBtn.getCssValue("text-align");
		String margin = LoginBtn.getCssValue("margin");
		if (!loginAlignment.equals("center") || !margin.equals("auto")) {
			return false;
		}
		return true;
	}
  
  public boolean isUserTxtGray() {
		String textColor = Username.getCssValue("color");
		// Check if the text color is gray (hex code #808080 or RGB value 128,128,128).
		return textColor.equals("rgb(128, 128, 128)") || textColor.equals("#808080");
	}

	public boolean isPwdTxtGray() {
		String textColor = Password.getCssValue("color");
		
		return textColor.equals("rgb(128, 128, 128)") || textColor.equals("#808080");
	}

	public boolean areInputFieldsCenter() {
		for (WebElement inputField : textFields) {
			String textAlignment = inputField.getCssValue("text-align");
			String margin = inputField.getCssValue("margin");

			// Check if text-align is center and margin is auto.
			if (!textAlignment.equals("center") || !margin.equals("auto")) {
				return false;
			}
		}

		return true;
	}

	public List<String> getDropdownOptionsVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait and click the dropdown
        wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();

        // Wait for options to be visible
        wait.until(ExpectedConditions.visibilityOfAllElements(allOptions));

       
        List<String> optionsText = new ArrayList<>();
        for (WebElement option : allOptions) {
            optionsText.add(option.getText().trim());
        }

        System.out.println("Actual Dropdown Options: " + optionsText); 
        return optionsText;
    }
	public Map<String, String> validLogin(String credentials) {
	    Map<String, String> result = new HashMap<>();
	   // List<Map<String, String>> Login = reader.ReadExcelFile("Login");

	    if (Login == null || Login.isEmpty()) {
	        System.out.println("ERROR: Excel data is missing!");
	        result.put("actualMessage", "Excel data not found");
	        return result;
	    }

	    String user = "";
	    String password = "";

	    // **Safely extract values from Excel (prevent NullPointerException)**
	    switch (credentials.trim()) {  
	        case "valid":
	            System.out.println("Entering valid credentials");
	            user = Login.get(0).getOrDefault("username", "").trim();
	            password = Login.get(0).getOrDefault("password", "").trim();
	            break;
	        case "invalid":
	            System.out.println("Entering invalid credentials");
	            user = Login.get(1).getOrDefault("username", "").trim();
	            password = Login.get(1).getOrDefault("password", "").trim();
	            break;
	        case "invalidpassword":
	            System.out.println("Entering only the password");
	            password = Login.get(2).getOrDefault("password", "").trim();
	            break;
	        case "invalidusername":
	            System.out.println("Entering only the username");
	            user = Login.get(3).getOrDefault("username", "").trim();
	            break;
	        default:
	            System.out.println("Invalid scenario: " + credentials);
	            result.put("actualMessage", "Invalid test case input");
	            return result;
	    }

	    // **Handle empty username & password cases**
	    if (user.isEmpty() && password.isEmpty()) {
	        System.out.println("Username and Password both are missing!");
	        result.put("actualMessage", "Invalid test case input");
	        return result;
	    }

	    // **Enter username if available**
	    if (!user.isEmpty()) {
	        wait.until(ExpectedConditions.visibilityOf(Username)).clear();
	        Username.sendKeys(user);
	    }

	    // **Enter password if available**
	    if (!password.isEmpty()) {
	        wait.until(ExpectedConditions.visibilityOf(Password)).clear();
	        Password.sendKeys(password);
	    }

	    // **Click role selection & login button**
	    wait.until(ExpectedConditions.elementToBeClickable(roleDropdwn)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(AdminRole)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(LoginBtn)).click();

	    // **Get the expected validation message**
	    result.put("actualMessage", getValidationMessage(credentials));
	    return result;
	}

	// **Fetching expected validation message from Excel**
	public String getValidationMessage(String credentials) {
	   // List<Map<String, String>> Login = reader.ReadExcelFile("Login");

	    switch (credentials.trim()) {  
	        case "valid":
	            return ""; // No message expected on successful login
	        case "invalid":
	            return Login.get(1).getOrDefault("message", "Unknown validation message").trim();
	        case "invalidpassword":
	            return Login.get(2).getOrDefault("message", "Unknown validation message").trim();
	        case "invalidusername":
	            return Login.get(3).getOrDefault("message", "Unknown validation message").trim();
	        default:
	            return "Unknown validation message";
	    }
	}

	public void clickLoginButtonMouse() {
		actions.moveToElement(Username).sendKeys(Login.get(0).get("username"));
		actions.moveToElement(Password).sendKeys(Login.get(0).get("password"));
		 
		actions.moveToElement(roleDropdwn).click().perform(); // Click dropdown
	    actions.moveToElement(AdminRole).click().perform(); 
		actions.moveToElement(LoginBtn).click().perform();
		
	}

	public void pressEnterKey() {
		Username.sendKeys(Login.get(0).get("username"));
		 Password.sendKeys(Login.get(0).get("password"));
		 roleDropdwn.click();
		 AdminRole.click();
	    LoginBtn.sendKeys(Keys.ENTER); 
	}

	public String verifyPasswordTxt() {
		return Password.getAttribute("value");
	}

	public String verifyUserTxt() {
		return Username.getAttribute("value");
	}

	public int getHttpResponseCode(String applicationURL) {
		//public int getHttpResponseCode(String link) {
	        try {
	            URL url = new URL(applicationURL);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");
	            connection.connect();
	            return connection.getResponseCode();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return -1; 
	        }
	    }
	}


