package stepDefinitions;

import org.testng.Assert;


import static org.testng.Assert.assertEquals;

import java.time.Duration;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import appHook.Hooks;
import appHook.TestContext;
import common.LoggerLoad;

import pages.Login_Page;
import pages.Batch_Page;

public class BatchStep {
	private JavascriptExecutor js;
	private WebDriverWait wait;
	private Login_Page Login;
	private Batch_Page Batch;

	private WebDriver driver;
	private TestContext context;
	List<Map<String, String>> Loginxl = Hooks.Login;

	public BatchStep(TestContext context) {
		this.context = context;
		this.driver = context.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.Login = new Login_Page(driver, context);
		this.Batch = new Batch_Page(driver, context);

		this.js = (JavascriptExecutor) this.driver;
	}

	@Given("Admin is logged into the LMS portal and on the dashboard page")
	public void admin_is_logged_into_the_lms_portal_and_on_the_dashboard_page() {
		Login.AdminLogin();
	}

//	@Batch_01_Scenario: Verify Admin Navigate to Batch page successfully

	@Given("Admin is on LMS Homepage")
	public void admin_is_on_lms_homepage() {
		String Title = Batch.getPageTitle();
		assertEquals(Title, "LMS");

	}

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
		Batch.navigateToBatch();
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
		String Title = Batch.getPageTitle();
		assertEquals(Title, "LMS");

	}
//	@Batch_02 _Scenario Outline: Batch Page Elements Validation

	@Given("Admin is on the home page")
	public void admin_is_on_the_home_page() {

		String Title = Batch.getPageTitle();
		assertEquals(Title, "LMS");

	}

	@Then("Admin should see the {string} on the Batch page")
	public void admin_should_see_the_on_the_batch_page(String expectedText) {

		LoggerLoad.debug("Validating expected text in the Batch Page: " + expectedText);

		switch (expectedText) {
		case "LMS - Learning Management System":
			Assert.assertTrue(Batch.isToolbarTextCorrect("LMS - Learning Management System"));
			break;

		case "Manage Batch":
			Assert.assertTrue(Batch.isHeaderTextCorrect("Manage Batch"));
			break;

		case "datatable headers: Batch name, Batch Description, Batch Status, No Of classes, Program Name, Edit/Delete":

			Batch.validateHeaders();
			break;

		case "disabled Delete Icon under the header":
			Assert.assertTrue(Batch.isMultipleDeleteIconDisabled());
			break;

		case "enabled pagination controls under the data table":

			Assert.assertTrue(Batch.arePaginationControlsEnabled());
			break;

		case "edit icon in each data row":

			Assert.assertTrue(Batch.areEditButtonsDisplayed());
			break;

		case "delete icon in each data row":

			Assert.assertTrue(Batch.areDeleteButtonsDisplayed());
			break;

		case "checkbox in each data row":

			Assert.assertTrue(Batch.areCheckboxesDisplayed());
			break;

		case "checkbox in the datatable header row":
			Assert.assertTrue(Batch.isCheckboxHeaderDisplayed());
			break;
		case "sort icon next to all datatable headers":
			Assert.assertTrue(Batch.areSortingIconsDisplayed());
			break;
		case "Footer":
			Assert.assertTrue(Batch.isFooterTextCorrect("Manage Batch"));
			break;

		default:
			Assert.fail("Unexpected element: " + expectedText);
		}

	}
//	@Batch_03_Scenario Outline: Verify sub menu displayed in batch menu bar

	@Given("Admin is on batch page")
	public void admin_is_on_batch_page() {

		String Title = Batch.getPageTitle();
		assertEquals(Title, "LMS");
	}

	@When("Admin clicks {string} under batch menu bar")
	public void admin_clicks_under_batch_menu_bar(String button) {
		Batch.navigateToBatch();
		Batch.clickAddNewBatchButton();
	}

	@Then("Admin should see the Batch Details pop up window {string}")
	public void admin_should_see_the_batch_details_pop_up_window(String field) {
		LoggerLoad.debug("pop label.");
		Assert.assertTrue(Batch.isFieldDisplayed(field));
//		Assert.assertEquals(field, Batch.isFieldDisplayed(field));
	}
