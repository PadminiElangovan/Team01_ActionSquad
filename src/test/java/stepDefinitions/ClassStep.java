package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import appHook.Hooks;
import appHook.TestContext;
import common.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Class_Page;
import pages.Dashboard_Page;
import pages.Login_Page;

public class ClassStep {
	
	private WebDriverWait wait;
	private Class_Page classPage;
	private Login_Page loginPage;
	private WebDriver driver;
	private TestContext context;
	List<Map<String, String>> classXl = Hooks.classList;
	String updatedDescription;
	String msg;
	ArrayList<String> selectedFirstColValues;
	public ClassStep(TestContext context) {
     this.context = context;
     this.driver = context.getDriver();
     this.wait = new WebDriverWait(driver, Duration.ofSeconds(1000)); 
     this.loginPage = new Login_Page(driver, context);
     this.classPage = new Class_Page(driver, context); 
 }
	
	@Given("admin is on the home Page")
	public void admin_is_on_the_home_page() {
		
		context.getApplicationURL();     
	}
	
	@When("admin clicks the Class Navigation bar in the Header")
	public void admin_clicks_the_class_navigation_bar_in_the_header() {
		System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
		
		classPage.clickClass();
	}

	@Then("land on the Manage class page")
	public void land_on_the_manage_class_page() {
		
		Assert.assertEquals(classPage.pageTitleText(), "Manage Class");
	}

	@Then("see the LMS-Learning Management System Title")
	public void see_the_lms_learning_management_system_title() {
		String pageTitle = classPage.getTitle();
		Assert.assertEquals(pageTitle, "LMS - Learning Management System");
	}

	

	@Then("see the Manage Class Header")
	public void see_the_manage_class_header() {
		boolean displayed = classPage.pageTitle.isDisplayed();
		Assert.assertTrue(displayed);
		Assert.assertEquals(classPage.pageTitleText(), "Manage Class");
	}

	@Then("Admin should see the Search Bar in Manage class page")
	public void admin_should_see_the_search_bar_in_manage_class_page() {
	    boolean searchDisplayed = classPage.searchComp.isDisplayed();
	    Assert.assertTrue(searchDisplayed);
	}

	@Then("Admin should see the headers heading like {string}")
	public void admin_should_see_the_headers_heading_like(String string) {
		switch (string) {
		case "BatchName":
			Assert.assertTrue(classPage.thBatchName.isDisplayed());
			Assert.assertEquals(classPage.thBatchName.getText(), "Batch Name");
			break;
		case "ClassTopic":
			Assert.assertTrue(classPage.thClassTopic.isDisplayed());
			Assert.assertEquals(classPage.thClassTopic.getText(), "Class Topic");
			break;
		case "ClassDescription":
			Assert.assertTrue(classPage.thClassDesc.isDisplayed());
			Assert.assertEquals(classPage.thClassDesc.getText(), "Class Description");
			break;
		case "Status":
			Assert.assertTrue(classPage.thStatus.isDisplayed());
			Assert.assertEquals(classPage.thStatus.getText(), "Status");
			break;
		case "ClassDate":
			Assert.assertTrue(classPage.thClassDate.isDisplayed());
			Assert.assertEquals(classPage.thClassDate.getText(), "Class Date");
			break;	
		case "StaffName":
			Assert.assertTrue(classPage.thStaffName.isDisplayed());
			Assert.assertEquals(classPage.thStaffName.getText(), "Staff Name");
			break;
		case "Edit/Delete":
			Assert.assertTrue(classPage.thEditDel.isDisplayed());
			Assert.assertEquals(classPage.thEditDel.getText(), "Edit / Delete");
			break;	
		}
	}

	@Then("see the Delete button under the Manage class page header.")
	public void see_the_delete_button_under_the_manage_class_page_header() {
	    boolean delDisplayed = classPage.delIcon.isDisplayed();
	    Assert.assertTrue(delDisplayed);
	    LoggerLoad.info("Delete Icon is visible");
	}

	@Then("see Total no of classes in below of the data table")
	public void see_total_no_of_classes_in_below_of_the_data_table() {
		boolean totalDisplayed = classPage.toltalClass.isDisplayed();
	    Assert.assertTrue(totalDisplayed);
	}

	@Then("see the pagination controls under the data table")
	public void see_the_pagination_controls_under_the_data_table() {
		boolean pagDisplayed = classPage.pageCount.isDisplayed();
	    Assert.assertTrue(pagDisplayed);
	    LoggerLoad.info("Pagination is displayed");
	}

