package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import appHook.TestContext;

public class Program_Page extends BasePage {

	private WebDriver driver;
	private WebDriverWait wait;
	Actions action;
	TestContext context;

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
	List<WebElement> programHeaders = Arrays.asList(appHeader, homeHeader, programBtn, batchHeader, classHeader, logoutHeader,
	manageProgramHeader, programNameHeader, programDescriptionHeader, programStatus,addNewPgm, editDeleteHeader);
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

	public Program_Page(WebDriver driver, TestContext context) {

		this.driver = context.getDriver();
		this.context = context;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
		this.action = new Actions(driver);
	}

	public void clickProgram() {
		programBtn.click();
	}
	
	public List<String> getProgramTableHeaders() {
        return getTableHeaders(programHeaders);
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

	

}
