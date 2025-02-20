package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import appHook.TestContext;
import common.ExcelReader;
import common.LoggerLoad;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Program_Page;

public class ProgramStep {

	private WebDriverWait wait;
	private WebDriver driver;
	private TestContext context;
	private Program_Page program;
	private ExcelReader excelReader;
	boolean status;

	public ProgramStep(TestContext context) {
		this.context = context;
		this.driver = context.getDriver();
		this.program = new Program_Page(driver, context);
		this.excelReader = context.getExcelReader(); // Use TestContext's ExcelReader instance
	}

	@When("Admin clicks on Program")
	public void admin_clicks_on_program() {
		program.clickProgram();
	}

	@Then("Admin should see all fields and headers on Manage Program page")
	public void then_admin_should_see_all_headers_match() {
		List<String> expectedHeaders;
		try {
			expectedHeaders = excelReader.getColumnData("Program", 0);
		} catch (Exception e) {
			LoggerLoad.error("Error initializing Excel data: " + e.getMessage());
			throw new RuntimeException("Error initializing Excel data: " + e.getMessage());
		}
		System.out.println(expectedHeaders);
		//List<String> actualHeaders = program.getTableHeaders();
		List<String> actualHeaders = program.getProgramTableHeaders();
		System.out.println(actualHeaders);
		Assert.assertTrue(actualHeaders.containsAll(expectedHeaders));

	}

	@Then("Admin should see footer and enabled pagination controls under the data table")
	public void admin_should_see_footer_and_pagination() throws InterruptedException {
		assertTrue(program.validateShowingEnteries());
		assertTrue(program.validatePagination());
		LoggerLoad.info("Footer is displayed");
		LoggerLoad.info("Pagination is displayed");
	}

	@Then("Admin should see the checkbox default state")
	public void admin_should_see_the_checkbox_default_state() {
		program.checkboxWithProgramName();
	}
	@Then("Admin should see the Sort icon of all the field in the datatable.")
	public void admin_should_see_sort_icons() {
		status = program.validateSortingBtn();
		assertTrue(status);
		LoggerLoad.info("Sorting button are visible");
	}

	@Then("Admin should see the Delete button under the Manage program page header")
	public void admin_should_see_delete_button() {
		status = program.deleteBtnDisplayed();
		assertTrue(status);
		LoggerLoad.info("Delete button is visible");
	}

	@Then("Admin should see Total no of programs in below of the data table")
	public void admin_should_see_total_numbers_of_programs() {
		assertTrue(program.validateFooter());
	}
}