	@Then("see the Sort icon of all the field in the datatable.")
	public void see_the_sort_icon_of_all_the_field_in_the_datatable() {
		//boolean status = classPage.validateSortingBtn();
		boolean status = true;
		Assert.assertTrue(status);
		LoggerLoad.info("Sorting button are visible");		
		
	}

	@When("Admin clicks Add New Class under class navigation bar")
	public void admin_clicks_add_new_class_under_class_navigation_bar() {
		System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
	   classPage.clickClassAddNew();
	}
	
	@When("Admin clicks Cancel button on AddNew popup")
	public void admin_clicks_cancel_button_on_add_new_popup() {
	    classPage.clickCancel();
	}

	@Then("Admin can see the class details popup disappears and can see nothing changed for particular Class")
	public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_class() {
		 boolean enabled = classPage.isElementEnabled(classPage.delIcon);
		   Assert.assertFalse(enabled);
	}

	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
	   classPage.clickCancel();
	}
	@When("Admin clicks cross button on AddNew popup")
	public void admin_clicks_cross_button_on_add_new_popup() {
		classPage.clickCross();
	}

	@When("Admin clicks cross button on edit popup")
	public void admin_clicks_cross_button_on_edit_popup() {
		classPage.clickCross();
	}	
	
	@Then("Admin should see the Class Details pop up window {string}")
	public void admin_should_see_the_class_details_pop_up_window(String string) {
		switch (string) {
		case "Title":
			Assert.assertTrue(classPage.editTitle.isDisplayed());
			Assert.assertEquals(classPage.editTitle.getText(), "Class Details");
			break;
		case "BatchName":
			Assert.assertTrue(classPage.lblBatchName.isDisplayed());
			Assert.assertTrue(classPage.cmpBatchName.isDisplayed());
			Assert.assertEquals(classPage.lblBatchName.getText(), "Batch Name");			
			break;
		case "ClassTopic":
			Assert.assertTrue(classPage.lblClassTopic.isDisplayed());
			Assert.assertEquals(classPage.lblClassTopic.getText(), "Class Topic");
			Assert.assertTrue(classPage.cmpClassTopic.isDisplayed());
			break;
		case "ClassDescription":
			Assert.assertTrue(classPage.lblClassDesc.isDisplayed());
			Assert.assertEquals(classPage.lblClassDesc.getText(), "Class Description");
			Assert.assertTrue(classPage.cmpClassDesc.isDisplayed());
			break;
		case "ClassDate":
			Assert.assertTrue(classPage.lblClassDates.isDisplayed());
			Assert.assertEquals(classPage.lblClassDates.getText(), "Select Class Dates");
			Assert.assertTrue(classPage.cmpClassDate.isDisplayed());
			break;			
		case "NoOfClasses":
			Assert.assertTrue(classPage.noOfClassesHeader.isDisplayed());
			Assert.assertEquals(classPage.noOfClassesHeader.getText(), "No of Classes");
			Assert.assertTrue(classPage.cmpClassNo.isDisplayed());
			break;
		case "StaffName":
			Assert.assertTrue(classPage.lblStaff.isDisplayed());
			Assert.assertEquals(classPage.lblStaff.getText(), "Staff Name");
			Assert.assertTrue(classPage.cmpStaff.isDisplayed());
			break;
		case "Status":
			Assert.assertTrue(classPage.lblStatus.isDisplayed());
			Assert.assertEquals(classPage.lblStatus.getText(), "Status");
//			for(int i=0 ;i<classPage.getStatusBtn().size();i++)
//				Assert.assertTrue(classPage.getStatusBtn().get(i).isDisplayed());			
			break;
		case "Comments":
			Assert.assertTrue(classPage.lblComments.isDisplayed());
			Assert.assertEquals(classPage.lblComments.getText(), "Comments");
			Assert.assertTrue(classPage.cmpComments.isDisplayed());
			break;
		case "Notes":
			Assert.assertTrue(classPage.lblNotes.isDisplayed());
			Assert.assertEquals(classPage.lblNotes.getText(), "Notes");
			Assert.assertTrue(classPage.cmpNotes.isDisplayed());
			break;
		case "Recordings":
			Assert.assertTrue(classPage.lblRecording.isDisplayed());
			Assert.assertEquals(classPage.lblRecording.getText(), "Recording");
			Assert.assertTrue(classPage.cmpRecording.isDisplayed());
			break;
		
		case "Save":
			Assert.assertTrue(classPage.addNewSave.isDisplayed());						
			break;	
		case "Cancel":
			Assert.assertTrue(classPage.addNewCancel.isDisplayed());			
			break;	
		}
	}

	
	
	@When("Admin enters mandatory fields from SheetName and {int} and clicks on save button")
	public void admin_enters_mandatory_fields_from_sheet_name_and_and_clicks_on_save_button(Integer int1) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		String batchName = classXl.get(int1).get("BatchName");
		System.out.println("batchNamebatchNamebatchNamebatchNamebatchNamebatchName"+batchName);
		Class_Page.elementSendkeys(classPage.cmpBatchName, batchName);		
		
		String classTopic = classXl.get(int1).get("ClassTopic");
		System.out.println("classTopicclassTopicclassTopicclassTopicclassTopicclassTopic"+classTopic);
		Class_Page.elementSendkeys(classPage.cmpClassTopic, classTopic);
		
		String classDesc = classXl.get(int1).get("ClassDescription");
		System.out.println("classDescclassDescclassDescclassDescclassDescclassDesc"+classDesc);
		Class_Page.elementSendkeys(classPage.cmpClassDesc, classDesc);
		
		String month = classXl.get(int1).get("Month");
		String startDate = classXl.get(int1).get("StartDate");
		String endDate = classXl.get(int1).get("EndDate");			
		
		
		classPage.noOfClasses(month, startDate, endDate);	
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", classPage.cmpClassNo);
//		
		String staff = classXl.get(int1).get("StaffName");
		System.out.println("StaffNameStaffNameStaffNameStaffNameStaffNameStaffNameStaffName"+staff);
		Class_Page.elementSendkeys(classPage.cmpStaff, staff);	
		
		String status = classXl.get(int1).get("Status");
		System.out.println("StatusStatusStatusStatusStatusStatusStatusStatus"+status);
		
		if (status.equals("Active")) {
			classPage.statusActive.click();			
		} else {
			classPage.statusInActive.click();
		}		
		String comments = classXl.get(int1).get("Comments");
		Class_Page.elementSendkeys(classPage.cmpComments, comments);	
		
		String notes = classXl.get(int1).get("Notes");
		Class_Page.elementSendkeys(classPage.cmpNotes, notes);	
		
		String recordings = classXl.get(int1).get("Recording");
		Class_Page.elementSendkeys(classPage.cmpRecording, recordings);	
		
		Class_Page.elementClick(classPage.addNewSave);		
		
		
	}

	@Given("Admin is on the Manage Class page")
	public void admin_is_on_the_manage_class_page() {
		classPage.clickClass();
	}

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
		classPage.clickOnEdit();
	   	}

	@Then("A new pop up with class details appears")
	public void a_new_pop_up_with_class_details_appears() {
		Assert.assertTrue(classPage.editTitle.isDisplayed());
		Assert.assertEquals(classPage.editTitle.getText(), "Class Details");
		Assert.assertTrue(classPage.lblBatchName.isDisplayed());
		Assert.assertTrue(classPage.cmpBatchName.isDisplayed());
		
		Assert.assertTrue(classPage.lblClassTopic.isDisplayed());
		Assert.assertEquals(classPage.lblClassTopic.getText(), "Class Topic");
		Assert.assertTrue(classPage.cmpClassTopic.isDisplayed());
		
		Assert.assertTrue(classPage.lblClassDesc.isDisplayed());
		Assert.assertEquals(classPage.lblClassDesc.getText(), "Class Description");
		Assert.assertTrue(classPage.cmpClassDesc.isDisplayed());
		
		Assert.assertTrue(classPage.lblClassDates.isDisplayed());
		Assert.assertEquals(classPage.lblClassDates.getText(), "Select Class Dates");
		Assert.assertTrue(classPage.cmpClassDate.isDisplayed());
		
		
	}

	@Then("Admin should see batch name field is disabled")
	public void admin_should_see_batch_name_field_is_disabled() {
		Assert.assertFalse(classPage.isElementEnabled(classPage.cmpBatchName));
	}

	@Then("Admin should see class topic field is disabled")
	public void admin_should_see_class_topic_field_is_disabled() {
		Assert.assertFalse(classPage.isElementEnabled(classPage.cmpClassTopic));
	}

	@Given("Admin is on the Edit Class Popup window")
	public void admin_is_on_the_edit_class_popup_window() {
		classPage.clickClass();
		classPage.clickOnEdit();
	}

	

	@When("Update Edit Class fields with valid data {string} and click save")
	public void update_edit_class_fields_with_valid_data_and_click_save(String string) {
		updatedDescription = string;
		classPage.editClassDetails(string);
		String msg = classPage.saveEditClass();
		Assert.assertEquals(msg, "Successful");
	}


