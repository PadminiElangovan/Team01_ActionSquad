package pages;

import java.io.IOException;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import appHook.Hooks;
import appHook.TestContext;
import common.ExcelReader;

public class Batch_Page {

	private TestContext context;
	private WebDriverWait wait;
	WebDriver driver;
	private JavascriptExecutor js;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameField;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//div[@id='mat-select-value-1']")
	public WebElement roleDropdwn;

	@FindBy(xpath = "//*[@id=\"mat-option-0\"]/span")
	public WebElement AdminRole;

	@FindBy(xpath = "//button[@id='login']")
	private WebElement loginButton;

	@FindBy(xpath = "//span[normalize-space()='LMS - Learning Management System']")
	private WebElement toolbar;

	@FindBy(xpath = "//span[normalize-space()='Batch']")
	private WebElement Batch;

//	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-title/div[1]")
//	private WebElement Managebatch;

	@FindBy(xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	private WebElement DeleteIconHeader;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-confirmdialog/div/div/div[1]/div/button")
	private WebElement CloseDeletePopup;

	@FindBy(xpath = "//th[normalize-space()='Batch Name']")
	private WebElement Batchnameicon;

	@FindBy(xpath = "//th[normalize-space()='Batch Name']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	private WebElement Batchnamesortingicon;

	@FindBy(xpath = "//th[normalize-space()='Batch Description']")
	private WebElement Batchdescription;

	@FindBy(xpath = "//p-sorticon[@field='batchDescription']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	private WebElement Batchdescriptionsorticon;

	@FindBy(xpath = "//th[normalize-space()='Batch Status']")
	private WebElement Batchstatus;

	@FindBy(xpath = "//p-sorticon[@field='batchStatus']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	private WebElement Batchstatussortingicon;

	@FindBy(xpath = "//th[normalize-space()='No Of Classes']")
	private WebElement Noofclasses;

	@FindBy(xpath = "//p-sorticon[@field='batchNoOfClasses']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	private WebElement Noofclassessortingicon;

	@FindBy(xpath = "//th[normalize-space()='Program Name']")
	private WebElement programname;

	@FindBy(xpath = "//th[normalize-space()='Program Name']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']")
	private WebElement programnamesortingicon;

	@FindBy(xpath = "//th[normalize-space()='Edit / Delete']")
	private WebElement EditDelete;

	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	private WebElement checkboxheader;

	private List<String> expectedHeaders = Arrays.asList("Batch Name", "Batch Description", "Batch Status",
			"No Of Classes", "Program Name", "Edit / Delete");

	@FindBy(xpath = "//p-table//p-paginator/div")
	private WebElement PaginationElement;

	@FindBy(xpath = "//div[normalize-space()='Manage Batch']")
	private WebElement Header;

	@FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
	private WebElement Footer;

	@FindBy(xpath = "//*[@id=\"filterGlobal\"]")
	private WebElement Searchbox;

	// Pagination frame locators

	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']")
	private WebElement paninatorCurrenttext;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[1]")
	private WebElement paninatorFirstbutton;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[2]")
	private WebElement paninatorPrevious;

	@FindBy(xpath = "//button[@class='p-paginator-next p-paginator-element p-link p-ripple']")
	private WebElement paninatorNext;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[3]")
	private WebElement paninatorLast;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[4]")
	private WebElement paninatorFinal;

	@FindBy(xpath = "//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']")
	private List<WebElement> pageNumberButtons;

	// Locator for the entire table
	@FindBy(xpath = "//p-table//table/tbody/tr")
	private List<WebElement> rows;

	// Locator for the edit buttons within each row
	@FindBy(xpath = "//body[1]/app-root[1]/app-batch[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/span[1]/button[1]")
	private List<WebElement> editButtons;

	@FindBy(xpath = "(//span[@class='p-button-icon pi pi-pencil'])[1]")
	private WebElement BatcheditButtons;

	// Locator for the delete buttons within each row
	@FindBy(xpath = ".//button[contains(@class, 'p-button-danger')]")
	private List<WebElement> deleteButtons;

	// Locator for the checkboxes within each row
	@FindBy(xpath = ".//div[@role='checkbox']")
	private List<WebElement> checkboxes;

	@FindBy(xpath = "//tbody/tr[1]/td[7]/div[1]/span[2]/button[1]")
	private WebElement firstDeleteButton;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox")
	private WebElement firstCheckbox;

	@FindBy(xpath = "//span[normalize-space()='Yes']")
	private WebElement yesButton;

	@FindBy(xpath = "//span[normalize-space()='No']")
	private WebElement noButton;

	@FindBy(xpath = "//tbody/tr[1]/td[7]/div[1]/span[2]/button[1]")
	private WebElement Deletepopup;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alertMsg;

	// Add new Batch pop locators

	@FindBy(xpath = "//button[normalize-space()='Add New Batch']")
	private WebElement Addnewbatchbutton;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog[1]/div/div")
	private WebElement PopupAddBatch;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog[1]/div/div")
	private WebElement PopupEditBatch;

	@FindBy(xpath = "//input[@placeholder='Select a Program name']")
	private WebElement programnameinput;

	@FindBy(xpath = "//*[@id=\"programName\"]/div/div[2]")
	private WebElement Programdropdowntrigger;

	@FindBy(xpath = "//*[@id=\"programName\"]/div/input")
	private WebElement Programnamefiled;

	@FindBy(css = "ul.p-dropdown-items")
	private WebElement dropdownOptions;

	@FindBy(tagName = "li")
	private List<WebElement> dropdownItems;

	@FindBy(xpath = "//input[@id='batchProg']")
	private WebElement batchprefixfield;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog[1]/div/div/div[2]/div[2]/input[3]")
	private WebElement batchNamefield;

	@FindBy(xpath = "//body//app-root//input[2]")
	private WebElement batchsuffixfield;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog[1]/div/div/div[2]/div[2]/small")
	private WebElement batcherror;

	@FindBy(xpath = "//small[normalize-space()='Batch Description is required.']")
	private WebElement DescriptionError;

	@FindBy(xpath = "//small[@id='text-danger']")
	private WebElement BatcheditDescriptionError;

	@FindBy(xpath = "//div[@class='p-field ng-star-inserted']//small[@id='text-danger']")
	private WebElement Noofclasseserror;

	@FindBy(xpath = "//small[normalize-space()='Status is required.']")
	private WebElement Statuserror;

	// add batch label
	@FindBy(css = "label[for='programName']")
	private WebElement programNameLabel;

	@FindBy(css = "label[for='batchName']")
	private WebElement batchNameLabel;

	@FindBy(css = "label[for='batchDescription']")
	private WebElement batchdescription;

	@FindBy(xpath = "//div[@class='radio ng-star-inserted']")
	private WebElement statusLabel;

	@FindBy(css = "label[for='batchNoOfClasses']")
	private WebElement numberOfClassesLabel;

	@FindBy(xpath = "//input[@id='batchNoOfClasses']")
	private WebElement numberOfClassesInput;

	@FindBy(xpath = "//input[@id='batchDescription']")
	private WebElement batchDecriptioninput;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	private WebElement cancelButton;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog[1]/div/div/div[1]/div/button")
	private WebElement closeButton;

	@FindBy(xpath = "//body[1]/app-root[1]/app-batch[1]/p-dialog[1]/div[1]/div[1]/div[2]/div[4]/div[2]/p-radiobutton[1]/div[1]/div[2]")
	private WebElement Activeradiobutton;

	@FindBy(xpath = "//div[contains(text(),'INACTIVE')]//div[2]")
	private WebElement InActiveradiobutton;

	// Row locators
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[1]/p-tableheadercheckbox/div/div[2]")
	private WebElement checkbox1;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]")
	private WebElement checkbox2;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[2]/td[1]/p-tablecheckbox/div/div[2]")
	private WebElement checkbox3;

	@FindBy(xpath = "//div[contains(@class, 'ng-tns-c168-6 p-dialog-content')]")
	private WebElement batchDetailsPopup;

	@FindBy(xpath = "//div[text()='Successful']")
	private WebElement successMessage;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-confirmdialog/div/div/div[3]")
	private WebElement alertBox;

	private Actions actions;

	@FindBy(xpath = "//li[contains(@class, 'p-dropdown-item')]")
	private List<WebElement> programOptions;

	// Searchbar elements
	@FindBy(xpath = "(//input[@id='filterGlobal'])[1]")
	private WebElement searchTextBox;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr/td[2]")

	private WebElement BatchNameFirstRecord;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[3]")
	private WebElement BatchDescFirstRecord;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[4]")
	private WebElement BatchStatusFirstRecord;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[1]")
	private WebElement paginationTextwithZeroRecord;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]")
	private WebElement searchresultbatch;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[1]")
	private WebElement searchresultinvaliddatabatch;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[1]")
	private WebElement searchresultpartialdatadatabatch;

	public Batch_Page(WebDriver driver, TestContext context) {
		this.driver = context.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.context = context;
		PageFactory.initElements(driver, this);
		this.actions = context.getActions();
		this.js = (JavascriptExecutor) this.driver;

	}

	public void Login(String username, String password) {
		wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
		wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(roleDropdwn)).click();
		wait.until(ExpectedConditions.elementToBeClickable(AdminRole)).click();
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	}

	public void navigateToBatch() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(Batch)).click();

	}

//Dropdown
	public void openProgramDropdown() {
		Programdropdowntrigger.click(); // Interact with the dropdown
	}

