package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

public class Program_Page extends BasePage {

	private WebDriver driver;
	private WebDriverWait wait;
	Actions actions;
	TestContext context;
	JavascriptExecutor js;

	@FindBy(xpath = "//*[@id='program']")
	private WebElement programBtn;
	@FindBy(xpath = "//*[@id='mat-menu-panel-0']/div/button")
	private WebElement addNewPgm;
	@FindBy(xpath = "//*[@id='filterGlobal']")
	private WebElement searchbtn;
	@FindBy(xpath = "//span[text()=' LMS - Learning Management System ']")
	private WebElement appHeader;
	@FindBy(xpath = "//div[@class='ng-star-inserted']")
	private WebElement menu;
	@FindBy(xpath = "//span[text()='Home']")
	private WebElement homeHeader;
	@FindBy(xpath = "//span[text()='Batch']")
	private WebElement batchHeader;
	@FindBy(xpath = "//span[text()='Class']")
	private WebElement classHeader;
	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logoutHeader;

	@FindBy(xpath = "//div[normalize-space()='Manage Program']")
	private WebElement manageProgramHeader;
	@FindBy(xpath = "//th[normalize-space()='Program Name']")
	private WebElement programNameHeader;
	@FindBy(xpath = "//th[normalize-space()='Program Description']")
	private WebElement programDescriptionHeader;
	@FindBy(xpath = "//th[normalize-space()='Program Status']")
	private WebElement programStatus;
	@FindBy(xpath = "//th[text()=' Edit / Delete ']")
	private WebElement editDeleteHeader;
	@FindBy(className = "p-checkbox")
	private WebElement checkboxProgramName;
	@FindBy(css = ".p-paginator-current.ng-star-inserted")
	private WebElement showingEnteries;
	@FindBy(className = "p-sortable-column-icon")
	private List<WebElement> sortingBtn;
	@FindBy(css = "button[class='p-button-danger p-button p-component p-button-icon-only']")
	private WebElement deleteBtnMC;
	@FindBy(css = ".p-datatable-footer.ng-star-inserted")
	private WebElement footer;
	@FindBy(xpath = "p-paginator-element")
	private List<WebElement> pagination;
	@FindBy(xpath = "//div[@class='signin-content']")
	private WebElement backdrop;
	@FindBy(xpath = "//div[normalize-space()='Manage Program']")
	private WebElement managePage;

	// Add new
	@FindBy(xpath="//span[text()='Program Details']")
	private WebElement popUpTitle;
	@FindBy(xpath = "//label[@for='programName']")
	private WebElement addProgramName;
	@FindBy(xpath = "//label[@for='programDescription']")
	private WebElement addProgramDesc;
	@FindBy(xpath = "//lable[@for='online']")
	private WebElement addProgramStatus;
	@FindBy(xpath = "//input[@id='programName']")
	private WebElement programNameText;
	@FindBy(xpath = "//input[@id='programDescription']")
	private WebElement programDescText;
	@FindBy(xpath = "//div[contains(text(),'Active')]//div[2]")
	private WebElement statusActive;
	@FindBy(xpath = "//div[contains(text(),'Inactive')]//div[2]")
	private WebElement statusInActive;
	@FindBy(xpath = "//div[text()='Successful']")
	private WebElement programCreated;
	@FindBy(xpath = "//button[@id='saveProgram']")
	private WebElement saveProgram;
	@FindBy(css="td:nth-child(2)")
	private WebElement programNameSearch;
	@FindBy(xpath = "//small[normalize-space()='Program name is required.']")
	private WebElement programNameReq;
	@FindBy(xpath = "//small[normalize-space()='Description is required.']")
	private WebElement programDescReq;
	@FindBy(xpath = "//small[normalize-space()='Status is required.']")
	private WebElement programStatusReq;
	@FindBy(xpath = "//button[@label='Cancel']")
	private WebElement cancelBtn;
	@FindBy(xpath = "//button[@icon='pi pi-pencil']")
	private WebElement editBtn;
	@FindBy(xpath = "//div[@class='p-dialog-header ng-tns-c168-7 ng-star-inserted']")
	private WebElement editPopup;
	@FindBy(xpath="//div[@class='p-dialog-header-icons ng-tns-c81-21']")
	private WebElement XBtn;

	// Delete
	@FindBy(xpath="(//button[@icon='pi pi-trash'])[2]")
	private WebElement deleteBtnTbl;
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	private WebElement firstCheckbox;
	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	private WebElement DeleteIconHeader;
	@FindBy(xpath = "//body//app-root//th[1]")
	private WebElement checkbox1;
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	private WebElement checkbox2;
	@FindBy(xpath = "//tbody/tr[2]/td[1]/p-tablecheckbox[1]/div[1]/div[2]")
	private WebElement checkbox3;
	@FindBy(xpath = ".//div[@role='checkbox']")
	private List<WebElement> checkboxes;
	@FindBy(xpath = "//span[normalize-space()='Yes']")
	private WebElement yesButton;
	@FindBy(xpath = "//span[normalize-space()='No']")
	private WebElement noButton;
	@FindBy(xpath = "//tbody/tr[1]/td[7]/div[1]/span[2]/button[1]")
	private WebElement Deletepopup;
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alertMsg;
	