//	@Batch_04_Scenario: Validate batchname prefix selected program name

	@Given("Admin is on the Batch Details Pop Up Window")
	public void admin_is_on_the_batch_details_pop_up_window() {
		Batch.navigateToBatch();
		Batch.clickAddNewBatchButton();

	}

	@When("Admin selects program name present in the dropdown")
	public void admin_selects_program_name_present_in_the_dropdown() {
		LoggerLoad.info("Dropdown");
		Batch.selectProgramFromDropdown();
	}

	@Then("Admin should see selected program name in the batch name prefix box")
	public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
		String expectedmessage = Batch.ProgramnametextText();
		String actualmessage = Batch.ProgramnamePrefixText();
		Batch.Clickprefixbatchname();
		Assert.assertEquals(actualmessage, expectedmessage);
	}

	// @Batch_05_Scenario Outline: Validate batch name suffix box should accept only
	// numbers

	@When("Admin enters alphabets and alphanumeric and special character in {string} suffix box")
	public void admin_enters_alphabets_and_alphanumeric_and_special_character_in_suffix_box(String BatchName) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Batch.enterBatchNameSuffix(BatchName);

	}

	@Then("Admin should get {string} below the text box of respective field")
	public void admin_should_get_below_the_text_box_of_respective_field(String expected_message) {
		LoggerLoad.debug("Validating expected text in the AddnewBatch popup Page: " + expected_message);
		String actualMessage = Batch.getErrorMessage().trim();
		System.out.println("Actual Message: " + actualMessage);
		Assert.assertEquals(actualMessage, expected_message);

	}

//	@Batch_06_Scenario: Validate batch name prefix box is not editable

	@When("Admin enters alphabets in batch name prefix box")
	public void admin_enters_alphabets_in_batch_name_prefix_box() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Batch.selectProgramFromDropdown();
		Batch.inputPrefixValue();
	}

	@Then("Admin should see empty text box")
	public void admin_should_see_empty_text_box() {
		Assert.assertTrue(Batch.validateBatchTextBoxNonEditable());
	}

//	@Batch_07_Scenario: Validate input data only for mandatory fields

	@When("Admin enters the data only to the mandatory fields and clicks save button")
	public void admin_enters_the_data_only_to_the_mandatory_fields_and_clicks_save_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Batch.selectProgramFromDropdown();
		Batch.enterValidDataAllMandatoryFields();
		Batch.clickSaveButton();
	}

	@Then("Admin should get a successful message {string}")
	public void admin_should_get_a_successful_message(String string) {
		Assert.assertTrue(Batch.isSuccessMessageDisplayed());

	}

//	@Batch_08_Scenario: validate input data missing for mandatory fields

	@When("Admin leaves blank one of the mandatory fields")
	public void admin_leaves_blank_one_of_the_mandatory_fields() {
		Batch.selectProgramFromDropdown();
		Batch.clickSaveButton();
	}

	@Then("Admin should get a error message on the respective mandatory field")
	public void admin_should_get_a_error_message_on_the_respective_mandatory_field() {

		Assert.assertTrue(Batch.isDescriptionErrorDisplayed());
		Assert.assertTrue(Batch.isNumberOfClassesErrorDisplayed());
	}

//	@Batch_09_Scenario: validate cancel button in Batch details pop up

	@When("Admin enters the valid data to all the mandatory fields and click cancel button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Batch.selectProgramFromDropdown();
		Batch.enterValidDataAllMandatoryFields();
		Batch.clickCancelButton();

	}

	@Then("Admin can see the batch details popup closes without creating any batch")
	public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch() {
		Batch.toolbarVisible();

	}

