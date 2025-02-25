package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import appHook.TestContext;

public class LMSAddonPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	TestContext context;

	
	public LMSAddonPage(WebDriver driver, TestContext context) {
		this.driver = context.getDriver();
		this.context = context;
	
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath = "//span[text()='Home']") public WebElement homeHeader;
	@FindBy(xpath = "//span[text()='Program']") public WebElement programHeader;
	@FindBy(xpath = "//span[text()='Batch']") public WebElement batchHeader;
	@FindBy(xpath = "//span[text()='Class']") public WebElement classHeader;
	@FindBy(xpath = "//span[text()='Logout']") public WebElement logoutHeader;
	@FindBy(xpath = "//button[@role='menuitem']") public WebElement SubMenu;
	
	@FindBy(xpath = "//input[@id='filterGlobal']") public WebElement Search;
	@FindBy(xpath = "//tbody/tr") public List<WebElement> Table;
	@FindBy(xpath = "//div[@class='p-datatable-footer ng-star-inserted']") public WebElement footer;
	
	@FindBy(xpath = "//p-tableheadercheckbox//div[@role='checkbox']") public WebElement AllChkBox;
	@FindBy(xpath = "//div[@role='checkbox']")List<WebElement> multicheckbox;
	@FindBy(xpath = "//mat-card-title//button") public WebElement DeleteAllIcon;
	@FindBy(xpath = "//tbody/tr[1]//button[@icon='pi pi-trash']") public WebElement DeleteR1Icon;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]") public WebElement DeleteR1Data;
	@FindBy(xpath = "//tbody/tr[1]/td[3]") public WebElement DeleteClassData;
	@FindBy(xpath = "//div/i") public WebElement WarningIcon;
	@FindBy(xpath = "//p-confirmdialog/div/div/div[2]/span") public WebElement PrgDeleteMsg;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]") public WebElement saveProgram;
	@FindBy(xpath = "//input[@id='programName']") public WebElement programNameText;
	@FindBy(xpath = "//input[@id='programDescription']") public WebElement programDescText;
	@FindBy(xpath = "//input[@id='batchDescription']") public WebElement batchDescText;
	@FindBy(xpath = "//div[contains(text(),'Active')]//div[2]") public WebElement statusActive;
	@FindBy(xpath = "//small") public WebElement Errormessage;
	@FindBy(xpath = "//small") public List<WebElement> Errors;
	@FindBy(xpath = "//tbody/tr[1]/td/div/span[1]/button[1]") public WebElement EditIcon;  
	
	String Text = "JaVA";
	
	public void elementclickJs(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}
	
	public void SearchDiff() {
		Search.sendKeys("JaVA");
	}
	public boolean SearchData() {
		return Table.contains("java");
	}
	
	public void DeleteAllWindow() {
		WebElement checkbox = (WebElement) multicheckbox.get(0);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
		try {

			wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
		} catch (ElementClickInterceptedException e) {

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
		}
		
		elementclickJs(DeleteAllIcon);
	}
	
	public void AddPrgNameEmpty() {	
		programDescText.sendKeys("Test");
		statusActive.click();
		saveProgram.click();
	}
	public void AddPrgDesEmpty() {
		programNameText.sendKeys("Test");
		statusActive.click();
		saveProgram.click();
	}
	public void AddPrgStatusEmpty() {
		programNameText.sendKeys("Test");
		programDescText.sendKeys("Test");
		saveProgram.click();
	}
	
	public boolean errormsg() {
		return Errors.isEmpty();
	}
	
	public void sendText(String data) {
		batchDescText.click();
		 Actions actions = new Actions(driver);
	        actions.sendKeys(data).perform();
	}
}
