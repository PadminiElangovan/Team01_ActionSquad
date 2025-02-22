package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import appHook.Hooks;
import appHook.TestContext;
import common.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.Dashboard_Page;
import pages.Login_Page;
import pages.Program_Page;

public class ProgramStepAddon extends BasePage{
	private Dashboard_Page Dashboard;
	private Login_Page Login;
	private Program_Page Program;
	private WebDriver driver;
	private TestContext context;
	private ExcelReader excelReader;
	List<Map<String, String>> Loginxl = Hooks.Login;

	public ProgramStepAddon(TestContext context) {
     this.context = context;
     this.driver = context.getDriver();
     this.Login = new Login_Page(driver, context);
     this.Program = new Program_Page(driver, context);
     this.Dashboard = new Dashboard_Page(driver, context); 
     this.excelReader = context.getExcelReader();
 }

@When("Admin clicks Program on the navigation bar")
public void admin_clicks_program_on_the_navigation_bar() {
	elementClick(Dashboard.ProgramMenu);
}

@Then("Admin should see Manage Program page title")
public void admin_should_see_manage_program_page_title() {
	String Expected = Loginxl.get(1).get("title");
	Assert.assertEquals(getPageTitle(driver), Expected);	
}

@Given("Admin is on Manage Program page")
public void admin_is_on_manage_program_page() {
	Program.clickProgram();
}

@When("Admin clicks {string} menu")
public void admin_clicks_menu(String MenuTxt) {
	switch (MenuTxt) {
	case "Home": Dashboard.elementclickJs(Program.homeHeader);
		break;
	case "Logout": Dashboard.elementclickJs(Program.logoutHeader);
		break;
	case "Batch": Dashboard.elementclickJs(Program.batchHeader);
		break;
	case "Class": Dashboard.elementclickJs(Program.classHeader);
		break;
	}
}

@Then("Admin is navigated to {string} page")
public void admin_is_navigated_to_page(String MenuTxt) {
	switch (MenuTxt) {
	case "Home": Assert.assertEquals(elementGetText(Dashboard.MngPg), Loginxl.get(4).get("page"));
		break;
	case "Logout": Assert.assertTrue(driver.getCurrentUrl().contains("/login"));	
		break;
	case "Batch": Assert.assertEquals(elementGetText(Dashboard.MngPg), Loginxl.get(1).get("page"));
		break;
	case "Class": Assert.assertEquals(elementGetText(Dashboard.MngPg), Loginxl.get(3).get("page"));
		break;
	}
}

@When("Admin enter valid program search in different case")
public void admin_enter_valid_program_search_in_different_case() {

}

@Then("Admin should see all program data for the search")
public void admin_should_see_all_program_data_for_the_search() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
/*
@Given("The Admin is in Add New program pop window")
public void the_admin_is_in_add_new_program_pop_window() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin leaves {string} empty and clicks save")
public void admin_leaves_empty_and_clicks_save(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin receives {string} mandatory error message")
public void admin_receives_mandatory_error_message(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin enters invalid {string} and clicks save")
public void admin_enters_invalid_and_clicks_save(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin receives {string} invalid error message")
public void admin_receives_invalid_error_message(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("The Admin is in Edit program pop window")
public void the_admin_is_in_edit_program_pop_window() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin clicks on {string} delete icon")
public void admin_clicks_on_delete_icon(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see warning sign in confirmation window")
public void admin_should_see_warning_sign_in_confirmation_window() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Admin clicks on delete icon for selected program entry")
public void admin_clicks_on_delete_icon_for_selected_program_entry() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see program name in the confirmation window")
public void admin_should_see_program_name_in_the_confirmation_window() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

*/
}
