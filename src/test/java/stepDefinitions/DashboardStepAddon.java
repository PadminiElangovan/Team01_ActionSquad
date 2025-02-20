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
	Assert.assertTrue(Dashboard.ProfileImage.isDisplayed());
}

@Then("Admin should see {string} text and icon")
public void admin_should_see_text_and_icon(String section) {
	switch (section) {
	case "User":
		String x = Loginxl.get(0).get("icon");
		Assert.assertEquals(Dashboard.UsrText(),x);
		Assert.assertTrue(Dashboard.UsrIcon.isDisplayed());
		break;
	case "Staff":
		String y = Loginxl.get(1).get("icon");
		Assert.assertEquals(Dashboard.StaffText(),y);
		Assert.assertTrue(Dashboard.StaffIcon.isDisplayed());
		break;
	case "Batches":
		String z = Loginxl.get(2).get("icon");
		Assert.assertEquals(Dashboard.BatchText(),z);
		Assert.assertTrue(Dashboard.BatchIcon.isDisplayed());
		break;
	case "Programs":
		String a = Loginxl.get(3).get("icon");
		Assert.assertEquals(Dashboard.PrgmText(),a);
		Assert.assertTrue(Dashboard.PrgmIcon.isDisplayed());
		break;
	}
}

@Then("Admin should see Staff Data header")
public void admin_should_see_staff_data_header() {
	String Expected = Loginxl.get(0).get("table");
	Assert.assertEquals(Dashboard.TableHeader(),Expected);
}

@Then("Admin should see {string} column header")
public void admin_should_see_column_header(String section) {
	switch (section) {
	case "UserID":
		String x = Loginxl.get(1).get("table");
		Assert.assertEquals(Dashboard.TableID.getText(),x);
		break;
	case "First Name":
		String y = Loginxl.get(2).get("table");
		Assert.assertEquals(Dashboard.TableFname.getText(),y);
		break;
	case "Last Name":
		String z = Loginxl.get(3).get("table");
		Assert.assertEquals(Dashboard.TableLname.getText(),z);
		break;
	case "Phone":
		String a = Loginxl.get(4).get("table");
		Assert.assertEquals(Dashboard.TablePhone.getText(),a);
		break;
	}
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

@When("Admin clicks {string} icon")
public void admin_clicks_icon(String module) throws InterruptedException{
	System.out.println("#################################################################");
	switch (module) {
	case "User":
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		Dashboard.UsrIcon.click();
		Thread.sleep(1000);

		break;
	case "Staff":
		Dashboard.StaffIcon.click();
		Thread.sleep(1000);
		break;
	case "Batches":
		Dashboard.BatchIcon.click();
		Thread.sleep(1000);
		break;
	case "Programs":
		Dashboard.PrgmIcon.click();
		Thread.sleep(1000);
		break;
	}
}


@Then("Admin should be in {string} page")
public void admin_should_be_in_page(String module)  {
	System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	String x = Loginxl.get(0).get("page");
	switch (module) {
	case "User":
	
		System.out.println(x+"^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^6");
		Assert.assertEquals(Dashboard.MngPg.getText(),x);
		break;
	case "Staff":
	
		String a = Loginxl.get(0).get("page");
		System.out.println(a);
		Assert.assertEquals(Dashboard.MngPg.getText(),a);
		break;
	case "Batches":
		
		String y = Loginxl.get(1).get("page");
		System.out.println(y);
		Assert.assertEquals(Dashboard.MngPg.getText(),y);
		break;
	case "Programs":
		
		String z = Loginxl.get(1).get("page");
		System.out.println(z);
		Assert.assertEquals(Dashboard.MngPg.getText(),z);
		break;
	}
}

}