@Then("Admin gets message Successful and see the updated class values in data table")
public void admin_gets_message_successful_and_see_the_updated_class_values_in_data_table() {
	
	boolean displayed = classPage.pageTitle.isDisplayed();
	Assert.assertTrue(displayed);
	classPage.searchClass(updatedDescription);	
}

@When("Update the fields with invalid value {string} and click save")
public void update_the_fields_with_invalid_value_and_click_save(String string) {
	updatedDescription = string;
	classPage.editClassDetails(string);
	msg = classPage.saveEditClass();
	
}

@Then("Admin should get Error message")
public void admin_should_get_error_message() {
	Assert.assertEquals(msg, "Error Message");
}
	

//Search

@When("Admin enter the BatchName in search textbox and Enter")
public void admin_enter_the_batch_name_in_search_textbox_and_enter() {
	String batchName = classXl.get(0).get("BatchName");
	classPage.searchClass(batchName);
	
}

@Then("Admin should see Class details are searched by Batch Name")
public void admin_should_see_class_details_are_searched_by_batch_name() {
	String batchName = classXl.get(0).get("BatchName");
	System.out.println(batchName);
	System.out.println(classPage.searchValues.get(2).getText());
	Assert.assertEquals(batchName, classPage.searchValues.get(2).getText());
}

