package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import appHook.Hooks;
import appHook.TestContext;
import pages.Dashboard_Page;
import pages.Login_Page;

public class DashboardStep {
	
	private WebDriverWait wait;
	private Dashboard_Page Dashboard;
	private Login_Page Login;
	private WebDriver driver;
	private TestContext context;
	List<Map<String, String>> Loginxl = Hooks.Login;

	public DashboardStep(TestContext context) {
     this.context = context;
     this.driver = context.getDriver();
     this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
     this.Login = new Login_Page(driver, context);
     this.Dashboard = new Dashboard_Page(driver, context); 
 }

@Given("Admin is on login Page")
public void admin_is_on_login_page() {
	context.getApplicationURL(); 
}

@When("Admin enter valid data in all field and clicks login button")
public void admin_enter_valid_data_in_all_field_and_clicks_login_button() {
	Login.AdminLogin();
}

@Then("Admin should see LMS -Learning management system as title")
public void admin_should_see_lms_learning_management_system_as_title() {
	String Expected = Loginxl.get(0).get("title");
	String Actual = Dashboard.HomeTitle();
	System.out.println(Expected);
	System.out.println(Actual);
	//Assert.assertEquals(Expected, Actual);
}
/*
@Then("LMS title should be on the top left corner of page")
public void lms_title_should_be_on_the_top_left_corner_of_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see correct spelling in navigation bar text")
public void admin_should_see_correct_spelling_in_navigation_bar_text() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see correct spelling and space in LMS title")
public void admin_should_see_correct_spelling_and_space_in_lms_title() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see the navigation bar text on the top right side")
public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see {string} in the {string}")
public void admin_should_see_in_the(String Menu, String Order) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see piechart")
public void admin_should_see_piechart() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see welcome message with user name and role")
public void admin_should_see_welcome_message_with_user_name_and_role() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see bar chart for Active and inactive user")
public void admin_should_see_bar_chart_for_active_and_inactive_user() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see {string} count")
public void admin_should_see_count(String Section) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see staff table with pagination icons")
public void admin_should_see_staff_table_with_pagination_icons() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see {int} staff data in a page")
public void admin_should_see_staff_data_in_a_page(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see {string} page icon disabled")
public void admin_should_see_page_icon_disabled(String PageArrow) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
*/

}