package stepDefinitions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import appHook.Hooks;
import appHook.TestContext;
import pages.Dashboard_Page;
import pages.Login_Page;

public class DashboardStep {
	
	private Dashboard_Page Dashboard;
	private Login_Page Login;
	private WebDriver driver;
	private TestContext context;
	List<Map<String, String>> Loginxl = Hooks.Login;

	public DashboardStep(TestContext context) {
     this.context = context;
     this.driver = context.getDriver();
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
	Assert.assertTrue(Dashboard.HomeTitle.isDisplayed());

}

@Then("LMS title should be on the top left corner of page")
public void lms_title_should_be_on_the_top_left_corner_of_page() {
	
		Point location= Dashboard.HomeTitle.getLocation();
		int x= location.getX();
		int y = location.getY();
		
		Assert.assertTrue(x <= 25);
	    Assert.assertTrue(y <= 25);
}


@Then("Admin should see correct spelling in navigation bar text")
public void admin_should_see_correct_spelling_in_navigation_bar_text() {
	String a= Loginxl.get(0).get("menu");
	String b= Loginxl.get(1).get("menu");
	String c= Loginxl.get(2).get("menu");
	String x= Loginxl.get(3).get("menu");
	String y= Loginxl.get(4).get("menu");
	List<String> expectedTexts = Arrays.asList(a,b,c,x,y);
 	for(int i=0;i<Dashboard.Menus.size();i++) {
 		String NavbarText =Dashboard.Menus.get(i).getText().trim();
 		Assert.assertEquals(NavbarText, expectedTexts.get(i));	 
 	}
	
}

@Then("Admin should see correct spelling and space in LMS title")
public void admin_should_see_correct_spelling_and_space_in_lms_title() {
	String Expected = Loginxl.get(0).get("title");
	Assert.assertEquals(Dashboard.HomeTitle(),Expected);
}

@Then("Admin should see the navigation bar text on the top right side")
public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
	
	Point location= Dashboard.MenuBar.getLocation();
	int x= location.getX();
	int y = location.getY();
	Assert.assertTrue(x <= 1250);
    Assert.assertTrue(y <= 25);
}

@Then("Admin should see {string} in the {string}")
public void admin_should_see_in_the(String Menu, String Order) {

	switch (Menu) {
	case "Home":
		Assert.assertTrue(Dashboard.HomeMenu.getLocation().getX() <= 1200);
		break;
	case "Program":
		Assert.assertTrue(Dashboard.ProgramMenu.getLocation().getX() <= 1250);
		break;
	case "Batch":
		Assert.assertTrue(Dashboard.BatchMenu.getLocation().getX() <= 1350);
		break;
	case "Class":
		Assert.assertTrue(Dashboard.ClassMenu.getLocation().getX() <= 1400);
		break;
	case "Logout":
		Assert.assertTrue(Dashboard.ProgramMenu.getLocation().getX() <= 1450);
		break;		
	}
}

@Then("Admin should see piechart")
public void admin_should_see_piechart() {
	Assert.assertTrue(Dashboard.PieChart.isDisplayed());
}

@Then("Admin should see welcome message with user name and role")
public void admin_should_see_welcome_message_with_user_name_and_role() {
	String Expected = Loginxl.get(0).get("username");
	String a = Dashboard.WelcomeTxt();
	String[] actual = a.split(" ");
	Assert.assertEquals(actual[1],Expected);


	Assert.assertEquals(Dashboard.role(), "ADMIN" );	
}

@Then("Admin should see bar chart for Active and inactive user")
public void admin_should_see_bar_chart_for_active_and_inactive_user() {
	Assert.assertTrue(Dashboard.BarChart.isDisplayed());
}

@Then("Admin should see {string} count")
public void admin_should_see_count(String Section) {
	switch (Section) {
	case "User":
		Assert.assertTrue(Dashboard.UsrCount.isDisplayed());
		break;
	case "Staff":
		Assert.assertTrue(Dashboard.StaffCount.isDisplayed());
		break;
	case "Batch":
		Assert.assertTrue(Dashboard.BatchCount.isDisplayed());
		break;
	case "Program":
		Assert.assertTrue(Dashboard.ProgramCount.isDisplayed());
		break;
	}
}

@Then("Admin should see staff table with pagination icons")
public void admin_should_see_staff_table_with_pagination_icons() {
	Assert.assertTrue(Dashboard.StaffTable.isDisplayed());
	Assert.assertTrue(Dashboard.TablePagination.isDisplayed());
}

@Then("Admin should see five staff data in a page")
public void admin_should_see_five_staff_data_in_a_page() {
	Assert.assertEquals(Dashboard.DataRow(), 5 );
}

@Then("Admin should see {string} page icon disabled")
public void admin_should_see_page_icon_disabled(String PageArrow) {
	Assert.assertFalse(Dashboard.FirstPg.isEnabled());
	Assert.assertFalse(Dashboard.PreviousPg.isEnabled());
}


}
