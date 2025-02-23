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
import pages.LMSAddonPage;
import pages.Dashboard_Page;
import pages.Login_Page;
import pages.Program_Page;

public class ProgramStepAddon extends BasePage{
	private Login_Page Login;
	private Dashboard_Page Dashboard;
	private LMSAddonPage common;
	private WebDriver driver;
	private TestContext context;
	private ExcelReader excelReader;
	List<Map<String, String>> Loginxl = Hooks.Login;
	List<Map<String, String>> msg = Hooks.Msg;

	public ProgramStepAddon(TestContext context) {
     this.context = context;
     this.driver = context.getDriver();
     this.common = new LMSAddonPage(driver,context);
     this.Login = new Login_Page(driver,context);
     this.Dashboard = new Dashboard_Page(driver, context); 
     this.excelReader = context.getExcelReader();
 }
	
@Given("Admin is on home page after Logs in")
public void admin_is_on_home_page_after_logs_in() {
	Login.AdminLogin();
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

	elementClick(Dashboard.ProgramMenu);
}

@When("Admin clicks {string} menu")
public void admin_clicks_menu(String MenuTxt) {
	switch (MenuTxt) {
	case "Home": common.elementclickJs(common.homeHeader);
		break;
	case "Logout": common.elementclickJs(common.logoutHeader);
		break;
	case "Batch": common.elementclickJs(common.batchHeader);
		break;
	case "Class": common.elementclickJs(common.classHeader);
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
	common.SearchDiff();
}

@Then("Admin should see all program data for the search")
public void admin_should_see_all_program_data_for_the_search() {
	Assert.assertFalse(common.SearchData());
}

@Given("The Admin is in Add New program pop window")
public void the_admin_is_in_add_new_program_pop_window() {
	elementClick(Dashboard.ProgramMenu);
	elementClick(common.SubMenu);
}

@When("Admin leaves {string} empty and clicks save")
public void admin_leaves_empty_and_clicks_save(String field) {
	if(field.equals("Name"))
		common.AddPrgNameEmpty();
	else if (field.equals("Description"))
		common.AddPrgDesEmpty();
	else if (field.equals("Status"))
		common.AddPrgStatusEmpty();
}

@Then("Admin receives {string} mandatory error message")
public void admin_receives_mandatory_error_message(String field) {
	if(field.equals("Name")) {
		String EmptyNameMsg = msg.get(0).get("errmsg");
		Assert.assertEquals(elementGetText(common.Errormessage),EmptyNameMsg );
	}
	else if (field.equals("Description")) {
		String EmptyDescMsg = msg.get(1).get("errmsg");
		Assert.assertEquals(elementGetText(common.Errormessage),EmptyDescMsg );
		}
	else if (field.equals("Status")) {
		String EmptyStatusMsg = msg.get(2).get("errmsg");
		Assert.assertEquals(elementGetText(common.Errormessage),EmptyStatusMsg );
	}
		
}

@When("Admin enters invalid {string} and clicks save")
public void admin_enters_invalid_and_clicks_save(String field) {
	switch (field) {
	case "NameSpcChar":
		common.programNameText.clear();
		elementSendkeys(common.programNameText,msg.get(3).get("Input") );
		break;
	case "NameStarts-SpcChar":
		common.programNameText.clear();
		elementSendkeys(common.programNameText,msg.get(4).get("Input") );
		break;
	case "NameStarts-No":
		common.programNameText.clear();
		elementSendkeys(common.programNameText,msg.get(5).get("Input") );
		break;
	case "NamelessChar":
		common.programNameText.clear();
		elementSendkeys(common.programNameText,msg.get(6).get("Input") );
		break;
	case "DescStarts-No":
		common.programDescText.clear();
		elementSendkeys(common.programDescText,msg.get(7).get("Input") );
		break;
	case "DesclessChar":
		common.programDescText.clear();
		elementSendkeys(common.programDescText,msg.get(8).get("Input") );
		break;
	}
}

@Then("Admin receives {string} invalid error message")
public void admin_receives_invalid_error_message(String field) {
	switch (field) {
	case "NameSpcChar":
		Assert.assertEquals(elementGetText(common.Errormessage), msg.get(3).get("errmsg"));
		break;
	case "NameStarts-SpcChar":
		Assert.assertEquals(elementGetText(common.Errormessage), msg.get(4).get("errmsg"));
		break;
	case "NameStarts-No":
		Assert.assertEquals(elementGetText(common.Errormessage), msg.get(5).get("errmsg"));
		break;
	case "NamelessChar":
		Assert.assertEquals(elementGetText(common.Errormessage), msg.get(6).get("errmsg"));
		break;
	case "DescStarts-No":
		Assert.assertEquals(elementGetText(common.Errormessage), msg.get(7).get("errmsg"));
		break;
	case "DesclessChar":
		Assert.assertEquals(elementGetText(common.Errormessage), msg.get(8).get("errmsg"));
		break;
	}
}

@Given("The Admin is in Edit program pop window")
public void the_admin_is_in_edit_program_pop_window() {
	elementClick(Dashboard.ProgramMenu);
	common.elementclickJs(common.EditIcon);
}

@When("Admin clears {string} and clicks save")
public void admin_clears_and_clicks_save(String field) {
	if(field.equals("Name")) {
		common.programNameText.clear();
		common.elementclickJs(common.saveProgram);}
	else {
		common.programDescText.clear();
		common.elementclickJs(common.saveProgram);}
}
@Then("Admin receives {string} edit mandatory error message")
public void admin_receives_edit_mandatory_error_message(String string) {
    Assert.assertFalse(common.errormsg());
}
@When("Admin clicks on {string} delete icon")
public void admin_clicks_on_delete_icon(String icon) {
	if (icon.equals("Delete"))
	common.elementclickJs(common.DeleteR1Icon);
	else 
	common.DeleteAllWindow();
}

@Then("Admin should see warning sign in confirmation window")
public void admin_should_see_warning_sign_in_confirmation_window() {
	Assert.assertTrue(isElementPresent(common.WarningIcon));
}

@When("Admin clicks on delete icon for selected program entry")
public void admin_clicks_on_delete_icon_for_selected_program_entry() {
	common.elementclickJs(common.DeleteR1Icon);
}

@Then("Admin should see program name in the confirmation window")
public void admin_should_see_program_name_in_the_confirmation_window() {
	String[] actual = elementGetText(common.PrgDeleteMsg).split(" ");
	String expected = elementGetText(common.DeleteR1Data);
	Assert.assertEquals(actual[7],expected+"?" );
}

}