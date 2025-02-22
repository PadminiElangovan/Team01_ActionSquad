package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import appHook.TestContext;
import common.ExcelReader;
import common.LoggerLoad;
import io.cucumber.java.en.Given;
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
		List<String> actualHeaders = program.getTableHeaders();
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
	
// ***********************************************Add New Program*************************************
	@When("Admin clicks Add New Program under program navigation bar")
	public void admin_clicks_add_new_class_under_class_navigation_bar() {
	   program.clickProgramAddNew();
	}

	
	
	@Then("Admin should see the Program Details pop up window {string}")
	public void admin_should_see_the_class_details_pop_up_window(String string) {
		switch (string) {
		case "ProgramDetails":
			Assert.assertTrue(program.programPopUpTitle());
			Assert.assertEquals(program.programPopUpTitleText(), "Program Details");
		case "Name":
			Assert.assertTrue(program.programNameDisplayed());
			Assert.assertEquals(program.programNameText(), "Name");
			break;
		case "Description":
			Assert.assertTrue(program.programDescDisplayed());
			Assert.assertEquals(program.programDescText(), "Description");
			break;
		case "Status":
			Assert.assertTrue(program.programStatus());
			Assert.assertEquals(program.programStatusText(), "Status");
			break;
			
		}
	}
	
	@When("Admin clicks on save button without entering data")
	public void admin_clicks_on_save_button_without_entering_data() {
		program.clickProgramAddNew();
		program.clickOnSave();    	
	}
	
	@Then("Admin should see error message below the test field and the field will be highlighed in red color {string} {string} {string}")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color(String programNameReqText, String programDescriptionReqText, 
            String programStatusReqText) {
		Assert.assertEquals("Program Name is required", programNameReqText, program.getProgramNameReqText());
        Assert.assertEquals("Description is required", programDescriptionReqText, program.getDescriptionReqText());
        Assert.assertEquals("Status is required", programStatusReqText, program.getStatusReqText());
        	}


	
	@When("Admin enters mandatory fields {string} {string} {string} {string} in the form and clicks on save button")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button(String Name, String Description,String Status,String expectedMsg) throws InterruptedException 
	{
		program.clickProgramAddNew();
		 assertTrue(program.addingMandatoryFields(Name,Description,Status).equals(expectedMsg));
	}
	

	@Then("Admin gets message Class added Successfully")
	public void admin_gets_message_class_added_successfully() {
		LoggerLoad.info("Program created successfully");
	}

	@When("Admin searches with newly created {string}")
	public void admin_searches_with_newly_created_program(String programName) {
		program.clickProgram();
		program.enterProgramNameInSearch();
	}
	
	@Then("Records of the newly created {string} is displayed and match the data entered")
	public void record_displayed(String pName) {
		Assert.assertEquals(program.verifyProgramName(), pName);
		
	}
// **************************************Pagination****************************************
	
	/*
	 * @Given("Admin is on Program page") public void admin_is_on_program_page() {
	 * program.clickProgram();
	 * 
	 * }
	 */
	
	
	
	 @When("^Admin clicks the (Next|Last|Previous|First) link on the data table$")
	    public void adminClicksPageLink(String pageLink) {
	    	
		 program.navigateToProgram();
	      	
			
			  switch (pageLink.toLowerCase()) 
			  { 
			  case "next":
				  program.clickNextPage();
			  break; 
			  case "last":
				  program.clickLastPage();
				  break; 
				  case "previous":
			  program.clickPreviousPage();
			  break;
			  case "first": 
				  program.clickFirstPage();
			  break; }
			 
	    }
	 
	    // Verify the results based on the <results> description
	@Then("^Admin should see the (.*) on the data table$")
	    public void adminShouldSeeResults(String expectedResult) {
	    	

	    	switch (expectedResult.toLowerCase()) {
	    	 case "Next enabled link":
	             Assert.assertTrue(program.isNextButtonEnabled());
	             break;
	        case "last page link with Next disabled":
	            Assert.assertFalse( program.isNextButtonEnabled());
	            break;
	        case "previous page":
	            Assert.assertTrue( program.isPrevButtonEnabled());
	            break;
	        case "very first page":
	            Assert.assertFalse( program.isPrevButtonEnabled());
	            break;
	          default:
	            Assert.fail("Unexpected result description: " + expectedResult);
	    }
	    }

}
	
	
	
	
	
	