	public boolean isPaginationVisible() {
		return PaginationElement.isDisplayed();
	}

	public boolean toolbarVisible() {
		return toolbar.isDisplayed();
	}

	public boolean isMultipleDeleteIconDisabled() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.visibilityOf(DeleteIconHeader));
			return DeleteIconHeader.isEnabled() == false; // Check if it is disabled
		} catch (NoSuchElementException e) {
			return false; // Handle if the button is not found
		}
	}

	public List<String> getActualHeaders() {

		wait.until(ExpectedConditions.visibilityOf(Batchnameicon));
		wait.until(ExpectedConditions.visibilityOf(Batchdescription));
		wait.until(ExpectedConditions.visibilityOf(Batchstatus));
		wait.until(ExpectedConditions.visibilityOf(Noofclasses));
		wait.until(ExpectedConditions.visibilityOf(programname));
		wait.until(ExpectedConditions.visibilityOf(EditDelete));

		return List.of(

				Batchnameicon.getText().trim(), Batchdescription.getText().trim(), Batchstatus.getText().trim(),
				Noofclasses.getText().trim(), programname.getText().trim(), EditDelete.getText().trim());

	}

	public void validateHeaders() {
		List<String> actualHeaders = getActualHeaders();

		// actual and expected headers for debugging
		System.out.println("Actual Headers: " + actualHeaders);
		System.out.println("Expected Headers: " + expectedHeaders);

		// Assertion to check for header equality
		if (!actualHeaders.equals(expectedHeaders)) {
			throw new AssertionError("Batch page validation failed. Expected headers: " + expectedHeaders
					+ ", but found: " + actualHeaders);
		}
	}

	public boolean arePaginationControlsEnabled() {
		return PaginationElement.isDisplayed();
	}