//	@Batch_10_Scenario: validate close icon on the batch details pop up

	@When("Admin clicks on the close icon")
	public void admin_clicks_on_the_close_icon() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Batch.selectProgramFromDropdown();
		Batch.enterValidDataAllMandatoryFields();
		Batch.clickCloseButton();

	}

	@Then("Admin can see batch details pop up closes")
	public void admin_can_see_batch_details_pop_up_closes() {
		Batch.toolbarVisible();
	}

//	@Batch_11_Scenario: Validate Edit icon feature in any row

	@Given("Admin is on the Batchs page")
	public void admin_is_on_the_batchs_page() {
		Batch.navigateToBatch();

	}

	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() {
		Batch.clickAddNewBatchButton();
		Batch.clickCloseButton();
		Batch.clickBatchEditButton();
	}

	@Then("Admin should see the Batch details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {

		Assert.assertTrue(Batch.isBatcheditpopupdisplayed());
	}

//	@Batch_12 _Scenario: Validate program name value is disabled to edit

	@Then("Admin should see Program name and Batch name value field is disabled for editing")
	public void admin_should_see_program_name_and_batch_name_value_field_is_disabled_for_editing() {
		Assert.assertTrue(Batch.isProgramNameFieldDisabled());
		Assert.assertTrue(Batch.isEditBatchNameFieldDisabled());
	}

//	@Batch_13_Scenario: Validate editing description and No. of classes fields with invalid data in the pop up

	@When("Admin Updates any fields with invalid data and click save button")
	public void admin_updates_any_fields_with_invalid_data_and_click_save_button() {
		Batch.clickAddNewBatchButton();
		Batch.clickCloseButton();
		Batch.clickBatchEditButton();
		Batch.enterinValidDataAllMandatoryFields();
		Batch.clickSaveButton();
	}

	@Then("Admin should get a error message under the respective field")
	public void admin_should_get_a_error_message_under_the_respective_field() {

		Assert.assertTrue(Batch.isEditBatchDescriptionErrorDisplayed());
	}

//	@Batch_14_Scenario: validate save button in Batch details pop up 

	@When("Admin enters the valid data to all the mandatory fields and click save button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button() {
		Batch.clickAddNewBatchButton();
		Batch.clickCloseButton();
		Batch.clickBatchEditButton();
		Batch.enterValidDataBatcheditAllMandatoryFields();
		Batch.clickSaveButton();
	}

	@Then("Admin should get a successful message for editing the batch")
	public void admin_should_get_a_successful_message_for_editing_the_batch() {

		Assert.assertTrue(Batch.isSuccessMessageDisplayed());
	}

//	@Batch_15_Scenario: validate cancel button in Batch details pop up  

	@When("Admin enters the valid data in edit btach to all the mandatory fields and click cancel button")
	public void admin_enters_the_valid_data_in_edit_btach_to_all_the_mandatory_fields_and_click_cancel_button() {
		Batch.clickAddNewBatchButton();
		Batch.clickCloseButton();
		Batch.clickBatchEditButton();
		Batch.enterValidDataBatcheditAllMandatoryFields();
		Batch.clickCancelButton();
	}

	@Then("Admin can see the batch details popup closes without editing the batch")
	public void admin_can_see_the_batch_details_popup_closes_without_editing_the_batch() {
		Batch.toolbarVisible();
	}

//	@Batch_16_Scenario:validate close button in Batch details pop up    

	@When("Admin enters the valid data to all the mandatory fields and click close button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_close_button() {
		Batch.clickAddNewBatchButton();
		Batch.clickCloseButton();
		Batch.clickBatchEditButton();
		Batch.enterValidDataBatcheditAllMandatoryFields();
		Batch.clickCloseButton();
	}

//	@Batch_17_Scenario: validate delete Icon on any row

	@When("Admin clicks the delete Icon on any row")
	public void admin_clicks_the_delete_icon_on_any_row() {
		Batch.clickAddNewBatchButton();
		Batch.clickCloseButton();
		Batch.clickOnDeleteIcon();
	}

	@Then("Admin should see the confirm alert box with yes and no button")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button() {

		Assert.assertTrue(Batch.isDeletePopUpDisplayed());
	}