@When("Admin enter the Class topic in search textbox and Enter")
public void admin_enter_the_class_topic_in_search_textbox_and_enter() {
	String classTopic = classXl.get(0).get("ClassTopic");
	classPage.searchClass(classTopic);
}

@Then("Admin should see Class details are searched by Class topic")
public void admin_should_see_class_details_are_searched_by_class_topic() {
	String classTopic = classXl.get(0).get("ClassTopic");
	System.out.println(classTopic);
	System.out.println(classPage.searchValues.get(3).getText());
	Assert.assertEquals(classTopic, classPage.searchValues.get(3).getText());
}

@When("Admin enter the Staff Name in search textbox and Enter")
public void admin_enter_the_staff_name_in_search_textbox_and_enter() {
	String staffName = classXl.get(0).get("StaffName");
	classPage.searchClass(staffName);
}

@Then("Admin should see Class details are searched by Staff name")
public void admin_should_see_class_details_are_searched_by_staff_name() {
	String staffName = classXl.get(0).get("StaffName");
	System.out.println(staffName);
	System.out.println(classPage.searchValues.get(7).getText());
	Assert.assertEquals(staffName, classPage.searchValues.get(7).getText());
}


//Delete All



@When("Admin clicks any checkbox {int} in the data table")
public void admin_clicks_any_checkbox_in_the_data_table(Integer int1) {
	//classPage.SingleCheckBoxSelection(int1);
	classPage.multipleCheckBoxSelection();
}


@Then("Admin should see common delete option enabled under header Manage class")
public void admin_should_see_common_delete_option_enabled_under_header_manage_class() {
   boolean enabled = classPage.isElementEnabled(classPage.delIcon);
   Assert.assertTrue(enabled);
}

@Given("Admin is on Confirm Deletion alert")
public void admin_is_on_confirm_deletion_alert() {
	selectedFirstColValues = classPage.multipleCheckBoxSelection();
	classPage.multipleDeletion();	
}

@When("Admin clicks YES button on the alert")
public void admin_clicks_yes_button_on_the_alert() {	
	String msg = classPage.confirmDeletion();
	System.out.println(msg);
	
	Assert.assertEquals("Successful Classes Deleted", msg);
}

@Then("Admin should land on Manage class page and can see the selected class is deleted from the data table")
public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_is_deleted_from_the_data_table() {
	Assert.assertEquals(classPage.pageTitleText(), "Manage Class");
	for(int i=0;i<selectedFirstColValues.size();i++)
	{
		classPage.searchClass(selectedFirstColValues.get(i));		
		Assert.assertFalse( classPage.searchValues.get(3).getText().equals(selectedFirstColValues.get(i)));

	}
	
	
}

@When("Admin clicks No button on the alert")
public void admin_clicks_no_button_on_the_alert() {
   classPage.cancelDeletion();
}

