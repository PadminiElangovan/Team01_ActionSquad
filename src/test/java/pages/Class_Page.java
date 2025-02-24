package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import appHook.TestContext;

public class Class_Page extends BasePage{
	
	WebDriver driver = null;
	private TestContext context;
	private WebDriverWait wait;
	Actions actions;

	
	@FindBy(xpath = "//span[normalize-space()='Class']") public WebElement classNavigation;
	@FindBy(xpath = "//div[normalize-space()='Manage Class']") public WebElement pageTitle;
	
	
	@FindBy(xpath = "//input[@id='filterGlobal']") public WebElement searchComp;
	
	@FindBy(xpath = "//th[normalize-space()='Batch Name']") public WebElement thBatchName;
	@FindBy(xpath = "//th[normalize-space()='Class Topic']") public WebElement thClassTopic;
	@FindBy(xpath = "//th[normalize-space()='Class Description']") public WebElement thClassDesc;
	@FindBy(xpath ="//span[normalize-space()='LMS - Learning Management System']") public WebElement appTitle;
	
	@FindBy(xpath = "//th[normalize-space()='Status']") public WebElement thStatus;
	@FindBy(xpath = "//th[normalize-space()='Class Date']") public WebElement thClassDate;
	@FindBy(xpath = "//th[normalize-space()='Staff Name']") public WebElement thStaffName;
	@FindBy(xpath = "//th[normalize-space()='Edit / Delete']") public WebElement thEditDel;
	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']") public WebElement delIcon;
	@FindBy (xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']") public WebElement toltalClass;
	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']") public WebElement pageCount;
	//Sorting Icons
	@FindBy(className = "p-sortable-column-icon")	public List<WebElement> sortingBtn;
	
	//Add New Class 
	@FindBy(xpath = "//button[@role='menuitem']") public WebElement subAddMenu;
	@FindBy(xpath = "//span[@class='p-dialog-title ng-tns-c81-41 ng-star-inserted']") public WebElement addNewTitle;
	//@FindBy(xpath = "//span[@id='pr_id_69-label']") public WebElement editTitle;
	@FindBy(xpath ="//span[normalize-space()='Class Details']") public WebElement editTitle;
	
	
	@FindBy(xpath = "//label[@for='batchName']") public WebElement lblBatchName;
	@FindBy(xpath = "//input[@placeholder='Select a Batch Name']") public WebElement cmpBatchName;
	@FindBy(xpath = "//label[@for='classTopic']") public WebElement lblClassTopic;
	@FindBy(xpath = "//input[@id='classTopic']") public WebElement cmpClassTopic;
	@FindBy(xpath = "//label[@for='classDescription']") public WebElement lblClassDesc;
	@FindBy(xpath = "//input[@id='classDescription']") public WebElement cmpClassDesc;
	@FindBy(xpath = "//label[normalize-space()='Select Class Dates']") public WebElement lblClassDates;
	
	@FindBy(xpath = "//input[@id='icon']") public WebElement cmpClassDate;
//	@FindBy(xpath = "//span[@class='p-button-icon pi pi-calendar']")
//	public WebElement calenderBtn;
	
	@FindBy(xpath = "//span[@class='ng-tns-c92-93 p-calendar p-calendar-w-btn']")
	public WebElement calenderBtn;
	//p-datepicker-trigger ng-tns-c92-93 p-ripple p-button p-component p-button-icon-only ng-star-inserted
	@FindBy(className = "p-datepicker-month")
	private WebElement month;
	@FindBy(className = "pi-chevron-right")
	private WebElement nextMonth;
	
	
	//@FindBy(xpath = "//table[@class = 'p-datepicker-calendar ng-tns-c92-90']//tbody//td") private List<WebElement> dateSel;
	
	//td[@class='ng-tns-c92-93 p-datepicker-today ng-star-inserted']
	

	//div[@class='p-datatable-wrapper ng-star-inserted']//table//tbody//tr//
	
	//tbody[@'class=p-datatable-tbody']//tr//td
	
	//@FindBy(xpath = "//label[@for='classNo']") public WebElement lblClassNo;
	@FindBy(xpath = "//label[text()='No of Classes']")	public WebElement noOfClassesHeader;
	@FindBy(xpath = "//input[@id='classNo']") public WebElement cmpClassNo;
					
	@FindBy(xpath = "//label[@for='staffId']") public WebElement lblStaff;
	@FindBy(xpath = "//input[@placeholder='Select a Staff Name']") public WebElement cmpStaff;
	
	@FindBy(xpath = "//lable[@for='online']") public WebElement lblStatus;	
	
		
	@FindBy(xpath = "//div[contains(text(),'Active')]//div[2]")
	public WebElement statusActive;
	@FindBy(xpath = "//div[contains(text(),'Inactive')]//div[2]")
	public WebElement statusInActive;

	
	
	@FindBy(xpath = "//label[@for='classComments']") public WebElement lblComments;
	@FindBy(xpath = "//input[@id='classComments']") public WebElement cmpComments;
	
	@FindBy(xpath = "//label[@for='classNotes']") public WebElement lblNotes;
	@FindBy(xpath = "//input[@id='classNotes']") public WebElement cmpNotes;
	
	@FindBy(xpath = "//label[@for='classRecording']") public WebElement lblRecording;
	@FindBy(xpath = "//input[@id='classRecordingPath']") public WebElement cmpRecording;

 
	@FindBy(xpath = "//span[normalize-space()='Cancel']") public WebElement addNewCancel;
	@FindBy(xpath = "//span[normalize-space()='Save']") public WebElement addNewSave;
	//p-button-label
	
	//@FindBy(xpath = "//div[@class='p-toast-summary ng-tns-c20-44']") public WebElement successMsg;
	@FindBy(xpath = "//div[text()='Successful']")	public WebElement successMsg;
	
	//Edit
	
	@FindBy(xpath = "//button[@icon='pi pi-pencil']")	public WebElement editBtn;
	
	@FindBy(xpath = "//div[@class='p-dialog-header ng-tns-c168-7 ng-star-inserted']")public WebElement editPopup;
	
	@FindBy(xpath = "//div[@class='p-datatable-wrapper ng-star-inserted']//table//tbody//tr//td") public List<WebElement> searchValues;

	
	
	
	public Class_Page(WebDriver driver, TestContext context){
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.context = context;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
		
	}
	
	public void clickClass()
	{
		classNavigation.click();
	}
	public void clickClassAddNew()
	{
		classNavigation.click();
		subAddMenu.click();
	}
	public String getTitle()
	{
		return appTitle.getText();
	}
	public String pageTitleText()
	{
		return pageTitle.getText();
	}
	public boolean validateSortingBtn() {
		return isSortingbuttonDisplayed(sortingBtn);
	}
	
	public void noOfClasses(String Month, String date1, String date2) {

		cmpClassDate.click();		
		do {
			nextMonth.click();
			
		} while (!month.getText().contains(Month));
		
		//List<WebElement> datesSelected = driver.findElements(By.xpath("//table[@class='p-datepicker-calendar ng-tns-c92-114']//tr//td"));
		List<WebElement> datesSelected = driver.findElements(By.cssSelector("body > div:nth-child(8) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(5) > td:nth-child(6)"));
		
		System.out.println("dateSeldateSeldateSeldateSeldateSel"+datesSelected.size());
		
		for (int i = 0; i < datesSelected.size(); i++) {
			List<WebElement> dates = datesSelected;
			System.out.println("dateSeldateSeldateSeldateSeldateSel"+dates.size());
			String text = dates.get(i).getText();
			System.out.println("texttexttexttexttexttexttexttexttexttexttexttexttext"+text);
			if (text.equalsIgnoreCase(date1) || text.equalsIgnoreCase(date2)) {
				dates.get(i).click();
			}
		}
		noOfClassesHeader.click();
	}

	public void clickOnEdit() {
		actions.doubleClick(editBtn).perform();	
		
}
	public void editClassDetails(String editClass) {
		cmpClassDesc.sendKeys(editClass);
	}
	
	public String saveEditClass() {
		addNewSave.click();
		return successMsg.getText();
	}
	
//	public ArrayList<WebElement> getStatusBtn()
//	{
//		ArrayList<WebElement> compList = new ArrayList<WebElement>();
//		for (int i = 1; i < cmpStatusRadios.size(); i++) {
//			WebElement element = cmpStatusRadios.get(i);
//			compList.add(element);
//		}
//				
//		return compList;
//	}
	
	public void searchClass(String value)
	{
		searchComp.clear(); 
		searchComp.sendKeys(value); 
		searchComp.sendKeys(Keys.ENTER);
	}
	
}
