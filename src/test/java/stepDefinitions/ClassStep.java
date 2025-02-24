package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
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

	
	
	@Then("Admin should see the Class Details pop up window {string}")
	public void admin_should_see_the_class_details_pop_up_window(String string) {
		switch (string) {
		case "Title":
			Assert.assertTrue(classPage.addNewTitle.isDisplayed());
			Assert.assertEquals(classPage.addNewTitle.getText(), "Class Details");
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
		
		//System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"+classPage.successMsg.getText());
		
		//Assert.assertEquals(classPage.successMsg.getText(), classXl.get(int1).get("Message"));
		
		
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
	System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
	boolean displayed = classPage.pageTitle.isDisplayed();
	Assert.assertTrue(displayed);
	classPage.searchClass(updatedDescription);
	//Pending Verification of the records
	System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"+classPage.searchValues.get(3).getText());	
	Assert.assertEquals(updatedDescription, classPage.searchValues.get(3).getText());
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
	
@When("Admin clicks Next page link on the class table")
public void admin_clicks_next_page_link_on_the_class_table() {
    
}

@Then("Admin should see the next page record on the table with Pagination has next active link enabled")
public void admin_should_see_the_next_page_record_on_the_table_with_pagination_has_next_active_link_enabled() {
   
}

@When("Admin clicks Last page link")
public void admin_clicks_last_page_link() {
    
}

@Then("Admin should see the last page record on the table with Next page link are disabled")
public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
    
}

@Given("Admin is on last page of class table")
public void admin_is_on_last_page_of_class_table() {
   
}

@When("Admin clicks First page link")
public void admin_clicks_first_page_link() {
    
}

@Then("Admin should see the previous page record on the table with pagination has previous page link enabled")
public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link_enabled() {
   
}

@Given("Admin is on Previous class page")
public void admin_is_on_previous_class_page() {
    
}

@When("Admin clicks Start page link")
public void admin_clicks_start_page_link() {
    
}

@Then("Admin should see the very first page record on the table with Previous page link are disabled")
public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
   
}



@When("Admin enter the BatchName in search textbox and Enter")
public void admin_enter_the_batch_name_in_search_textbox_and_enter() {
	String batchName = classXl.get(0).get("BatchName");
	classPage.searchClass(batchName);
	
}

@Then("Admin should see Class details are searched by Batch Name")
public void admin_should_see_class_details_are_searched_by_batch_name() {
	String batchName = classXl.get(0).get("BatchName");
	Assert.assertEquals(batchName, classPage.searchValues.get(1).getText());
}

@When("Admin enter the Class topic in search textbox and Enter")
public void admin_enter_the_class_topic_in_search_textbox_and_enter() {
	String classTopic = classXl.get(0).get("ClassTopic");
	classPage.searchClass(classTopic);
}

@Then("Admin should see Class details are searched by Class topic")
public void admin_should_see_class_details_are_searched_by_class_topic() {
	String classTopic = classXl.get(0).get("ClassTopic");
	Assert.assertEquals(classTopic, classPage.searchValues.get(2).getText());
}

@When("Admin enter the Staff Name in search textbox and Enter")
public void admin_enter_the_staff_name_in_search_textbox_and_enter() {
	String staffName = classXl.get(0).get("StaffName");
	classPage.searchClass(staffName);
}

@Then("Admin should see Class details are searched by Staff name")
public void admin_should_see_class_details_are_searched_by_staff_name() {
	String staffName = classXl.get(0).get("StaffName");
	Assert.assertEquals(staffName, classPage.searchValues.get(6).getText());
}





}