//	@Batch_18_Scenario: Validate yes button on the confirm alert box

	@Given("Admin is on the batch confirm popup page")
	public void admin_is_on_the_batch_confirm_popup_page() {
		Batch.navigateToBatch();
		Batch.clickAddNewBatchButton();
		Batch.clickCloseButton();
		Batch.clickOnDeleteIcon();
	}

	@When("Admin clicks on the delete icon and click yes button")
	public void admin_clicks_on_the_delete_icon_and_click_yes_button() {
		Batch.confirmDeletion();
	}

	@Then("Admin should see the successful message and the batch should be deleted")
	public void admin_should_see_the_successful_message_and_the_batch_should_be_deleted() {
		Batch.getSuccessMessageText();
	}

//	@Batch_19_Scenario: validate no button on the confirm alert box

	@When("Admin clicks on the delete icon and click no button")
	public void admin_clicks_on_the_delete_icon_and_click_no_button() {
		Batch.cancelDeletion();
	}

	@Then("Admin should see the alert box closed and the batch is not deleted")
	public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted() {
		Batch.toolbarVisible();
	}

//	@Batch_20_Scenario: validate close Icon on the alert box

	@When("Admin clicks on the close icon on deletewindow")
	public void admin_clicks_on_the_close_icon_on_deletewindow() {
		Batch.CloseDletePopup();
	}

	@Then("Admin should see the alert box closed")
	public void admin_should_see_the_alert_box_closed() {

		Batch.toolbarVisible();
	}

//	@Batch_21_Scenario: Validate single row delete with checkbox

	@Given("Admin is on the batch page")
	public void admin_is_on_the_batch_page() {
		Batch.navigateToBatch();
		Batch.clickAddNewBatchButton();
		Batch.clickCloseButton();
	}

	@When("Admin clicks on the delete icon under the Manage batch header")
	public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header() {
		Batch.clickDeleteIconForSpecificBatch();
	}

	@Then("Admin should see the box get highlighted")
	public void admin_should_see_the_box_get_highlighted() {
		LoggerLoad.info("The Admin Selected box high lighted");

	}

//	@Batch_22_Scenario: Validate single row delete with checkbox

	@When("Admin Should click the Enabled Delete icon on the header")
	public void admin_should_click_the_enabled_delete_icon_on_the_header() {
		Batch.clickDeleteIconForSpecificBatch();
		Batch.clickOnHeaderDeleteIcon();
	}

	@Then("Admin should see the Delete confirmation popup box")
	public void admin_should_see_the_delete_confirmation_popup_box() {
		Assert.assertTrue(Batch.isDeletePopUpDisplayed());
	}

//	@Batch_23_Scenario: Validate single row delete with checkbox

	@When("Admin clicks on the yes button")
	public void admin_clicks_on_the_yes_button() {
		Batch.clickDeleteIconForSpecificBatch();
		Batch.clickOnHeaderDeleteIcon();
		Batch.confirmDeletion();
	}

	@Then("The respective row in the table should be deleted")
	public void the_respective_row_in_the_table_should_be_deleted() {
		String expectedMessage = "Success[fully batch deleted]";
		String actualMessage = Batch.getSuccessMessageText();
		System.out.println("Actual Message: " + actualMessage);
		Assert.assertEquals("Successful" + System.lineSeparator() + "Batches Deleted", actualMessage);
	}

//	@Batch_24_Scenario: Validate multiple row delete with checkbox

	@When("Admin clicks on the delete icon under the Manage batch header multiple delete")
	public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header_multiple_delete() {

		Batch.multipleDeleteAction();
		Batch.clickOnHeaderDeleteIcon();
		Batch.confirmDeletion();
	}

	@Then("The respective row in the table should be deleted in batch module")
	public void the_respective_row_in_the_table_should_be_deleted_in_batch_module() {

		String expectedMessage = "Success[fully batch deleted]";
		String actualMessage = Batch.getSuccessMessageText();
		System.out.println("Actual Message: " + actualMessage);
		Assert.assertEquals("Successful" + System.lineSeparator() + "Batches Deleted", actualMessage);
	}