//all edit buttons are displayed method
	public boolean areEditButtonsDisplayed() {
		for (WebElement editButton : editButtons) {
			wait.until(ExpectedConditions.visibilityOf(editButton)); // Wait for edit button to be visible
			if (!editButton.isDisplayed()) {
				return false; // Return false if any edit button is not displayed
			}
		}
		return true; // All edit buttons are displayed return true
	}

//all delete buttons are displayed method
	public boolean areDeleteButtonsDisplayed() {
		for (WebElement deleteButton : deleteButtons) {
			wait.until(ExpectedConditions.visibilityOf(deleteButton)); // Wait for delete button to be visible
			if (!deleteButton.isDisplayed()) {
				return false; // not displeayed return false
			}
		}
		return true; // All delete buttons are displayed return true
	}

	// Check if all checkboxes are displayed
	public boolean areCheckboxesDisplayed() {
		for (WebElement checkbox : checkboxes) {
			wait.until(ExpectedConditions.visibilityOf(checkbox)); // Wait for checkbox to be visible
			if (!checkbox.isDisplayed()) {
				return false; // Return false if any checkbox is not displayed
			}
		}
		return true; // All checkboxes are displayed
	}

	// dataheader checkbox and sort
	public boolean isCheckboxHeaderDisplayed() {
		// Wait for the checkbox header to be visible
		wait.until(ExpectedConditions.visibilityOf(checkboxheader));
		// Check if the checkbox header is displayed
		return checkboxheader.isDisplayed();
	}

	// Method to check if sorting is enabled
	public boolean areSortingIconsDisplayed() {
		return Batchnamesortingicon.isDisplayed() && Batchdescriptionsorticon.isDisplayed()
				&& Batchstatussortingicon.isDisplayed() && Noofclassessortingicon.isDisplayed()
				&& programnamesortingicon.isDisplayed();
	}

	public boolean isHeaderTextCorrect(String expectedText) {
		return Header.getText().trim().equals(expectedText);
	}

	public boolean isToolbarTextCorrect(String expectedText) {
		return toolbar.getText().trim().equals(expectedText);
	}

	public String getFooterText() {
		return Footer.getText().trim();
	}

	public String ProgramnametextText() {
		return Programnamefiled.getText();
	}

	public String ProgramnamePrefixText() {
		return programnameinput.getText();
	}

	public boolean isFooterTextCorrect(String expectedText) {
		return Footer.getText().trim().equals(expectedText);
	}

	// Add newbatch
	public void clickAddNewBatchButton() {
		Addnewbatchbutton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Add new batch field validation

	public void enterDescription(String description) {
		batchDecriptioninput.clear();
		batchDecriptioninput.sendKeys(description);
	}

	public void enterNumberOfClasses(String numClasses) {
		numberOfClassesInput.clear();
		numberOfClassesInput.sendKeys(numClasses);
	}

	public void clickButton(String button) {
		if (button.equalsIgnoreCase("save")) {
			saveButton.click();
		} else if (button.equalsIgnoreCase("cancel")) {
			cancelButton.click();
		}
	}

	// Verify all field
	public boolean isFieldDisplayed(String fieldName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		switch (fieldName) {

		case "Batch Name":
			return batchNameLabel.isDisplayed();
		case "Program Name as drop down":
			return programNameLabel.isDisplayed();
		case "Number of classes":
			return numberOfClassesLabel.isDisplayed() && numberOfClassesInput.isDisplayed();
		case "Description as text box":
			return batchdescription.isDisplayed();
		case "Status as radio button":

			wait.until(ExpectedConditions.visibilityOf(statusLabel));

			return statusLabel.isDisplayed() && statusLabel.isEnabled();
		case "close":
			return closeButton.isDisplayed() && closeButton.isEnabled();
		case "Save Button":
			wait.until(ExpectedConditions.visibilityOf(saveButton)); // Wait for visibility
			return saveButton.isDisplayed() && saveButton.isEnabled();
		case "Cancel Button":
			wait.until(ExpectedConditions.visibilityOf(cancelButton)); // Wait for visibility
			return cancelButton.isDisplayed() && cancelButton.isEnabled();
		default:
			return false;
		}

	}

	// selected program is present in the prefix
	public boolean isSelectedProgramReflected() {
		wait.until(ExpectedConditions.visibilityOf(batchprefixfield));

		return batchprefixfield.getDomAttribute("text").equalsIgnoreCase(dropdownItems.get(0).getText());
	}

	public void inputPrefixValue() {
		batchprefixfield.sendKeys("abc");

	}

	// Method to validate that the Batch Name text box is non-editable
	public boolean validateBatchTextBoxNonEditable() {
		try {
			// Wait until the Batch Name text box is visible
			wait.until(ExpectedConditions.visibilityOf(batchprefixfield));

			// Check for 'readonly' attribute
			String readOnlyAttr = batchprefixfield.getAttribute("readonly");
			boolean isReadOnly = readOnlyAttr != null;

			// Check for 'disabled' attribute
			String disabledAttr = batchprefixfield.getAttribute("disabled");
			boolean isDisabled = disabledAttr != null;

			// Return true if the input box is either readonly or disabled
			return isReadOnly || isDisabled;
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
			return false;
		}
	}

	public String getBatchPrefixValue() {
		// Wait for the batch prefix field to be visible
		wait.until(ExpectedConditions.visibilityOf(batchprefixfield)).click();
		// Return the value of the batch prefix field
		return batchprefixfield.getText();
	}

	public void Clickprefixbatchname() {
		batchprefixfield.click();
	}

	public String getErrorMessage() {
		try {
			// Wait until the error message element is visible
			wait.until(ExpectedConditions.visibilityOf(batcherror));
			return batcherror.getText(); // Return the actual error message text
		} catch (Exception e) {
			return ""; // Return an empty string if the error message is not found
		}
	}

//Edit validation
	public void clickEditButton() {

		// list of edit buttons is not empty
		if (!editButtons.isEmpty()) {

			waitUntilEditButtonIsClickable(editButtons.get(0));

			editButtons.get(0).click();
		} else {
			throw new RuntimeException("No edit buttons found.");
		}
	}

	public void clickEditBatchBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		waitUntilEditButtonIsClickable(editButtons.get(0));
	}

	// Wait
	private void waitUntilEditButtonIsClickable(WebElement button) {
		wait.until(ExpectedConditions.elementToBeClickable(button));
	}

