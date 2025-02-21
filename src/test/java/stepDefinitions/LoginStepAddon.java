package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import appHook.Hooks;
import appHook.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.Dashboard_Page;
import pages.Login_Page;

public class LoginStepAddon extends BasePage{

	//private Dashboard_Page Dashboard;
	private Login_Page Login;
	private WebDriver driver;
	private TestContext context;
	List<Map<String, String>> Loginxl = Hooks.Login;

	public LoginStepAddon(TestContext context) {
     this.context = context;
     this.driver = context.getDriver();
     this.Login = new Login_Page(driver, context);
    // this.Dashboard = new Dashboard_Page(driver, context); 
 }
	

@When("The Admin clicks Login button")
public void the_admin_clicks_login_button() {
	Login.LoginBtn.click();
}

@Then("Admin receives mandatory fields error message")
public void admin_receives_mandatory_fields_error_message() {
//	Assert.assertTrue(Login.ErrMsg.isDisplayed());
	//Assert.assertTrue(isElementPresent(Login.ErrMsg));
}
/*
@When("Admin enter valid credentials with role unselected and clicks login")
public void admin_enter_valid_credentials_with_role_unselected_and_clicks_login() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see Please select your Role error message")
public void admin_should_see_please_select_your_role_error_message() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin enters password in password field")
public void admin_enters_password_in_password_field() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see masked password")
public void admin_should_see_masked_password() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin enter valid credentials with staff role selection and clicks login")
public void admin_enter_valid_credentials_with_staff_role_selection_and_clicks_login() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see Access Denied error message in login page")
public void admin_should_see_access_denied_error_message_in_login_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin enter valid credentials with student role selection and clicks login")
public void admin_enter_valid_credentials_with_student_role_selection_and_clicks_login() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("The browser is opened")
public void the_browser_is_opened() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin enter LMS url in the browser")
public void admin_enter_lms_url_in_the_browser() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see Forgot Password Link")
public void admin_should_see_forgot_password_link() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see LMS Login page title")
public void admin_should_see_lms_login_page_title() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
*/

}
