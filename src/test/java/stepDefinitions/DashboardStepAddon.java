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
import pages.Dashboard_Page;
import pages.Login_Page;

public class DashboardStepAddon {
	private Dashboard_Page Dashboard;
	private Login_Page Login;
	private WebDriver driver;
	private TestContext context;
	List<Map<String, String>> Loginxl = Hooks.Login;

	public DashboardStepAddon(TestContext context) {
     this.context = context;
     this.driver = context.getDriver();
     this.Login = new Login_Page(driver, context);
     this.Dashboard = new Dashboard_Page(driver, context); 
	}

@Then("Admin should see LMS Dashboard page title")
public void admin_should_see_lms_dashboard_page_title() {
	String Expected = Loginxl.get(1).get("title");
	Assert.assertEquals(Dashboard.PageTitle(),Expected);
}

@Then("Admin should see Dashboard section header")
public void admin_should_see_dashboard_section_header() {
	Assert.assertTrue(Dashboard.DashboardSection.isDisplayed());
}

@Then("Admin should see Welcome text")
public void admin_should_see_welcome_text() {
	String a = Dashboard.WelcomeTxt();
	String[] actual = a.split(" ");
	Assert.assertEquals(actual[0],"Welcome");
}

@Then("Admin should see Profile icon")
public void admin_should_see_profile_icon() {

}

@Then("Admin should see {string} text and icon")
public void admin_should_see_text_and_icon(String string) {

}

@Then("Admin should see Staff Data header")
public void admin_should_see_staff_data_header() {

}

@Then("Admin should see {string} column header")
public void admin_should_see_column_header(String string) {

}

@Given("Admin is on home page after Login")
public void admin_is_on_home_page_after_login() {
	Login.AdminLogin();
}

@When("Admin clicks Home menu")
public void admin_clicks_home_menu() {
	Dashboard.HomeLink();
}

@Then("Admin should remain in the home page")
public void admin_should_remain_in_the_home_page() {
	Assert.assertTrue(Dashboard.DashboardSection.isDisplayed());
}

@Then("Admin should be in {string} page")
public void admin_should_be_in_page(String string) {

}


}
