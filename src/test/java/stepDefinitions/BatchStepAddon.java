package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
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
import pages.LMSAddonPage;
import pages.Login_Page;

public class BatchStepAddon extends BasePage {
	private Dashboard_Page Dashboard;
	private LMSAddonPage common;
	private WebDriver driver;
	private TestContext context;
	private ExcelReader excelReader;
	List<Map<String, String>> Loginxl = Hooks.Login;
	List<Map<String, String>> msg = Hooks.Msg;

	public BatchStepAddon(TestContext context) {
     this.context = context;
     this.driver = context.getDriver();
     this.common = new LMSAddonPage(driver,context);
     this.Dashboard = new Dashboard_Page(driver, context); 
     this.excelReader = context.getExcelReader();
 }
	

@When("Admin clicks Batch on the navigation bar")
public void admin_clicks_batch_on_the_navigation_bar() {
	elementClick(common.batchHeader);
}

@Then("Admin should see Manage batch page title")
public void admin_should_see_manage_batch_page_title() {
	String Expected = Loginxl.get(1).get("title");
	Assert.assertEquals(getPageTitle(driver), Expected);
}

@Then("Admin should see search box")
public void admin_should_see_search_box() {
	Assert.assertTrue(isElementPresent(common.Search));
}

@Then("Admin should see footer message")
public void admin_should_see_footer_message() {
	Assert.assertTrue(isElementPresent(common.footer));
}

@Then("Admin should see LMS Learning Management System")
public void admin_should_see_lms_learning_management_system() {
	Assert.assertTrue(isElementDisplayed(Dashboard.HomeTitle));
}

@Then("Admin should see menus")
public void admin_should_see_menus() throws InvalidFormatException, IOException {
	List<String> expectedTexts = excelReader.getColumnData("Login", 4);
 	for(int i=0;i<Dashboard.Menus.size();i++) {
 		String NavbarText =Dashboard.Menus.get(i).getText().trim();
 		Assert.assertEquals(NavbarText, expectedTexts.get(i));	 
 	};
}

@Given("Admin is on Manage Batch page")
public void admin_is_on_manage_batch_page() {
	elementClick(common.batchHeader);
}

@When("Admin clicks {string} menubar")
public void admin_clicks_menubar(String MenuTxt) {
	switch (MenuTxt) {
	case "Home": common.elementclickJs(common.homeHeader);
		break;
	case "Program": common.elementclickJs(common.programHeader);
		break;
	case "Class": common.elementclickJs(common.classHeader);
		break;
	}
}

@Then("Admin is navigated to {string} pages")
public void admin_is_navigated_to_pages(String MenuTxt) {
	switch (MenuTxt) {
	case "Home": Assert.assertEquals(elementGetText(Dashboard.MngPg), Loginxl.get(4).get("page"));
		break;
	case "Program": Assert.assertEquals(elementGetText(Dashboard.MngPg), Loginxl.get(2).get("page"));
		break;
	case "Class": Assert.assertEquals(elementGetText(Dashboard.MngPg), Loginxl.get(3).get("page"));
		break;
	}
}

@When("Admin clicks on delete icon for selected batch entry")
public void admin_clicks_on_delete_icon_for_selected_batch_entry() {
	common.elementclickJs(common.DeleteR1Icon);
}

@Then("Admin should see batch name in the confirmation window")
public void admin_should_see_batch_name_in_the_confirmation_window() {
	String[] actual = elementGetText(common.PrgDeleteMsg).split(" ");
	String expected = elementGetText(common.DeleteR1Data);
	Assert.assertEquals(actual[7],expected+"?" );
}

@Given("The Admin is in Add New batch pop window")
public void the_admin_is_in_add_new_batch_pop_window() {
	elementClick(Dashboard.BatchMenu);
	elementClick(common.SubMenu);
}

@When("Admin clicks save button")
public void admin_clicks_save_button() {
	elementClick(common.saveProgram);
}

@Then("Admin should see error messages")
public void admin_should_see_error_messages() {
	Assert.assertEquals(common.Errors.size(), 5);
}

@When("Admin enters invalid {string} data and clicks save")
public void admin_enters_invalid_data_and_clicks_save(String field) {
	switch (field) {
	case "DescSpcChar": common.sendText(msg.get(9).get("Input"));
		break;
	case "DescStarts-No": common.sendText(msg.get(7).get("Input"));
		break;
	case "DesclessChar": common.sendText(msg.get(8).get("Input"));
		break;
	}
}

@Then("Admin receives {string} invalid error messages")
public void admin_receives_invalid_error_messages(String field) {
	Assert.assertEquals(elementGetText(common.Errormessage), msg.get(9).get("errmsg"));
}

@Given("The Admin is in Edit New batch pop window")
public void the_admin_is_in_edit_new_batch_pop_window() {
	elementClick(Dashboard.BatchMenu);
	common.elementclickJs(common.EditIcon);
}

@When("Admin clears Description and clicks save")
public void admin_clears_description_and_clicks_save() {
	common.batchDescText.clear();
	common.elementclickJs(common.saveProgram);
}

@Then("Admin should description mandatory error message")
public void admin_should_description_mandatory_error_message() {
	Assert.assertFalse(common.errormsg());
}


}
