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
import pages.LMSAddonPage;

public class ClassStepAddon extends BasePage{
	private Dashboard_Page Dashboard;
	private LMSAddonPage common;
	private WebDriver driver;
	private TestContext context;
	private ExcelReader excelReader;
	List<Map<String, String>> Loginxl = Hooks.Login;
	List<Map<String, String>> msg = Hooks.Msg;

	public ClassStepAddon(TestContext context) {
     this.context = context;
     this.driver = context.getDriver();
     this.common = new LMSAddonPage(driver,context);
     this.Dashboard = new Dashboard_Page(driver, context); 
     this.excelReader = context.getExcelReader();
 }
	

@When("Admin clicks class on the navigation bar")
public void admin_clicks_class_on_the_navigation_bar() {
	elementClick(common.classHeader);
}

@Then("Admin should see Manage class page title")
public void admin_should_see_manage_class_page_title() {
	String Expected = Loginxl.get(1).get("title");
	Assert.assertEquals(getPageTitle(driver), Expected);
}

@Given("Admin is on Manage Class page")
public void admin_is_on_manage_class_page() {
	elementClick(common.classHeader);
}

@When("Admin clicks on delete icon for selected class entry")
public void admin_clicks_on_delete_icon_for_selected_class_entry() {
	common.elementclickJs(common.DeleteR1Icon);
}

@Then("Admin should see class name in the confirmation window")
public void admin_should_see_class_name_in_the_confirmation_window() {
	String[] actual = elementGetText(common.PrgDeleteMsg).split(" ");
	String expected = elementGetText(common.DeleteClassData);
	Assert.assertEquals(actual[7],expected+"?" );
}

}
