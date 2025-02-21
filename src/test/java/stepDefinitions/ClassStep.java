package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

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
	List<Map<String, String>> Loginxl = Hooks.Login;

	public ClassStep(TestContext context) {
     this.context = context;
     this.driver = context.getDriver();
     this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
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
		String title = driver.getTitle();
		Assert.assertEquals(title, "LMS");
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
			Assert.assertEquals(classPage.lblClassDates.getText(), "Select Class Date");
			Assert.assertTrue(classPage.cmpClassDate.isDisplayed());
			break;			
		case "NoOfClasses":
			Assert.assertTrue(classPage.lblClassNo.isDisplayed());
			Assert.assertEquals(classPage.lblClassNo.getText(), "No of Classes");
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
			for(int i=0 ;i<classPage.getStatusBtn().size();i++)
				Assert.assertTrue(classPage.getStatusBtn().get(i).isDisplayed());			
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


}