	//Search
	private String lastSearchedField, lastSearchedValue;
	@FindBy(xpath = "//tbody//td[2]")
	private List<WebElement> listOfProgramNames;
	@FindBy(xpath = "//tbody//td[3]")
	private List<WebElement> listOfProgramDescription;
	@FindBy(xpath="(//tbody//td[2])[1]")
	private WebElement searchedProgramName;
	@FindBy(xpath="(//tbody//td[2])[1])")
	private WebElement searchedProgramDesc;

	
	// Pagination
	@FindBy(xpath = "//div[contains(@class, 'p-paginator')]")
	private WebElement pagination1;
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
	@FindBy(xpath = "//button[contains(@class, 'p-paginator-last')]")
	private WebElement lastButton;
	@FindBy(xpath = "//button[contains(@class, 'p-paginator-page')]")
	private List<WebElement> pageButtons;

	public Program_Page(WebDriver driver, TestContext context) {

		this.driver = context.getDriver();
		this.context = context;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
		this.js = (JavascriptExecutor) driver;
	}

	// clicking program button
	public void clickProgram() {
		elementClick(programBtn);
	}

	public void clickProgramAddNew() {
		elementClick(programBtn);
		elementClick(addNewPgm);
	}
	
	public List<String> getTableHeaders() {
		List<String> headers = new ArrayList<>();

		headers.add(appHeader.getText().trim());
		headers.add(homeHeader.getText().trim());
		headers.add(programBtn.getText().trim());
		headers.add(batchHeader.getText().trim());
		headers.add(classHeader.getText().trim());
		headers.add(logoutHeader.getText().trim());
		headers.add(manageProgramHeader.getText().trim());
		headers.add(programNameHeader.getText().trim());
		headers.add(programDescriptionHeader.getText().trim());
		headers.add(programStatus.getText().trim());
		headers.add(addNewPgm.getText().trim());
		headers.add(editDeleteHeader.getText().trim());

		return headers;
	}

	public boolean validateShowingEnteries() {
		return showingEnteries.isDisplayed();

	}

	public void checkboxWithProgramName() {
		boolean isDisplayed = checkboxProgramName.isDisplayed();
		System.out.println("Element is displayed: " + isDisplayed);

	}

	public boolean validateSortingBtn() {
		return isSortingbuttonDisplayed(sortingBtn);
	}

	public boolean testMultipleDeleteIsDisabled() {
		boolean isEnabled = deleteBtnMC.isEnabled();
		System.out.println("Is Delete button enabled? " + isEnabled);
		return !isEnabled;
	}

	public boolean deleteBtnDisplayed() {
		return deleteBtnMC.isDisplayed();
	}

	public boolean validateFooter() {
		return footer.isDisplayed();
	}
	
	// Add new Program
	public boolean programPopUpTitle() {
		return isElementDisplayed(popUpTitle);
	}
	public String programPopUpTitleText() {
		return elementGetText(popUpTitle);
	}
	
	public boolean programNameDisplayed() {
		return isElementDisplayed(addProgramName);
	}
	public String programNameText() {
		System.out.println(addProgramName);
		return elementGetText(addProgramName);
	}
	public String programDescText() {
		System.out.println(addProgramDesc);
		return elementGetText(addProgramDesc);
	}
	public boolean programDescDisplayed() {
		return isElementDisplayed(addProgramDesc);
	}
	public boolean programStatus() {
		return isElementDisplayed(addProgramStatus);
	}
	public String programStatusText() {
		System.out.println(addProgramStatus);
		return elementGetText(addProgramStatus);
	}
	public void clickOnSave() {
		elementClick(saveProgram);
	}
	public void enterProgramNameInSearch()  {
		js.executeScript("arguments[0].click();", searchbtn);
		//elementClick(searchbtn);
		 elementSendkeys(searchbtn, "CSharp");
	}
	public String verifyProgramName() {
	return	elementGetText(programNameSearch);
	
	}
	public boolean cancelDisp() {
		return cancelBtn.isDisplayed();
	}
	public void clickXDisp() {
		elementClick(XBtn);
	}
	public boolean onManagePage() {
		return managePage.isDisplayed();
	}


