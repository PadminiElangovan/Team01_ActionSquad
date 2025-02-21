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


public class Dashboard_Page {
	private TestContext context;
	private WebDriverWait wait;
	WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),'Learning')]") public WebElement HomeTitle;
	@FindBy(xpath = "//mat-card-title/div") public WebElement DashboardSection;
	@FindBy(xpath = "//app-admindata/div/div[2]") public WebElement WelcomeTxt;
	@FindBy(xpath = "//app-admindata/div/div[3]") public WebElement role;
	@FindBy(xpath = "//mat-toolbar//div") public WebElement MenuBar;
	@FindBy(xpath = "//div[@class='ng-star-inserted']//span[normalize-space()]") public List<WebElement> Menus;
	@FindBy(xpath = "//div[@routerlink='/user']/div[1]") public WebElement UsrCount;
	@FindBy(xpath = "//div[@class='widget yellow']//div[@class='top']") public WebElement StaffCount;
	@FindBy(xpath = "//div[@routerlink='/batch']/div[1]") public WebElement BatchCount;
	@FindBy(xpath = "//div[@routerlink='/program']/div[1]") public WebElement ProgramCount;
	@FindBy(xpath = "//app-staffdata/mat-table") public WebElement StaffTable;
	@FindBy(xpath = "//app-staffdata/mat-paginator") public WebElement TablePagination;
	@FindBy(xpath = "//mat-table/mat-row") public List<WebElement> DataRow;
	@FindBy(xpath = "//button[@aria-label='First page']") public WebElement FirstPg;
	@FindBy(xpath = "//button[@aria-label='Previous page']") public WebElement PreviousPg;
	@FindBy(xpath = "//button[@aria-label='Next page']") public WebElement NextPg;
	@FindBy(xpath = "//button[@aria-label='Last page']") public WebElement LastPg;
	@FindBy(xpath = "//button[@id ='dashboard']") public WebElement HomeMenu;
	@FindBy(xpath = "//button[@id ='program']") public WebElement ProgramMenu;
	@FindBy(xpath = "//span[text()='Batch']") public WebElement BatchMenu;
	@FindBy(xpath = "//span[text()='Class']") public WebElement ClassMenu;
	@FindBy(xpath = "//button[@id ='logout']") public WebElement LogoutMenu;
	
	@FindBy(xpath = "//mat-card-content//mat-grid-tile[2]") public WebElement BarChart;
	@FindBy(xpath = "//app-doughnutchart") public WebElement PieChart;
	
	
	 public Dashboard_Page(WebDriver driver,TestContext context){
	    	this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        this.context = context;
	        PageFactory.initElements(driver, this);
	    }

	 public String HomeTitle() {
		 return HomeTitle.getText();
	 }
	 
	 public String WelcomeTxt() {
		 return WelcomeTxt.getText();
	 }
	  public String role() {
		  return role.getText();
	}
	 public int DataRow() {
		
		 return DataRow.size();
	 }
	 public String PageTitle() {
			return driver.getTitle();	
	 }
	public void HomeLink() {
		HomeMenu.click();
	}
	public void ProgramLink() {
		ProgramMenu.click();
	}
}