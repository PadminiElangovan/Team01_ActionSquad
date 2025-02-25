package stepDefinitions;

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
	boolean status1;

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
		Assert.assertTrue(program.validateShowingEnteries());
		Assert.assertTrue(program.validatePagination());
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
		Assert.assertTrue(status);
		LoggerLoad.info("Sorting button are visible");
	}
	
	@Then("Admin should see the Search box on the Manage program page header")
	public void admin_should_see_the_Search_box() {
		status = program.validateSearchBox();
		Assert.assertTrue(status);
		LoggerLoad.info("Sorting button are visible");
		
	}

	@Then("Admin should see the Delete button under the Manage program page header")
	public void admin_should_see_delete_button() {
		status = program.deleteBtnDisplayed();
	Assert.assertTrue(status);
		LoggerLoad.info("Delete button is visible");
	}
	
	@When("Admin clicks {string} on the navigation bar in program module")
	public void admin_clicks_on_the_navigation_bar(String string) throws InterruptedException {
		program.clickProgram();
	}
	
	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
		LoggerLoad.info("validating default state of  Checkbox");
		program.testAreUnchecked();		
	}

	@Then("Admin should see Total no of programs in below of the data table")
	public void admin_should_see_total_numbers_of_programs() {
	Assert.assertTrue(program.validateFooter());
	}
	
// ***********************************************Add New Program*************************************
	@When("Admin clicks Add New Program under program navigation bar")
	public void admin_clicks_add_new_class_under_class_navigation_bar() {
	   program.clickProgramAddNew();
	}

	
	
	@Then("Admin should see the Program Details pop up window {string}")
	public void admin_should_see_the_class_details_pop_up_window(String string) {
		switch (string) {
		case "Name":
			Assert.assertTrue(program.programNameDisplayed());
			Assert.assertEquals(program.programNameText().replaceAll("[^a-zA-Z ]", "").trim(), "Name");
			break;
		case "Description":
			Assert.assertTrue(program.programDescDisplayed());
			Assert.assertEquals(program.programDescText().replaceAll("[^a-zA-Z ]", "").trim(), "Description");
			break;
		case "Status":
			Assert.assertTrue(program.programStatus());
			Assert.assertEquals(program.programStatusText().replaceAll("[^a-zA-Z ]", "").trim(), "Status");
			break;
		case "ProgramDetails":
			Assert.assertTrue(program.programPopUpTitle());
			Assert.assertEquals(program.programPopUpTitleText(), "Program Details");	
			
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
		Assert.assertEquals("Program name is required", programNameReqText, program.getProgramNameReqText());
        Assert.assertEquals("Description is required.", programDescriptionReqText, program.getDescriptionReqText());
        Assert.assertEquals("Status is required.", programStatusReqText, program.getStatusReqText());
        	}


	
	@When("Admin enters mandatory fields {string} {string} {string} {string} in the form and clicks on save button")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button(String Name, String Description,String Status,String expectedMsg) throws InterruptedException 
	{
		program.clickProgramAddNew();
	Assert.assertTrue(program.addingMandatoryFields(Name,Description,Status).equals(expectedMsg));
	}
	

	@Then("Admin gets message Class added Successfully")
	public void admin_gets_message_class_added_successfully() {
		LoggerLoad.info("Program created successfully");
	}

	@When("Admin searches with newly created {string}")
	public void admin_searches_with_newly_created_program(String programName)  {
		
		program.clickProgram();
		program.enterProgramNameInSearch();
	}
	
	@Then("Records of the newly created {string} is displayed and match the data entered")
	public void record_displayed(String pName) {
		Assert.assertEquals(program.verifyProgramName(), pName);
		
	}
	
	@When("Admin clicks Cancel Icon on program Details form")
	public void admin_clicks_cancel_Icon()  {
		program.clickProgramAddNew();
		program.cancelDisp();
		
	}
	
	@Then("Program Details popup window should be closed")
	public void program_details_should_closed() {
		status=program.onManagePage();
	Assert.assertTrue(status);
		LoggerLoad.info("Admin is on manage program page");
		
		
	}
	
//*************************************************Edit Program*******************************
	
	@When("Admin clicks Edit New Program under program navigation bar")
	public void admin_clicks_edit_new_class_under_class_navigation_bar() throws InterruptedException {
		program.clickProgram();
		 program.clickOnEdit();
	}
	
	@When("Admin should see the Program details pop-up window by clicking the edit icon for any program")
	public void admin_should_see_the_program_details_pop_up_window_by_clicking_the_edit_icon_for_any_program() throws InterruptedException {		
		 program.clickProgram();
		 program.clickOnEdit();    
	}

	@Then("Admin should see the Program name field")
	public void admin_should_see_the_program_name_field() {
		Assert.assertEquals(program.programNameText().replaceAll("[^a-zA-Z ]", "").trim(), "Name");
	    
	}

	@When("Update the fields with valid data {string} and click save")
	public void update_the_fields_with_valid_data_and_click_save(String editDesc) {
		program.clickProgram();
		 program.clickOnEdit();  
		program.editProgramDetails(editDesc);
	    
	}

	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
		Assert.assertEquals("Updated program Successfully", string, program.saveEditProgram());
	   
	}

	
		
