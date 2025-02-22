package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	@FindBy(xpath = "//span[text()='Batch']") public WebElement batchHeader;
	@FindBy(xpath = "//span[text()='Class']") public WebElement classHeader;
	@FindBy(xpath = "//span[text()='Logout']") public WebElement logoutHeader;
	
	@FindBy(xpath = "//input[@id='filterGlobal']") public WebElement Search;
	@FindBy(xpath = "//tbody/tr") public List<WebElement> Table;
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
}
