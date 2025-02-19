package appHook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.ConfigReader;
import java.time.Duration;

public class TestContext {
    
	private WebDriver driver;
	private DriverConfig driverConfig;
	private WebDriverWait wait;
	private ConfigReader configReader;
	private Actions actions;
	

	// initializing the DriverFactory
	public TestContext() {
		this.driverConfig = new DriverConfig();
		this.configReader = new ConfigReader(); // config reader initilise

	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.actions = new Actions(driver); // Initialize Actions here, after driver is set
			}

	public DriverConfig getDriverConfig() {
		return driverConfig;
	}

	// WebDriver instance
	public WebDriver getDriver() {
		return driver;
	}

// driver close
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

	
}