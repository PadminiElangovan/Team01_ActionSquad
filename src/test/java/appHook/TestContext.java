	package appHook;


import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.ConfigReader;
import common.ExcelReader;
import driverFactory.DriverConfig;
import pages.Dashboard_Page;
import pages.Login_Page;

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
		this.js =(JavascriptExecutor)driver;
		}

	public DriverConfig getDriverConfig() {
		return driverConfig;
		}

	// WebDriver instance
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
		return configReader.getApplicationURL(); // Method to get URL
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

	
	public Dashboard_Page getDashboard() {
			return Dashboard;
		} 

	public ExcelReader getExcelReader() {
	    return excelReader;
	}
	
	 

	
}