//******************************************Delete ***************************************************
	
	
	@Given("Admin is on the program page")
	public void admin_is_on_the_program_page() {
		program.clickProgram();
	}

	@When("Admin clicks on the delete icon under the Manage program header")
	public void admin_clicks_on_the_delete_icon_under_the_manage_program_header() {
	    program.clickDeleteIconForSpecificProgram();
	}
	
	@Then("Admin should see the box is disabled")
	public void admin_should_see_the_box_disabled() {
	Assert.assertFalse(program. IsDeleteButtonEnabled());
	}
	
	@When("Admin Should click the Enabled Delete icon on the datatable")
	public void admin_should_click_the_enabled_delete_icon_on_the_datatable() {
		program.clickOnDeleteButtonInTable();
		
	}

	@Then("Admin should see the Delete confirmation popup box in program page")
	public void admin_should_see_the_delete_confirmation_popup_box_program() {
		;
		LoggerLoad.info("Display Delete pop up window");
		         
	}
	
	@When("Admin clicks on the yes button on popup")
	public void admin_clicks_on_the_yes_button_popup() {
		program.clickOnDeleteButtonInTable();
		program.confirmDeletion();		
	}
	
	@Then("The respective row in the table should be deleted on program page")
	public void the_respective_row_in_the_table_should_be_deleted() {		
		String expectedMessage = "Successful" + System.lineSeparator() + "Program Deleted";
		String actualMessage = program.getSuccessMessageText().trim().replaceAll("\\s+", " "); 
		Assert.assertEquals(expectedMessage.replaceAll("\\s+", " "), actualMessage);
       	}
	
	@When("Admin clicks on the delete icon under the Manage program header multiple delete")
	public void admin_clicks_on_the_delete_icon_under_the_manage_program_header_multiple_delete() {
		program.multipleDeleteactions();
		program.clickOnHeaderDeleteIcon();
		program.confirmDeletion();
		
	}

	@Then("The respective row in the table should be deleted in program module")
	public void the_respective_row_in_the_table_should_be_deleted_in_program_module() {
		String expectedMessage = "Successful" + System.lineSeparator() + "Programs Deleted";
		String actualMessage = program.getSuccessMessageText().trim().replaceAll("\\s+", " "); 
		Assert.assertEquals(expectedMessage.replaceAll("\\s+", " "), actualMessage);
      
	}

	
//***********************************************Search****************************************************
	
	
	@When("Admin enter the {string} {string} in search textbox")
	public void admin_enter_the_in_search_textbox(String field, String value) throws InterruptedException {
		status = program.searchBoxValidation(field, value);
		 Assert.assertTrue(status);
	}

	@Then("Admin should see Program details are searched by given fields")
	public void admin_should_see_class_details_are_searched_by() {
		// Assert.assertTrue(status);
		 LoggerLoad.info("Record found");
		}
	

	@When("Admin enter the program to search By program name that does not exist")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist() {
		 status1=program.InValidValueInSearchBox();
	    
	}

	@Then("There should be zero results.")
	public void there_should_be_zero_results() {
		Assert.assertTrue(status1);
		LoggerLoad.info("No entries found");
	    
	}

	@When("Admin enter the program to search By partial name of program")
	public void admin_enter_the_program_to_search_by_partial_name_of_program() {
	    
	}