//  program name field is disabled method
	public boolean isProgramNameFieldDisabled() {
		return !programnameinput.isEnabled();
	}

	// batch name field is disabled method
	public boolean isBatchNameFieldDisabled() {
		return !batchprefixfield.isEnabled();
	}

	public boolean isEditBatchNameFieldDisabled() {
		return !batchNamefield.isEnabled();
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickBatchEditButton() {
		BatcheditButtons.click();
	}

	public void clickCancelButton() {
		cancelButton.click();
	}

	public void clickCloseButton() {
		closeButton.click();
	}

	public boolean isBatchErrorDisplayed() {
		return batcherror.isDisplayed();
	}

	public boolean isDescriptionErrorDisplayed() {
		return DescriptionError.isDisplayed();
	}

	public boolean isEditBatchDescriptionErrorDisplayed() {
		return BatcheditDescriptionError.isDisplayed();
	}

	public boolean isBatcheditpopupdisplayed() {
		return PopupEditBatch.isDisplayed();
	}

	public boolean isNumberOfClassesErrorDisplayed() {
		return Noofclasseserror.isDisplayed();
	}

	public boolean isStatusErrorDisplayed() {
		return Statuserror.isDisplayed();
	}

	public void enterValidDataInMandatoryFields() {
		enterDescription("Valid Batch Description"); // Replace with actual valid data
		enterNumberOfClasses("5"); // Replace with actual valid data
	}

	private void ensureDropdownIsClosed() {
		// Check if the dropdown is open and close it if necessary
		String ariaExpanded = Programdropdowntrigger.getAttribute("aria-expanded");
		if ("true".equals(ariaExpanded)) { // Ensure we're comparing to "true" safely
			Programdropdowntrigger.click(); // Click to close the dropdown
		}
	}

	// single delete

	public void clickOnDeleteIcon() {
		// double click or use single click as per your requirement
		if (context == null) {
			throw new IllegalStateException("TestContext is not initialized");
		}
		Actions actions = context.getActions();
		actions.doubleClick(firstDeleteButton).perform();
	}

	public void clickOnHeaderDeleteIcon() {

		DeleteIconHeader.click();
	}

	public void confirmDeletion() {
		if (yesButton.isDisplayed() && yesButton.isEnabled()) {
			System.out.println("Yes button is displayed and enabled.");
		} else {
			System.out.println("Yes button is not interactable.");
			return; // Exit the method if the button isn't clickable
		}

		// creating object for action class

		Actions actions = context.getActions();

		// movin gto Yes button and clicking
		actions.moveToElement(yesButton).click().perform();

		// Wait for the success message to be visible
		wait.until(ExpectedConditions.visibilityOf(alertMsg));

		// Capture the success message text
		String successText = alertMsg.getText();
		System.out.println(successText);
	}

	public void cancelDeletion() {

		noButton.click();
	}

	public boolean isSuccessMessageDisplayed() {
		// Check if the success message is displayed
		return alertMsg.isDisplayed();
	}

	public String getSuccessMessageText() {

		return alertMsg.getText();
	}

	public void CloseDletePopup() {

		CloseDeletePopup.click();
	}

	public boolean isAlertBoxDisplayed() {
		return alertBox.isDisplayed(); // Will return true if the alert box is displayed
	}
	// single row delete

	public void clickDeleteIconForSpecificBatch() {
		firstCheckbox.click();
	}

	// Method to verify the row has been deleted
	public boolean isRowDeleted() {
		// a list of all rows in table
		for (WebElement row : rows) {

			if (row.getText().contains("BatchIdentifier")) {
				return false; // Row still exists
			}
		}
		return true; // Row has been deleted
	}

//multiple delete
	public void multipleDeleteAction() {

		actions.moveToElement(checkbox2).click().perform();

		for (WebElement checkbox : checkboxes) {
			if (checkbox3.isEnabled() && checkbox3.isDisplayed()) {

				actions.moveToElement(checkbox3).click().perform();
			}
		}
	}

//Method to verify that all rows have been deleted
	public boolean areAllRowsDeleted() {

		for (WebElement row : rows) {

			if (row.getText().contains("batchIdentifier")) {
				return false;
			}
		}
		return true;
	}

	public boolean Checkboxselected() {
		return firstCheckbox.isSelected();
	}

//Method to click 'Next' button	
	public void clickNextPage() {
		if (paninatorNext != null && paninatorNext.isDisplayed()) {
			js.executeScript("arguments[0].scrollIntoView(true);", paninatorNext);
			paninatorNext.click();
		} else {
			throw new NoSuchElementException("Next button not found on the page.");
		}
	}

//Method to click 'Previous' button
	public void clickPreviousPage() {
		if (paninatorPrevious != null && paninatorPrevious.isDisplayed()) {
			js.executeScript("arguments[0].scrollIntoView(true);", paninatorPrevious);
			paninatorNext.click();
			paninatorPrevious.click();
		} else {
			throw new NoSuchElementException("Previous button not found on the page.");
		}
	}

// Method to click 'First' button
	public void clickFirstPage() {
		if (paninatorFirstbutton != null && paninatorFirstbutton.isDisplayed()) {
			js.executeScript("arguments[0].scrollIntoView(true);", paninatorFirstbutton);
			paninatorNext.click();
			paninatorFirstbutton.click();
		} else {
			throw new NoSuchElementException("First button not found on the page.");
		}

	}

//Method to click 'Last' button
	public void clickLastPage() {
		if (paninatorFinal != null && paninatorFinal.isDisplayed()) {
			js.executeScript("arguments[0].scrollIntoView(true);", paninatorFinal);
			paninatorFinal.click();
		} else {
			throw new NoSuchElementException("Last button not found on the page.");
		}

	}

	// Check if 'Next' button is enabled
	public boolean isNextButtonEnabled() {
		return !paninatorNext.getAttribute("class").contains("p-disabled");
	}

	public boolean isFinalButtonEnabled() {
		return !paninatorFinal.getAttribute("class").contains("p-disabled");
	}

	// Check if 'Previous' button is enabled
	public boolean isPrevButtonEnabled() {
		return !paninatorPrevious.getAttribute("class").contains("p-disabled");
	}

	// Check if 'First' button is enabled
	public boolean isFirstButtonEnabled() {
		return !paninatorFirstbutton.getAttribute("class").contains("p-disabled");
	}

	// Method to get current pagination text
	public String getCurrentEntriesText() {
		return paninatorCurrenttext.getText();
	}

	public boolean hasNextPageResults() {
		// Return true if there are results; false otherwise
		return !rows.isEmpty();
	}

	private void doubleClick(WebElement element) {
		Actions actions = new Actions(driver); // Create an Actions instance
		actions.moveToElement(element).doubleClick().perform(); // Move to the element and double-click
	}

	private void waitForResultsToLoad() {
		wait.until(ExpectedConditions.visibilityOfAllElements(rows));
	}

	// searchbox

	public void searchInBatchPage(String SearchData) {

		actions.doubleClick(searchTextBox).perform(); // Double-click to activate search
		Searchbox.clear(); // Clear any existing text in the search box
		Searchbox.sendKeys(SearchData); // Type in the batch name
		Searchbox.click(); // Hit Enter to initiate search
	}

	public String FirstbatchnameText() {
		return BatchNameFirstRecord.getText();
	}

	public String FirstbatchdescText() {
		return BatchDescFirstRecord.getText();
	}

	public String FirstbatchstatusText() {

		return BatchStatusFirstRecord.getText();
	}

	public String Invalidsearchdataresult() {

		return searchresultinvaliddatabatch.getText();
	}

	public String PartialbatchNamesearchdataresult() {

		return searchresultpartialdatadatabatch.getText();
	}

	public void Searchbatchframe() {
		searchresultbatch.click();
	}

	public void verifyZeroRecordText() {
		wait.until(ExpectedConditions.textToBePresentInElement(paginationTextwithZeroRecord,
				"Showing 0 to 0 of 0 entries"));

		String actualText = paginationTextwithZeroRecord.getText().trim();
		Assert.assertTrue(actualText.contains("Showing 0 to 0 of 0 entries"));
	}

	public void verifyMultipleRecordText() {
		wait.until(ExpectedConditions.textToBePresentInElement(searchresultpartialdatadatabatch,
				"Showing 1 to 10 of 12 entries"));

		String actualText = searchresultpartialdatadatabatch.getText().trim();
		Assert.assertTrue(actualText.contains("Showing 1 to 10 of 12 entries"));
	}

	// Method to get all displayed rows in the table
	public List<WebElement> getDisplayedRows() {
		return rows; // Returns the currently displayed rows
	}

	// Method to check if a batch with the given name is displayed
	public boolean isBatchDisplayed(String batchname) {
		return rows.stream().anyMatch(row -> row.getText().equalsIgnoreCase(batchname));
	}

	public void enterBatchNameSuffix(String BatchName) {
		wait.until(ExpectedConditions.visibilityOf(batchsuffixfield));
		batchsuffixfield.clear();
		batchsuffixfield.sendKeys(BatchName);
	}

	public void selectProgramFromDropdown() {
		// Click to open the dropdown
		wait.until(ExpectedConditions.elementToBeClickable(Programdropdowntrigger)).click();

		// Wait for dropdown items to be visible
		wait.until(ExpectedConditions.visibilityOfAllElements(dropdownItems));

		// Ensure there are dropdown items to select
		if (!dropdownItems.isEmpty()) {
			dropdownItems.get(0).click(); // Click the first program in the list
		} else {
			System.out.println("Dropdown is empty");
			throw new RuntimeException("No items in the dropdown");
		}
		ensureDropdownIsClosed();
	}

	public void enterValidDataAllMandatoryFields() {
		batchsuffixfield.sendKeys("48");

		numberOfClassesInput.sendKeys("8");

		Activeradiobutton.click();

		batchDecriptioninput.sendKeys("Java");
	}

	public void enterinValidDataAllMandatoryFields() {

		batchDecriptioninput.clear();
		batchDecriptioninput.sendKeys("89*");
		Activeradiobutton.click();
	}

	public void enterValidDataBatcheditAllMandatoryFields() {

		batchDecriptioninput.clear();
		batchDecriptioninput.sendKeys("Java Coding");
		Activeradiobutton.click();
	}

	public boolean isPopupDisplayed() {

		return PopupAddBatch.isDisplayed();
	}

	public boolean isPopupClosed() {
		try {
			return !PopupAddBatch.isDisplayed();
		} catch (NoSuchElementException e) {
			return true; // Popup is not present, hence closed
		}
	}

	public boolean isDeletePopUpDisplayed() {
		return Deletepopup.isDisplayed();
	}

	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public String elementGetText(WebElement element) {
		String Readtext = element.getText();
		return Readtext;
	}

	public String batchFirstName() {		
		return BatchNameFirstRecord.getText();
	}

}