	public String addingMandatoryFields(String Name, String Description, String Status) throws InterruptedException {
		elementSendkeys(programNameText, Name);
		elementClick(programDescText);
		elementSendkeys(programDescText, Description);
		if (Status.equals("Active")) {
			statusActive.click();
		} else {
			statusInActive.click();
		}
		saveProgram.click();

		return programCreated.getText();
	}
	
//*****************************Edit*****************************************************	
	
	public void clickOnEdit() {
				actions.doubleClick(editBtn).perform();
	}
	
	public void editProgramDetails(String editDesc) {
		programDescText.clear();
		programDescText.sendKeys(editDesc);
	}
	
	public String saveEditProgram() {
		saveProgram.click();
		return programCreated.getText();
	}
	
		public boolean validatePagination() {
		for (WebElement element : pagination) {
			if (!element.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	private void doubleClick(WebElement element) {
		actions.moveToElement(element).doubleClick().perform();
	}

	public void navigateToProgram() {
		doubleClick(programBtn);

	}
	
// **********************************Delete	*******************************************************
	
	public void clickDeleteIconForSpecificProgram() {
		actions.doubleClick(deleteBtnMC).perform();
				}

	public boolean IsDeleteButtonEnabled() {
	return	isElementEnabled(deleteBtnMC);
			}
	
	public void clickOnDeleteButtonInTable() {
		actions.doubleClick(deleteBtnTbl).perform();
	}
	
	//multiple delete
		public void multipleDeleteAction() {
			actions.moveToElement(checkbox2).click().perform();
			if (checkbox3.isEnabled() && checkbox3.isDisplayed()) {
					actions.moveToElement(checkbox3).click().perform();
				}
			}
				
		
		public void clickOnHeaderDeleteIcon() {
			actions.doubleClick(DeleteIconHeader).perform();
		//elementClick(DeleteIconHeader);
		}
		
		public void confirmDeletion() {
			if (yesButton.isDisplayed() && yesButton.isEnabled()) {
				System.out.println("Yes button is displayed and enabled.");
			} else {
				System.out.println("Yes button is not interactable.");
				return; 
			}
			actions.moveToElement(yesButton).click().perform();
			wait.until(ExpectedConditions.visibilityOf(alertMsg));

			String successText = alertMsg.getText();
			System.out.println(successText);
		}

		public String getSuccessMessageText() {
			return alertMsg.getText();
		}
		
//Search
		
		
		public void enterSearchValue(String field, String value) {
			
		    searchbtn.clear(); 
		    searchbtn.sendKeys(value); 
		    searchbtn.sendKeys(Keys.ENTER); 
		    
		    // Store field and value for later validation
		    lastSearchedField = field;
		    lastSearchedValue = value;

		    System.out.println("Entered search value: " + value);
		}


		public void searhBoxValidation(String field, String value) throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", searchbtn);
			boolean found = false;
			switch (field) {
			case "Name":
				searchbtn.sendKeys(value);
				logicForValidatingSearch(listOfProgramNames, value);
					break;
			case "Description":
				searchbtn.sendKeys(value);
				logicForValidatingSearch(listOfProgramDescription, value);
				break;
			
			}
		
		}
		 
			
		
		
		
	public void clickNextPage() {
		if (nextButton != null && nextButton.isDisplayed()) {
			js.executeScript("arguments[0].scrollIntoView(true);", nextButton);
			nextButton.click();
		} else {
			throw new NoSuchElementException("Next button not found on the page.");
		}
	}

	public void clickLastPage() {
		if (lastButton != null && lastButton.isDisplayed()) {
			js.executeScript("arguments[0].scrollIntoView(true);", lastButton);
			lastButton.click();
		} else {
			throw new NoSuchElementException("Last button not found on the page.");
		}

	}

	public void clickPreviousPage() {
		if (prevButton != null && prevButton.isDisplayed()) {
			js.executeScript("arguments[0].scrollIntoView(true);", prevButton);
			nextButton.click();
			prevButton.click();
		} else {
			throw new NoSuchElementException("Previous button not found on the page.");
		}
	}

	public void clickFirstPage() {
		if (firstButton != null && firstButton.isDisplayed()) {
			js.executeScript("arguments[0].scrollIntoView(true);", firstButton);
			nextButton.click();
			firstButton.click();
		} else {
			throw new NoSuchElementException("First button not found on the page.");
		}

	}

	public boolean isNextButtonEnabled() {
		return nextButton.isEnabled();

	}

	public boolean isPrevButtonEnabled() {
		return prevButton.isDisplayed();
	}

	public boolean isLastButtonEnabled() {
		return lastButton.isEnabled();

	}

	public String getProgramNameReqText() {
		return elementGetText(programNameReq);
	}

	public String getDescriptionReqText() {
	return	elementGetText(programDescReq);
	}

	public String getStatusReqText() {
		return	elementGetText(programStatusReq);
	}

}
