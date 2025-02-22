package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
	@FindBy(className="p-checkbox")
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
	@FindBy(xpath="//div[@class='signin-content']")
	private WebElement backdrop;

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
		this.js =(JavascriptExecutor)driver;
	}

	//clicking program button
	public void clickProgram() {
		programBtn.click();
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

	public boolean validatePagination() {
		for (WebElement element : pagination) {
			if (!element.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	private void doubleClick(WebElement element) {
		// Create an Actions instance
		actions.moveToElement(element).doubleClick().perform(); // Move to the element and double-click
	}

	public void  navigateToProgram() {
		doubleClick(programBtn);

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
		return	nextButton.isEnabled();			

	}

	public boolean isPrevButtonEnabled() {
		return prevButton.isDisplayed();
	}

	public boolean isLastButtonEnabled() {
		return lastButton.isEnabled();

	}


}
