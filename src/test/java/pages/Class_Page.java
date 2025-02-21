package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import appHook.TestContext;

public class Class_Page extends BasePage{
	
	WebDriver driver = null;
	private TestContext context;
	private WebDriverWait wait;

	
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
	@FindBy(xpath = "//label[@for='batchName']") public WebElement lblBatchName;
	@FindBy(xpath = "//input[@placeholder='Select a Batch Name']") public WebElement cmpBatchName;
	@FindBy(xpath = "//label[@for='classTopic']") public WebElement lblClassTopic;
	@FindBy(xpath = "//input[@id='classTopic']") public WebElement cmpClassTopic;
	@FindBy(xpath = "//label[@for='classDescription']") public WebElement lblClassDesc;
	@FindBy(xpath = "//input[@id='classDescription']") public WebElement cmpClassDesc;
	@FindBy(xpath = "//label[normalize-space()='Select Class Dates']") public WebElement lblClassDates;
	
	@FindBy(xpath = "//input[@id='icon']") public WebElement cmpClassDate;
	@FindBy(xpath = "//label[@for='classNo']") public WebElement lblClassNo;
	@FindBy(xpath = "//input[@id='classNo']") public WebElement cmpClassNo;
	@FindBy(xpath = "//label[@for='staffId']") public WebElement lblStaff;
	@FindBy(xpath = "//input[@placeholder='Select a Staff Name']") public WebElement cmpStaff;
	
	@FindBy(xpath = "//lable[@for='online']") public WebElement lblStatus;	
	@FindBy(xpath = "//div[@class='radio ng-star-inserted']") public List<WebElement> cmpStatusRadios;
	
	
	@FindBy(xpath = "//label[@for='classComments']") public WebElement lblComments;
	@FindBy(xpath = "//input[@id='classComments']") public WebElement cmpComments;
	
	@FindBy(xpath = "//label[@for='classNotes']") public WebElement lblNotes;
	@FindBy(xpath = "//input[@id='classNotes']") public WebElement cmpNotes;
	
	@FindBy(xpath = "//label[@for='classRecording']") public WebElement lblRecording;
	@FindBy(xpath = "//input[@id='classRecordingPath']") public WebElement cmpRecording;

 
	@FindBy(xpath = "//span[normalize-space()='Cancel']") public WebElement addNewCancel;
	@FindBy(xpath = "//span[normalize-space()='Save']") public WebElement addNewSave;
	
	
	public Class_Page(WebDriver driver, TestContext context){
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.context = context;
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
//	public boolean validateSortingBtn() {
//		return isSortingbuttonDisplayed(sortingBtn);
//	}
	
	public ArrayList<WebElement> getStatusBtn()
	{
		ArrayList<WebElement> compList = new ArrayList<WebElement>();
		for (int i = 1; i < cmpStatusRadios.size(); i++) {
			WebElement element = cmpStatusRadios.get(i);
			compList.add(element);
		}
				
		return compList;
	}
	
}