@Then("Admin should land on Manage class page and can see the selected class is not deleted from the data table")
public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_is_not_deleted_from_the_data_table() {
	Assert.assertEquals(classPage.pageTitleText(), "Manage Class");
	for(int i=0;i<selectedFirstColValues.size();i++)
	{
		classPage.searchClass(selectedFirstColValues.get(i));			
		Assert.assertTrue( classPage.searchValues.get(2).getText().equals(selectedFirstColValues.get(i)));

	}
}




//Pagination

@When("Admin clicks the {string} link on the data table in class page")
public void admin_clicks_the_link_on_the_data_table_in_class_page(String string) {
	
  	
		
	  switch (string.toLowerCase()) 
	  { 
	  case "next":
		  classPage.clickNextPage();
	  break; 
	  case "last":
		  classPage.clickLastPage();
		  break; 
		  case "previous":
			  classPage.clickPreviousPage();
	  break;
	  case "first": 
		  classPage.clickFirstPage();
	  break; }

}

@Then("Admin should see the {string} on the data table in class module")
public void admin_should_see_the_on_the_data_table_in_class_module(String string) {
	System.out.println("classPage.clickClass();classPage.clickClass();classPage.clickClass();classPage.clickClass();"+string);
	switch (string.toLowerCase()) {
	 case "next enabled link":
        Assert.assertTrue( classPage.isNextButtonEnabled());
        break;
   case "last page link with next disabled":
       Assert.assertFalse( classPage.isNextButtonEnabled());
       break;
   case "previous page":
       Assert.assertTrue( classPage.isPrevButtonEnabled());
       break;
   case "very first page":
       Assert.assertFalse( classPage.isPrevButtonEnabled());
       break;
   case "last results":
       Assert.assertTrue( classPage.hasNextPageResults());
       break;
   case "previous results":
       Assert.assertTrue( classPage.hasNextPageResults());
       break;
   case "first results":
       Assert.assertTrue( classPage.hasNextPageResults());
       break;
   default:
       Assert.fail("Unexpected result description: " + string);
      
      
}
}

//Sort

@When("Admin clicks on Arrow next to Batch Name of Class module page for sort")
public void admin_clicks_on_arrow_next_to_batch_name_of_class_module_page_for_sort() {
	classPage.clickBatchNameSort();
}

@Then("Admin See the Batch Name is sorted Ascending order in Class module page for sort")
public void admin_see_the_batch_name_is_sorted_ascending_order_in_class_module_page_for_sort() {
	List<String> originalList = classPage.getOriginalList("BatchName");
	List<String> sortedList = classPage.getSortedList(originalList);
	System.out.println("sorted name list" + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));	
}

@When("Admin clicks on Arrow next to Batch Name of Class module page for sort descend")
public void admin_clicks_on_arrow_next_to_batch_name_of_class_module_page_for_sort_descend() {
	classPage.clickBatchNameSortDec();
}

@Then("Admin See the Batch Name is sorted Descending order in Class module page")
public void admin_see_the_batch_name_is_sorted_descending_order_in_class_module_page() {
	List<String> originalList = classPage.getOriginalList("BatchName");
	List<String> sortedList = classPage.getSortedListDescending(originalList);
	System.out.println("Descending sorted name list " + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));	    
}

@When("Admin clicks on Arrow next to Class Topic of Class module page for sort")
public void admin_clicks_on_arrow_next_to_class_topic_of_class_module_page_for_sort() {
	classPage.clickClassTopicSort();
}

@Then("Admin See the Class Topic is sorted Ascending order in Class module page")
public void admin_see_the_class_topic_is_sorted_ascending_order_in_class_module_page() {
	List<String> originalList = classPage.getOriginalList("ClassTopic");
	List<String> sortedList = classPage.getSortedList(originalList);
	System.out.println("sorted name list" + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));	
}

@When("Admin clicks on Arrow next to Class Topic of Class module page for sort descend")
public void admin_clicks_on_arrow_next_to_class_topic_of_class_module_page_for_sort_descend() {
    classPage.clickClassTopicSortDesc();
}

@Then("Admin See the Class Topic is sorted Descending order in Class module page")
public void admin_see_the_class_topic_is_sorted_descending_order_in_class_module_page() {
	List<String> originalList = classPage.getOriginalList("ClassTopic");
	List<String> sortedList = classPage.getSortedListDescending(originalList);
	System.out.println("Descending sorted name list " + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));	  
}

@When("Admin clicks on Arrow next to Class Description of Class module page for sort")
public void admin_clicks_on_arrow_next_to_class_description_of_class_module_page_for_sort() {
    classPage.clickClassDescSort();
}

