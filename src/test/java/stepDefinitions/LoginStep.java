package stepDefinitions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import appHook.Hooks;
import appHook.TestContext;
import common.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.Dashboard_Page;
import pages.Login_Page;

public class LoginStep extends BasePage{
	private Dashboard_Page Dashboard;
	private Login_Page Login;
	private WebDriver driver;
	private TestContext context;
	List<Map<String, String>> Loginxl = Hooks.Login;
	Map<String, String> result; 
	public LoginStep(TestContext context) {
     this.context = context;
     this.driver = context.getDriver();
     this.Login = new Login_Page(driver, context);
     this.Dashboard = new Dashboard_Page(driver, context); 
 }

	@Given("The browser is open")
	public void the_browser_is_open() {
		 String applicationURL = context.getApplicationURL();
	        driver.get(applicationURL);
	    
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		String applicationURL = context.getApplicationURL();
        driver.get(applicationURL);
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		String applicationInvalidURL = context.getApplicationInvalidURL();
        driver.get(applicationInvalidURL);
	}

	@Then("Admin should receive application error")
	public void admin_should_receive_application_error() {
		String errorMessage = Login.applicationerrmsg();
	    Assert.assertEquals(errorMessage, "Expected error message here");
	}

	@Then("If HTTP response less than or equals {int} then the link is broken")
	public void if_http_response_less_than_or_equals_then_the_link_is_broken(Integer int1) {
		int actualResponseCode = Login.getHttpResponseCode(context.getApplicationURL());
        Assert.assertTrue(actualResponseCode <= int1, "The link is not broken!");
	
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
		
		
		
		String userLabel = Login.spellcheckerUser();
		
		Assert.assertEquals(userLabel, "User");

		String pwdLabel = Login.spellcheckerPassword();
		
		Assert.assertEquals(pwdLabel, "Password");

		String loginLabel = Login.spellcheckLoginButton();
		
		Assert.assertEquals(loginLabel, "Login");

	}

	@Then("Admin should see LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
		Assert.assertEquals(getPageTitle(driver), "LMS");
	}

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
		 Assert.assertTrue(Login.islogoDisplayed());
        //return logo.getLocation().getX();
	}

	@Then("Admin should see Please login to LMS application")
	public void admin_should_see_please_login_to_lms_application() {
		 
		 Assert.assertEquals(Login.LmsContentMsg(), "Please login to LMS application");
    }
	

	@Then("Admin should see two text fields")
	public void admin_should_see_two_text_fields() {
		 int count= Login.CountTextFields();
	        Assert.assertEquals(2,count);
	}

	@Then("Admin should see User in the first text field")
	public void admin_should_see_user_in_the_first_text_field() {
		String actualText = Login.verifyUserTxt();
		
			Assert.assertEquals(actualText, "User");
	}

	
	
    
	

	@Then("Admin should see one dropdown")
	public void admin_should_see_one_dropdown() {
		boolean isPresent = Login.isroleDropdwnPresent();
	    
	    Assert.assertTrue(isPresent, "Role dropdown was expected but not found!");
	
	}

	@Then("Admin should see asterisk mark symbol next to text for mandatory fields")
	public void admin_should_see_asterisk_mark_symbol_next_to_text_for_mandatory_fields() {
	 Assert.assertTrue(Login.isAsteriskUserDisplayed());
	}

	@Then("Admin should see Password in the second text field")
	public void admin_should_see_password_in_the_second_text_field() {
		String actualText = Login.verifyPasswordTxt();
		
			Assert.assertEquals(actualText,"Password");}
		

	@Then("Admin should see asterisk mark symbol next to password text")
	public void admin_should_see_asterisk_mark_symbol_next_to_password_text() {
		Assert.assertTrue(Login.isAsteriskPassDisplayed());
	}

	@Then("Admin should see Select the role placeholder in dropdown")
	public void admin_should_see_select_the_role_placeholder_in_dropdown() {
		Assert.assertTrue(Login.isroleDropdwnPresent());
	}
	

	@Then("Admin should see Admin Staff Student options in dropdown")
	public void admin_should_see_admin_staff_student_options_in_dropdown() {
		List<String> expectedOptions = List.of("Admin", "Staff", "Student");
	    List<String> actualOptions = Login.getDropdownOptionsVisible(); 

	     Assert.assertTrue(actualOptions.containsAll(expectedOptions));
	                     
		
	}
	

	@Then("Admin should see input field in the center of the page")
	public void admin_should_see_input_field_in_the_center_of_the_page() {
		boolean areinputFieldsCenter = Login.areInputFieldsCenter();
		
			Assert.assertEquals("Input Fields are not Centered", areinputFieldsCenter);
		
			
		
	
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		 Assert.assertTrue(Login.isloginBtnVisible());
	}

	@Then("Admin should see User in gray color")
	public void admin_should_see_user_in_gray_color() {
		Assert.assertTrue(Login.isUserTxtGray());
		
	}

	@Then("Admin should see Password in gray color")
	public void admin_should_see_password_in_gray_color() {
		
		
			Assert.assertTrue(Login.isPwdTxtGray());
		
	}

	@Given("Admin is on login page")
public void admin_is_on_login_page() {
		context.getApplicationURL();
	}

	@When("Admin enters  {string} and clicks login button")
public void admin_enters_and_clicks_login_button(String credentials) {
		result = Login.validLogin(credentials);
	}

	@Then("Admin should {string}")
public void admin_should(String expected_message) {
		
		if (expected_message.equals("land on home page")) {
	       
	        Assert.assertTrue(isElementDisplayed(Dashboard.HomeTitle));
	    } else {
	        
	        String actualMessage = result.get("actualMessage");

	       

	        
	        Assert.assertEquals(actualMessage, expected_message
	           );
	    }
    }
	

	@When("Admin enters valid credentials and presses Enter key")
	public void admin_enters_valid_credentials_and_presses_enter_key() {
		Login.pressEnterKey();
	}

	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() {
		String Expected = Loginxl.get(1).get("title");
		Assert.assertEquals(getPageTitle(driver),Expected);
	}

	@When("Admin enters valid credentials and clicks login button through mouse")
	public void admin_enters_valid_credentials_and_clicks_login_button_through_mouse() {
		Login.clickLoginButtonMouse();
	}
   @Then("Admin should land on home page login action through mouse")
  public void admin_should_land_on_home_page_login_action_through_mouse() {
	String Expected = Loginxl.get(1).get("title");
	Assert.assertEquals(getPageTitle(driver),Expected);
     


   }
   
}
