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

	private Login_Page Login;
	private Dashboard_Page Dashboard;
	private WebDriver driver;
	private TestContext context;
	List<Map<String, String>> Loginxl = Hooks.Login;

	public LoginStepAddon(TestContext context) {
     this.context = context;
     this.driver = context.getDriver();
     this.Login = new Login_Page(driver, context);
     this.Dashboard = new Dashboard_Page(driver, context);
 }
	

@When("The Admin clicks Login button")
public void the_admin_clicks_login_button() {
	Login.LoginBtn.click();
}

@Then("Admin receives mandatory fields error message")
public void admin_receives_mandatory_fields_error_message() {
	
	Assert.assertFalse(Login.errmsg());

}

@When("Admin enter valid credentials with role unselected and clicks login")
public void admin_enter_valid_credentials_with_role_unselected_and_clicks_login() {
	Login.UsrPswd();
}

@Then("Admin should see Please select your Role error message")
public void admin_should_see_please_select_your_role_error_message() {
	Assert.assertFalse(Login.errmsg());

}

@When("Admin enters password in password field")
public void admin_enters_password_in_password_field() {
	Login.InputCred();
	
}

@Then("Admin should see masked password")
public void admin_should_see_masked_password() {
	String actual = elementGetText(Login.Password);
	Assert.assertTrue(actual.isEmpty());
	//String Expected = Loginxl.get(0).get("password");
	//Assert.assertEquals(actual, Expected);
	
}

@When("Admin enter valid credentials with staff role selection and clicks login")
public void admin_enter_valid_credentials_with_staff_role_selection_and_clicks_login() throws InterruptedException {
	Login.AdminRoleStaff();
}

@Then("Admin should not be navigated to LMS portal")
public void admin_should_not_be_navigated_to_lms_portal() {
	Assert.assertFalse(isElementPresent(Dashboard.DashboardSection));	
}

@When("Admin enter valid credentials with student role selection and clicks login")
public void admin_enter_valid_credentials_with_student_role_selection_and_clicks_login() {
	Login.AdminRoleStudent();
}

@When("Admin gives the correct LMS portal URL")
public void admin_gives_the_correct_lms_portal_url() {
	context.getApplicationURL();
}

@Then("Admin should see LMS Login page title")
public void admin_should_see_lms_login_page_title() {
	Assert.assertEquals(getPageTitle(driver), "LMS");
}

@Then("Admin should see Forgot Password Link")
public void admin_should_see_forgot_password_link() {
	Assert.assertFalse(Login.ForgotPswd.isEmpty());
}

}
