	package pages;
	
	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.List;
	import java.util.NoSuchElementException;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	import appHook.TestContext;
	
	public class Class_Page extends BasePage{
		
		WebDriver driver = null;
		private TestContext context;
		private WebDriverWait wait;
		Actions actions;
		JavascriptExecutor js;
	
		
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
		@FindBy(xpath = "//div[normalize-space()='Manage Class']")	public WebElement managePage;
		//@FindBy(xpath = "//span[@class='p-dialog-title ng-tns-c81-41 ng-star-inserted']") public WebElement addNewTitle;
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
		
		@FindBy(css = ".p-dialog-header-close")	public WebElement crossBtn;
		@FindBy(xpath = "//button[@label='Cancel']") public WebElement cancelBtn;
		
		//Edit
		
		@FindBy(xpath = "//button[@icon='pi pi-pencil']")	public WebElement editBtn;
		
		@FindBy(xpath = "//div[@class='p-dialog-header ng-tns-c168-7 ng-star-inserted']")public WebElement editPopup;
		
		@FindBy(xpath = "//div[@class='p-datatable-wrapper ng-star-inserted']//table//tbody//tr//td") public List<WebElement> searchValues;
		
		//Delete
		@FindBy(xpath = "//tbody[@class='p-datatable-tbody']//tr//td[1]")	public List<WebElement> checkBoxList;
		@FindBy(xpath = "//tbody[@class='p-datatable-tbody']//tr//td[2]") 	public List<WebElement> firstColumnList;
		
		@FindBy(xpath = "//span[normalize-space()='Yes']")	public WebElement yesButton;
		@FindBy(xpath = "//span[normalize-space()='No']") 	public WebElement noButton;
		@FindBy(xpath = "//div[@role='alert']")	public WebElement alertMsg;
		
		
		//Sorting
			By batchNameSort=By.xpath("//thead//tr//th[2]//i") ;
			By classTopicSort=By.xpath( "//thead//tr//th[3]//i") ;
			By classDescSort=By.xpath( "//thead//tr//th[4]//i") ;
			By statusSort=By.xpath("//thead//tr//th[5]//i") ;
			By dateSort=By.xpath( "//thead//tr//th[6]//i") ;
			By staffSort=By.xpath( "//thead//tr//th[7]//i") ;
			//list
				By batchnameList=By.xpath( "//tbody//td[2]") ;
				By classTopicList=By.xpath( "//tbody//td[3]");
				By classDescList=By.xpath( "//tbody//td[4]");
				By statusList=By.xpath( "//tbody//td[5]") ;
				By dateList=By.xpath( "//tbody//td[6]");
				By staffList=By.xpath( "//tbody//td[7]");
		
		// Pagination
			@FindBy(xpath = "//div[contains(@class, 'p-paginator')]") private WebElement pagination1;
			@FindBy(xpath = "//span[contains(@class, 'p-paginator-current')]")
			private WebElement currentEntriesText;
			@FindBy(xpath = "//p-table//table/tbody/tr")
			private List<WebElement> rows;
			@FindBy(xpath = "//button[contains(@class, 'p-paginator-first')]")
			private WebElement firstButton;
			@FindBy(xpath = "//button[contains(@class, 'p-paginator-prev')]")
			private WebElement prevButton;
			@FindBy(xpath = "//button[contains(@class, 'p-paginator-next')]")
			private WebElement nextButton;
			@FindBy(xpath = "//button[@class='p-paginator-next p-paginator-element p-link p-ripple']")
			private WebElement paninatorNext;
			@FindBy(xpath = "//button[contains(@class, 'p-paginator-last')]")
			private WebElement lastButton;
			@FindBy(xpath = "//button[contains(@class, 'p-paginator-page')]")
			private List<WebElement> pageButtons;
	
		
		
		
		public Class_Page(WebDriver driver, TestContext context){
			this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        this.context = context;
	        this.actions = new Actions(driver);
	        PageFactory.initElements(driver, this);
	        this.js = (JavascriptExecutor) driver;
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
		
		public void clickCancel()
		{
			cancelBtn.click();
		}
		
		public void clickCross()
		{
			crossBtn.click();
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
		
		public ArrayList<String> multipleCheckBoxSelection() {
			ArrayList<String> firstColValue = new ArrayList<String>();
			for(int i=1;i<checkBoxList.size();i++)
			{
				actions.moveToElement(checkBoxList.get(i)).click().perform();
				firstColValue.add(this.firstColumnList.get(i).getText());
				if(i==2)
				{
					break;
				}			
			}
			return firstColValue;	
				
		}
		public ArrayList<String> SingleCheckBoxSelection(int no) {
			ArrayList<String> firstColValue = new ArrayList<String>();
			actions.moveToElement(checkBoxList.get(no-1)).click().perform();
			firstColValue.add(this.firstColumnList.get(no-1).getText());
				
			return firstColValue;	
				
		}
		
		
		public void multipleDeletion()
		{		
			actions.doubleClick(delIcon).perform();
		}
		public String confirmDeletion() {
			
			actions.moveToElement(yesButton).click().perform();
			wait.until(ExpectedConditions.visibilityOf(alertMsg));
	
			String successText = alertMsg.getText();
			return successText;
		}
		
		public void cancelDeletion() {
	
			noButton.click();
		}
		
		public boolean isNextButtonEnabled() {
			return prevButton.getAttribute("class").contains("p-disabled");
		}
	
			public boolean isFinalButtonEnabled() {
				return !lastButton.getAttribute("class").contains("p-disabled");
			}
	
			// Check if 'Previous' button is enabled
			public boolean isPrevButtonEnabled() {
				return !prevButton.getAttribute("class").contains("p-disabled");
			}
	
			// Check if 'First' button is enabled
			public boolean isFirstButtonEnabled() {
				return !firstButton.getAttribute("class").contains("p-disabled");
			}
	
			public boolean hasNextPageResults() {
				// Return true if there are results; false otherwise
				return !rows.isEmpty();
			}
		
		  public void clickNextPage() {
		if (nextButton != null && nextButton.isDisplayed()) {
		  js.executeScript("arguments[0].scrollIntoView(true);", nextButton);
		  actions.doubleClick(nextButton).perform(); //nextButton.click() ;
		  } else {
		  throw new NoSuchElementException("Next button not found on the page."); 
		  } }
		  
		  public void clickLastPage() { 
			  if (lastButton != null && lastButton.isDisplayed()) {
		  js.executeScript("arguments[0].scrollIntoView(true);", lastButton);
		  actions.doubleClick(lastButton).perform();
		  } else { 
			  throw new NoSuchElementException("Last button not found on the page."); }
		  
		  }
		  
		  public void clickPreviousPage() { 
			  if (prevButton != null && prevButton.isDisplayed()) {
		  js.executeScript("arguments[0].scrollIntoView(true);", prevButton);
		   actions.doubleClick(nextButton).perform();
		   actions.doubleClick(prevButton).perform();
		  } 
			  else { 
				  throw new  NoSuchElementException("Previous button not found on the page."); } }
		  
		  public void clickFirstPage() { 
			  if (firstButton != null && firstButton.isDisplayed()) {
		  js.executeScript("arguments[0].scrollIntoView(true);", firstButton);
		  actions.doubleClick(nextButton).perform();
		   actions.doubleClick(firstButton).perform();
		  } else { 
			  throw new NoSuchElementException("First button not found on the page."); }
		  
		  }
		 
		  //Sorting 
		  
		  public void clickBatchNameSort(){	
				WebElement batchNameSortEle=driver.findElement(batchNameSort);
		        actions.click(batchNameSortEle).perform();
		        actions.click(batchNameSortEle).perform();
			}
			
			public void clickBatchNameSortDec(){
				WebElement classBatchSortDesc=driver.findElement(batchNameSort);
		        actions.click(classBatchSortDesc).perform();
		        actions.click(classBatchSortDesc).perform();
		        actions.click(classBatchSortDesc).perform();
	//	      actions.doubleClick(progNameSort).perform();
			}
			public void clickClassTopicSort(){	
				WebElement classDescSortEle=driver.findElement(classTopicSort);
		        actions.click(classDescSortEle).perform();
		        actions.click(classDescSortEle).perform();
				
			}
			public void clickClassTopicSortDesc(){		
				WebElement classDescSortEleDesc=driver.findElement(classTopicSort);
		        actions.click(classDescSortEleDesc).perform();
		        actions.click(classDescSortEleDesc).perform();
		        actions.click(classDescSortEleDesc).perform();
				
			}
			public void clickClassDescSort(){	
				WebElement dateSortEle=driver.findElement(classDescSort);
		        actions.click(dateSortEle).perform();
		        actions.click(dateSortEle).perform();
				
			}
			public void clickClassDescSortDesc(){	
				WebElement dateSortEleDesc=driver.findElement(classDescSort);
		        actions.click(dateSortEleDesc).perform();
		        actions.click(dateSortEleDesc).perform();
		        actions.click(dateSortEleDesc).perform();
				
			}
			public void clickClassStausSort(){	
				WebElement statusSortEle=driver.findElement(statusSort);
		        actions.click(statusSortEle).perform();
		        actions.click(statusSortEle).perform();
				
			}
			public void clickClassStausSortDesc(){	
				WebElement statusSortEleDesc=driver.findElement(statusSort);
		        actions.click(statusSortEleDesc).perform();
		        actions.click(statusSortEleDesc).perform();
		        actions.click(statusSortEleDesc).perform();
				
			}
			public void clickClassDateSort(){	
				WebElement dateSortEle=driver.findElement(dateSort);
		        actions.click(dateSortEle).perform();
		        actions.click(dateSortEle).perform();
				
			}
			public void clickClassDateSortDesc(){	
				WebElement dateSortEleDesc=driver.findElement(dateSort);
		        actions.click(dateSortEleDesc).perform();
		        actions.click(dateSortEleDesc).perform();
		        actions.click(dateSortEleDesc).perform();
				
			}
			public void clickClassStaffSort(){	
				WebElement staffSortEle=driver.findElement(staffSort);
		        actions.click(staffSortEle).perform();
		        actions.click(staffSortEle).perform();
				
			}
			public void clickClassStaffSortDesc(){	
				WebElement staffSortEleDesc=driver.findElement(staffSort);
		        actions.click(staffSortEleDesc).perform();
		        actions.click(staffSortEleDesc).perform();
		        actions.click(staffSortEleDesc).perform();
				
			}
			
			public List<String> printWebElements(List<WebElement> options) {
				List<String> texts = new ArrayList<String>();
				int i=0;
				for(WebElement option: options) {
					texts.add(i,option.getText());
					i++;
				}
				System.out.println("The number of items in the list are: "+ texts.size());
				return texts;
			}
			
			
			public List<String> getOriginalList(String type) {
				//List<String> originalList = null;
				List<String> originalList = new ArrayList<>();
				List<WebElement> batchnameListEle =driver.findElements(batchnameList);
				List<WebElement> classTopicListEle =driver.findElements(classTopicList);
				List<WebElement> classDescListEle =driver.findElements(classDescList);
				List<WebElement> statusListEle =driver.findElements(statusList);
				List<WebElement> dateListEle =driver.findElements(dateList);
				List<WebElement> staffListEle =driver.findElements(staffList);
				
				if(type.equals("BatchName")) {
					originalList=printWebElements(batchnameListEle);
				
				}else if(type.equals("ClassTopic")) {
					originalList = printWebElements(classTopicListEle);
				
				}else if(type.equals("ClassDescription")) {
					originalList = printWebElements(classDescListEle);
				
				}else if(type.equals("Status")) {
					originalList = printWebElements(statusListEle);
				
				}else if(type.equals("Date")) {
					originalList = printWebElements(dateListEle);
				
				}else if(type.equals("Staff")) {
					originalList = printWebElements(staffListEle);
				}
				return originalList;	
			}
			
		public List<String> getSortedListDescending(List<String> originalList){
				
				System.out.println("Original List Before sorting is"+ originalList);
		        List<String> sortedList = new ArrayList<>(originalList);
		        Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER.reversed());
				System.out.println("Sorted List After sorting is"+ sortedList);
		        return sortedList;
			}	
	
		public List<String> getSortedList(List<String> originalList){
			System.out.println("Original List Before sorting is"+ originalList);
		    List<String> sortedList = new ArrayList<>(originalList);
		    Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
			System.out.println("Sorted List After sorting is"+ sortedList);
		    return sortedList;
		}
	
			
	}
