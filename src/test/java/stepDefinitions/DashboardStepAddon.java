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

public class DashboardStepAddon extends BasePage {
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
	Assert.assertEquals(getPageTitle(driver),Expected);
}

@Then("Admin should see Dashboard section header")
public void admin_should_see_dashboard_section_header() {
	Assert.assertTrue(isElementDisplayed(Dashboard.DashboardSection));
}

@Then("Admin should see Welcome text")
public void admin_should_see_welcome_text() {
//	String a = Dashboard.WelcomeTxt();
	String[] actual = elementGetText(Dashboard.WelcomeTxt).split(" ");
	Assert.assertEquals(actual[0],"Welcome");
}

@Then("Admin should see Profile icon")
public void admin_should_see_profile_icon() {
	Assert.assertTrue(isElementDisplayed(Dashboard.ProfileImage));
}

@Then("Admin should see {string} text and icon")
public void admin_should_see_text_and_icon(String section) {
	switch (section) {
	case "User":
		String x = Loginxl.get(0).get("icon");
		Assert.assertEquals(elementGetText(Dashboard.UsrText),x);
		Assert.assertTrue(isElementDisplayed(Dashboard.UsrIcon));
		break;
	case "Staff":
		String y = Loginxl.get(1).get("icon");
		Assert.assertEquals(elementGetText(Dashboard.StaffText),y);
		Assert.assertTrue(isElementDisplayed(Dashboard.StaffIcon));
		break;
	case "Batches":
		String z = Loginxl.get(2).get("icon");
		Assert.assertEquals(elementGetText(Dashboard.BatchText),z);
		Assert.assertTrue(isElementDisplayed(Dashboard.BatchIcon));
		break;
	case "Programs":
		String a = Loginxl.get(3).get("icon");
		Assert.assertEquals(elementGetText(Dashboard.PrgmText),a);
		Assert.assertTrue(isElementDisplayed(Dashboard.PrgmIcon));
		break;
	}
}

@Then("Admin should see Staff Data header")
public void admin_should_see_staff_data_header() {
	String Expected = Loginxl.get(0).get("table");
	Assert.assertEquals(elementGetText(Dashboard.TableHeader),Expected);
}

@Then("Admin should see {string} column header")
public void admin_should_see_column_header(String section) {
	switch (section) {
	case "UserID":
		String x = Loginxl.get(1).get("table");
		Assert.assertEquals(elementGetText(Dashboard.TableID),x);
		break;
	case "First Name":
		String y = Loginxl.get(2).get("table");
		Assert.assertEquals(elementGetText(Dashboard.TableFname),y);
		break;
	case "Last Name":
		String z = Loginxl.get(3).get("table");
		Assert.assertEquals(elementGetText(Dashboard.TableLname),z);
		break;
	case "Phone":
		String a = Loginxl.get(4).get("table");
		Assert.assertEquals(elementGetText(Dashboard.TablePhone),a);
		break;
	}
}

@Given("Admin is on home page after Login")
public void admin_is_on_home_page_after_login() {
	Login.AdminLogin();
}

@When("Admin clicks Home menu")
public void admin_clicks_home_menu() {
	elementClick(Dashboard.HomeMenu);
}

@Then("Admin should remain in the home page")
public void admin_should_remain_in_the_home_page() {
	Assert.assertTrue(isElementDisplayed(Dashboard.DashboardSection));
}

@When("Admin clicks {string} icon")
public void admin_clicks_icon(String module) {
	switch (module) {
	case "User":
		elementClick(Dashboard.UsrCount);		
		break;
	case "Staff":
		elementClick(Dashboard.StaffCount);
		break;
	case "Batches":
		elementClick(Dashboard.BatchCount);
		break;
	case "Programs":
		elementClick(Dashboard.ProgramCount);
		break;
	}
}


@Then("Admin should be in {string} page")
public void admin_should_be_in_page(String module)  {

	String x = Loginxl.get(0).get("page");
	switch (module) {
	case "User":
		Assert.assertEquals(elementGetText(Dashboard.MngPg),x);
		break;
	case "Staff":	
		String a = Loginxl.get(0).get("page");
		Assert.assertEquals(elementGetText(Dashboard.MngPg),a);
		break;
	case "Batches":		
		String y = Loginxl.get(1).get("page");
		Assert.assertEquals(elementGetText(Dashboard.MngPg),y);
		break;
	case "Programs":		
		String z = Loginxl.get(2).get("page");
		Assert.assertEquals(elementGetText(Dashboard.MngPg),z);
		break;
	}
}

@Then("Admin should see exact total count of active and inactive batch")
public void admin_should_see_exact_total_count_of_active_and_inactive_batch() throws InterruptedException {
	String [] Actual = Dashboard.BatchCount().split("\n");
	Dashboard.BatchCount.click();
	String[] Expected =  Dashboard.Footer().split(" ");
	Assert.assertEquals(Actual[0],Expected[4]);
	
}

@Then("Admin should see exact total count of active and inactive program")
public void admin_should_see_exact_total_count_of_active_and_inactive_program() throws InterruptedException {
	String [] Actual = Dashboard.PrgCount().split("\n");
	Dashboard.ProgramCount.click();
	String[] Expected =  Dashboard.Footer().split(" ");
	Assert.assertEquals(Actual[0],Expected[4]);
}

@Then("Admin should see exact total count of active and inactive user")
public void admin_should_see_exact_total_count_of_active_and_inactive_user() throws InterruptedException{
	String [] Actual = Dashboard.UsrCount().split("\n");
	Dashboard.UsrCount.click();
	String[] Expected =  Dashboard.Footer().split(" ");
	Assert.assertEquals(Actual[0],Expected[4]);
}
}
