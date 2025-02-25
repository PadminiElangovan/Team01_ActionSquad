package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import appHook.Hooks;
import appHook.TestContext;
import common.ConfigReader;
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
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
        driver.get(context.getApplicationURL());
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
        driver.get( ConfigReader.getProperty("InvalidURL"));
	}

	@Then("Admin should receive application error")
	public void admin_should_receive_application_error() {
		Assert.assertEquals(Login.StatusCode(), 404);
	}

	@Then("If HTTP response less than or equals {int} then the link is broken")
	public void if_http_response_less_than_or_equals_then_the_link_is_broken(Integer int1) {	
        Assert.assertTrue(Login.StatusCode() <= int1);	
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
		Assert.assertEquals(elementGetText(Login.usernameLabel), "User");		
		Assert.assertEquals(elementGetText(Login.passwordLabel), "Password");
		Assert.assertEquals(elementGetText(Login.LoginBtn), "Login");
	}

	@Then("Admin should see LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
		String Text = elementGetText(Login.logo);
		Assert.assertFalse(Text.isEmpty());
	}

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
		String Text = elementGetText(Login.logo);
		Assert.assertFalse(Text.isEmpty());
	}

	@Then("Admin should see Please login to LMS application")
	public void admin_should_see_please_login_to_lms_application() {	 
		 Assert.assertEquals(elementGetText(Login.LMStext), "Please login to LMS application");
    }	

	@Then("Admin should see two text fields")
	public void admin_should_see_two_text_fields() {
		 Assert.assertEquals(Login.InputFields.size(), 2);
		 Assert.assertTrue(isElementDisplayed(Login.Username));
		 Assert.assertTrue(isElementDisplayed(Login.Password));
	}

	@Then("Admin should see User in the first text field")
	public void admin_should_see_user_in_the_first_text_field() {
		int path = getLocation(Login.Username).getY();
		Assert.assertTrue(path <= 410);	
	}
	
	@Then("Admin should see Password in the second text field")
	public void admin_should_see_password_in_the_second_text_field() {
		int path = getLocation(Login.Password).getY();
		Assert.assertTrue(path > 410);
	}
	
	@Then("Admin should see asterisk mark symbol next to text for mandatory fields")
	public void admin_should_see_asterisk_mark_symbol_next_to_text_for_mandatory_fields() {
	 Assert.assertEquals(elementGetText(Login.userask), "*");
	}
	
	@Then("Admin should see asterisk mark symbol next to password text")
	public void admin_should_see_asterisk_mark_symbol_next_to_password_text() {
		Assert.assertEquals(elementGetText(Login.passwrdask), "*");
	}
    
	@Then("Admin should see one dropdown")
	public void admin_should_see_one_dropdown() {    
	    Assert.assertTrue(isElementPresent(Login.roleDropdwn));
	}
	
	@Then("Admin should see Select the role placeholder in dropdown")
	public void admin_should_see_select_the_role_placeholder_in_dropdown() {
		Assert.assertEquals(elementGetText(Login.roleDropdwn),"Select the role");
	}
	
	@Given("Admin is on login page")
	public void admin_is_on_login_page() {
		context.getApplicationURL();
	}

	@When("Admin click role dropdown")
	public void admin_click_role_dropdown() {
		elementClick(Login.roleDropdwn);
	}
	
	@Then("Admin should see Admin Staff Student options in dropdown")
	public void admin_should_see_admin_staff_student_options_in_dropdown() {		
		Assert.assertTrue(isElementDisplayed(Login.AdminRole));
		Assert.assertTrue(isElementDisplayed(Login.StaffRole));
		Assert.assertTrue(isElementDisplayed(Login.StudentRole));
	}
	
	@Then("Admin should see input field in the center of the page")
	public void admin_should_see_input_field_in_the_center_of_the_page() {
		String align = Login.form.getCssValue("text-align");
		Assert.assertTrue(align.equals("center"));
	}
	
	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		 Assert.assertTrue(isElementPresent(Login.LoginBtn));
	}
	
	@Then("Admin should see User in gray color")
	public void admin_should_see_user_in_gray_color() {
		String FontColor = Login.Username.getCssValue("color");
		Assert.assertEquals(FontColor, "rgba(0, 0, 0, 0.87)");
	}

	@Then("Admin should see Password in gray color")
	public void admin_should_see_password_in_gray_color() {		
		String FontColor = Login.Password.getCssValue("color");
		Assert.assertEquals(FontColor, "rgba(0, 0, 0, 0.87)");
	}
	
	@When("Admin enters valid credentials and clicks login button through mouse")
	public void admin_enters_valid_credentials_and_clicks_login_button_through_mouse() {
		Login.LoginMouseAction();
	}
	
	@When("Admin enters valid credentials and presses Enter key")
	public void admin_enters_valid_credentials_and_presses_enter_key() {
		Login.LoginKeyAction();
	}

	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() {
		Assert.assertTrue(isElementDisplayed(Dashboard.HomeTitle));
	}
	
	@When("Admin enters  {string} and clicks login button")
	public void admin_enters_and_clicks_login_button(String credentials) {
		Login.Inputs(credentials);
	}

	@Then("Admin should {string}")
	public void admin_should(String Credentials) {
		switch (Credentials) {  
        case "valid": Assert.assertTrue(isElementDisplayed(Dashboard.HomeTitle));
            break;
        case "invalid": Assert.assertFalse(Login.errmsg());
            break;
        case "Emptypassword": Assert.assertFalse(Login.errmsg());
            break;
        case "Emptyusername": Assert.assertFalse(Login.errmsg());
            break;
          }
	}
}

