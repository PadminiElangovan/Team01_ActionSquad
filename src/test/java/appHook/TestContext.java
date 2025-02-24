package appHook;


import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.ConfigReader;
import common.ExcelReader;
import driverFactory.DriverConfig;
import pages.Batch_Page;
import pages.Dashboard_Page;
import pages.LMSAddonPage;
import pages.Login_Page;
import pages.Program_Page;

public class TestContext {
    
	private WebDriver driver;
	private DriverConfig driverConfig;
	private WebDriverWait wait;
	private ConfigReader configReader;
	private Actions actions;
	private JavascriptExecutor js;// (JavascriptExecutor) driver;

	private ExcelReader excelReader;
	private Login_Page Login;
	private Dashboard_Page Dashboard;
	private Program_Page program;
	private LMSAddonPage common;
	private Batch_Page Batch;
	
	public TestContext() {
		this.driverConfig = new DriverConfig(); // initializing the DriverFactory
		this.configReader = new ConfigReader(); // config reader initilise
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.actions = new Actions(driver);
		this.excelReader= new ExcelReader();
		this.actions = new Actions(driver); // Initialize Actions here
		this.Login = new Login_Page(driver, this);
		this.Dashboard = new Dashboard_Page(driver, this);
		this.common = new LMSAddonPage(driver, this);
		this.js =(JavascriptExecutor)driver;
		this.program = new Program_Page(driver, this);
		this.Batch =new Batch_Page(driver, this);
		}

	public DriverConfig getDriverConfig() {
		return driverConfig;
		}

	public WebDriver getDriver() {
		return driver; 
		}
	
	public void quitDriver() {
		driverConfig.quitDriver();
		}

	public WebDriverWait getWait() {
		return wait;
		}

	public String getApplicationURL() {
		return configReader.getApplicationURL(); 
		}
	
	public Actions getActions() {
		return actions;
		}
	
	public Login_Page getLogin() {
		return Login;

	}
	
	public JavascriptExecutor getJsExecutor() {
	    
	    return js;
	}

	public LMSAddonPage getAddon() {
		return common;
	}
	
	public Dashboard_Page getDashboard() {
			return Dashboard;
		}
	
	public Program_Page getProgram() {
		return program;
	}
 
	public Batch_Page getBatch() {
		return Batch;

	}

	public ExcelReader getExcelReader() {
	    return excelReader;
	}
	
	 	
}