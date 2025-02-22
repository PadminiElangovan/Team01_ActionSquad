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
import pages.Logout_Page;

public class LogoutStep {
	private Dashboard_Page Dashboard;
    private Login_Page Login;
    private Logout_Page logout;
    private WebDriver driver;
    private TestContext context;
    List<Map<String, String>> Loginxl = Hooks.Login;

    public LogoutStep(TestContext context) {
        this.context = context;
        this.driver = context.getDriver();
        this.Login = new Login_Page(driver, context);
       this.logout= new Logout_Page(driver, context); 
    }
	
    @Given("Admin is in home page")
    public void admin_is_in_home_page() {
       Login.AdminLogin();
    }

    @When("Admin clicks on the logout in the menu bar")
    public void admin_clicks_on_the_logout_in_the_menu_bar() {
       logout.clickLogout();
    }

    @Then("Admin should be redirected to login page")
    public void admin_should_be_redirected_to_login_page() {
    	Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Admin is not redirected to the login page!");
    }

    @Given("Admin is in login page")
    public void admin_is_in_login_page() {
        driver.getCurrentUrl().contains("login");
    }

    @When("Admin clicks browser back button")
    public void admin_clicks_browser_back_button() {
        driver.navigate().back();
    }

    @Then("Admin should receive error message for back button")
    public void admin_should_receive_error_message_for_back_button() {
      Assert.assertTrue(Login.errmsg());
    }



}