//	@Batch_25_Scenario Outline: Validate pagination links

	@When("Admin clicks the {string} link on the data table Batch module")
	public void admin_clicks_the_link_on_the_data_table_batch_module(String pageLink)

			throws InterruptedException {

		switch (pageLink.toLowerCase()) {
		case "Next":
			Batch.clickNextPage();
			break;
		case "Last":
			Batch.clickLastPage();
			break;
		case "Previous":
			Batch.clickPreviousPage();
			break;
		case "First":
			Batch.clickFirstPage();
			break;
		}

	}

	@Then("Admin should see the {string} results on the data table Batch Module")
	public void admin_should_see_the_results_on_the_data_table_batch_module(String expectedresult) {

		switch (expectedresult.toLowerCase()) {
		case "next enabled link":
			Assert.assertTrue(Batch.isNextButtonEnabled());
			break;
		case "last page link with Next disabled":
			Assert.assertTrue(Batch.isNextButtonEnabled());
			break;
		case "previous results":
			Assert.assertTrue(Batch.hasNextPageResults());
			break;
		case "first results":
			Assert.assertTrue(Batch.hasNextPageResults());
			break;
		default:
			Assert.fail("Unexpected result description: " + expectedresult);
		}
	}

//	@Batch_26_Scenario Outline: validate search box functionality

	@When("Admin enters the {string} in the search text box in the batch module")
	public void admin_enters_the_in_the_search_text_box_in_the_batch_module(String SearchData) {
		Batch.searchInBatchPage(SearchData);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@Then("Admin should see the {string},{string},{string} filtered batches in the data table in Batch")
	public void admin_should_see_the_filtered_batches_in_the_data_table_in_batch(String BatchName, String BatchDesc,
			String status) {

		String actualBatchName = Batch.FirstbatchnameText();
		String actualBatchDesc = Batch.FirstbatchdescText();
		String actualStatus = Batch.FirstbatchstatusText();
		Assert.assertEquals(BatchName, actualBatchName);
		Assert.assertEquals(BatchDesc, actualBatchDesc);
		Assert.assertEquals(status, actualStatus);

		System.out.println("Batch verification passed!");
	}

//	@Batch_27_Scenario Outline: invalidate search box functionality

	@When("Admin enters invalid {string} in the search text box in the batch module")
	public void admin_enters_invalid_in_the_search_text_box_in_the_batch_module(String SearchData) {
		Batch.searchInBatchPage(SearchData);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Then("Admin should see the no records found in the data table in Batch")
	public void admin_should_see_the_no_records_found_in_the_data_table_in_batch() {
		Batch.verifyZeroRecordText();
		String actualmessage = Batch.Invalidsearchdataresult();
		System.out.println(actualmessage + "No Batch Found");

	}

//	@Batch_28_Scenario Outline: Partial Batchname search box functionality

	@When("Admin enters PartialBatch name {string} in the search text box in the batch module")
	public void admin_enters_partial_batch_name_in_the_search_text_box_in_the_batch_module(String SearchData) {
		Batch.searchInBatchPage(SearchData);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Then("Admin should see the all batch with the same name in the data table in Batch")
	public void admin_should_see_the_all_batch_with_the_same_name_in_the_data_table_in_batch() {
		Batch.verifyMultipleRecordText();
		String actualmessage = Batch.PartialbatchNamesearchdataresult();
		System.out.println(actualmessage + "All Batch with the name Batch Found");
	}

//	@Batch_29_Scenario: Validate logout option in the header is visible and enabled from the batch page

	@When("Admin clicks on the logout button")
	public void admin_clicks_on_the_logout_button() {
		Batch.Logoutbutton();

	}

	@Then("Admin should see the Login screen Page")
	public void admin_should_see_the_login_screen_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}

}
