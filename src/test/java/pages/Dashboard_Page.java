package pages;

import java.time.Duration;

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
	@FindBy(xpath = "//button[@id ='dashboard']") public WebElement HomeMenu;
	@FindBy(xpath = "//button[@id ='program']") public WebElement ProgramMenu;
	@FindBy(xpath = "//span[text()='Batch']") public WebElement BatchMenu;
	@FindBy(xpath = "//span[text()='Class']") public WebElement ClassMenu;
	@FindBy(xpath = "//button[@id ='logout']") public WebElement LogoutMenu;
	
	
	 public Dashboard_Page(WebDriver driver,TestContext context){
	    	this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        this.context = context;
	        PageFactory.initElements(driver, this);
	    }

}