//*******************************************Sorting*********************************************
	
	@When("Admin clicks on Arrow next to program Name of Program module page for sort")
	public void admin_clicks_on_Arrow_next_to_program_Name_of_Program_module_page_for_sort() {
		program.clickProgramNameSort();
	}

	@Then("Admin See the Program Name is sorted Ascending order in Program module page for sort")
	public void admin_See_the_Program_Name_is_sorted_Ascending_order_in_Program_module_page_for_sort() {
		List<String> originalList = program.getOriginalList("progName");
		List<String> sortedList = program.getSortedList(originalList);
		System.out.println("sorted name list" + sortedList.toString() );
		Assert.assertTrue(originalList.equals(sortedList));		
	}


	@When("Admin clicks on Arrow next to program Name of Program module page for sort descend")
	public void admin_clicks_on_Arrow_next_to_program_Name_of_Program_module_page_for_sort_descend() {
		program.clickProgramNameSortDec();
	}
	
	@Then("Admin See the Program Name is sorted Descending order in Program module page")
	public void admin_See_the_Program_Name_is_sorted_Descending_order_in_Program_module_page() {
		List<String> originalList = program.getOriginalList("progName");
		List<String> sortedList = program.getSortedListDescending(originalList);
		System.out.println("Descending sorted name list " + sortedList.toString() );
		Assert.assertTrue(originalList.equals(sortedList));	    
	}


	@When("Admin clicks on Arrow next to program description of Program module page for sort")
	public void admin_clicks_on_Arrow_next_to_program_description_of_Program_module_page_for_sort() {
		program.clickProgramDescrSort();		
	}

	@Then("Admin See the Program description is sorted Ascending order in Program module page")
	public void admin_See_the_Program_description_is_sorted_Ascending_order_in_Program_module_page() {
		List<String> originalList = program.getOriginalList("ProgramDescription");
		List<String> sortedList = program.getSortedList(originalList);
		System.out.println("sorted name list" + sortedList.toString() );
		Assert.assertTrue(originalList.equals(sortedList));
	}


	@When("Admin clicks on Arrow next to program description of Program module page for sort descend")
	public void admin_clicks_on_Arrow_next_to_program_description_of_Program_module_page_for_sort_descend() {
		program.clickProgramDescrSortDes();		
	}

	@Then("Admin See the Program description is sorted Descending order in Program module page")
	public void admin_See_the_Program_description_is_sorted_Descending_order_in_Program_module_page() {
		List<String> originalList = program.getOriginalList("ProgramDescription");
		List<String> sortedList = program.getSortedListDescending(originalList);
		System.out.println("Descending sorted name list " + sortedList.toString() );
		Assert.assertTrue(originalList.equals(sortedList));
	}

	@When("Admin clicks on Arrow next to program status of Program module page for sort")
	public void admin_clicks_on_Arrow_next_to_program_status_of_Program_module_page_for_sort() {
		program.clickProgramStatusSort();
	}

	@Then("Admin See the Program status is sorted Ascending order in Program module page")
	public void admin_See_the_Program_status_is_sorted_Ascending_order_in_Program_module_page() {
		List<String> originalList = program.getOriginalList("status");
		List<String> sortedList = program.getSortedList(originalList);
		System.out.println("sorted name list" + sortedList.toString() );
		Assert.assertTrue(originalList.equals(sortedList));
	}
	
	@When("Admin clicks on Arrow next to program status of Program module page for sor descend")
	public void admin_clicks_on_Arrow_next_to_program_status_of_Program_module_page_for_sor_descend() {
		program.clickProgramStatusSortDes();
	}

	@Then("Admin See the Program status is sorted Descending order in Program module page")
	public void admin_See_the_Program_status_is_sorted_Descending_order_in_Program_module_page() {
		List<String> originalList = program.getOriginalList("status");
		List<String> sortedList = program.getSortedListDescending(originalList);
		System.out.println("Descending sorted name list " + sortedList.toString() );
		Assert.assertTrue(originalList.equals(sortedList));
	}

	
	
// **************************************Pagination****************************************
	
	
	 @When("Admin clicks the {string} link on the data table in program page")
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
	 @Then("Admin should see the {string} on the data table in program module")
	 public void adminShouldSeeResults(String expectedResult) {
	     switch (expectedResult.toLowerCase()) {
	         case "next enabled link":
	             Assert.assertTrue(program.isNextButtonEnabled());
	             break;
	         case "last page link with next disabled":
	             Assert.assertTrue(program.isNextButtonEnabled());
	             break;
	         case "previous page":
	             Assert.assertTrue(program.isPrevButtonEnabled());
	             break;
	         case "very first page":
	             Assert.assertFalse(program.isPrevButtonEnabled());
	             break;
	         default:
	             Assert.fail("Unexpected result description: " + expectedResult);
	     }
	 }
	 
	 
	 @When("Admin clicks on the logout button on the Manage Program")
		public void admin_clicks_on_the_logout_button() {
			program.clickLogout();
		}

		


}
	
	
	
	
	
	