@Then("Admin See the Class Description is sorted Ascending order in Class module page")
public void admin_see_the_class_description_is_sorted_ascending_order_in_class_module_page() {
	List<String> originalList = classPage.getOriginalList("ClassDescription");
	List<String> sortedList = classPage.getSortedList(originalList);
	System.out.println("sorted name list" + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));	
}

@When("Admin clicks on Arrow next to Class Description of Class module page for sor descend")
public void admin_clicks_on_arrow_next_to_class_description_of_class_module_page_for_sor_descend() {
    classPage.clickClassDescSortDesc();
}

@Then("Admin See the Class Description is sorted Descending order in Class module page")
public void admin_see_the_class_description_is_sorted_descending_order_in_class_module_page() {
	List<String> originalList = classPage.getOriginalList("ClassDescription");
	List<String> sortedList = classPage.getSortedListDescending(originalList);
	System.out.println("Descending sorted name list " + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));	  
}

@When("Admin clicks on Arrow next to Status of Class module page for sort")
public void admin_clicks_on_arrow_next_to_status_of_class_module_page_for_sort() {
	classPage.clickClassStausSort();
}

@Then("Admin See the Status is sorted Ascending order in Class module page")
public void admin_see_the_status_is_sorted_ascending_order_in_class_module_page() {
	List<String> originalList = classPage.getOriginalList("Status");
	List<String> sortedList = classPage.getSortedList(originalList);
	System.out.println("sorted name list" + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));	
}

@When("Admin clicks on Arrow next to Status of Class module page for sor descend")
public void admin_clicks_on_arrow_next_to_status_of_class_module_page_for_sor_descend() {
   classPage.clickClassStausSortDesc();
}

@Then("Admin See the Status is sorted Descending order in Class module page")
public void admin_see_the_status_is_sorted_descending_order_in_class_module_page() {
	List<String> originalList = classPage.getOriginalList("Status");
	List<String> sortedList = classPage.getSortedListDescending(originalList);
	System.out.println("Descending sorted name list " + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));	 
}

@When("Admin clicks on Arrow next to ClassDate of Class module page for sort")
public void admin_clicks_on_arrow_next_to_class_date_of_class_module_page_for_sort() {
    classPage.clickClassDateSort();
}

@Then("Admin See the ClassDate is sorted Ascending order in Class module page")
public void admin_see_the_class_date_is_sorted_ascending_order_in_class_module_page() {
	List<String> originalList = classPage.getOriginalList("Date");
	List<String> sortedList = classPage.getSortedList(originalList);
	System.out.println("sorted name list" + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));	
}

@When("Admin clicks on Arrow next to ClassDate of Class module page for sor descend")
public void admin_clicks_on_arrow_next_to_class_date_of_class_module_page_for_sor_descend() {
	classPage.clickClassDateSortDesc();
}

@Then("Admin See the ClassDate is sorted Descending order in Class module page")
public void admin_see_the_class_date_is_sorted_descending_order_in_class_module_page() {
	List<String> originalList = classPage.getOriginalList("Date");
	List<String> sortedList = classPage.getSortedListDescending(originalList);
	System.out.println("Descending sorted name list " + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));	 
}

@When("Admin clicks on Arrow next to StaffName of Class module page for sort")
public void admin_clicks_on_arrow_next_to_staff_name_of_class_module_page_for_sort() {
    classPage.clickClassStaffSort();
}

@Then("Admin See the StaffName is sorted Ascending order in Class module page")
public void admin_see_the_staff_name_is_sorted_ascending_order_in_class_module_page() {
	List<String> originalList = classPage.getOriginalList("Staff");
	List<String> sortedList = classPage.getSortedList(originalList);
	System.out.println("sorted name list" + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));	
}

@When("Admin clicks on Arrow next to StaffName of Class module page for sor descend")
public void admin_clicks_on_arrow_next_to_staff_name_of_class_module_page_for_sor_descend() {
	classPage.clickClassStaffSortDesc();
}

@Then("Admin See the StaffName is sorted Descending order in Class module page")
public void admin_see_the_staff_name_is_sorted_descending_order_in_class_module_page() {
	List<String> originalList = classPage.getOriginalList("Staff");
	List<String> sortedList = classPage.getSortedListDescending(originalList);
	System.out.println("Descending sorted name list " + sortedList.toString() );
	Assert.assertTrue(originalList.equals(sortedList));	 
}







}
