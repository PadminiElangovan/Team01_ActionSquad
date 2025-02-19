package appHook;

import common.LoggerLoad;
import org.openqa.selenium.WebDriver;

import common.ConfigReader;
import common.LoggerLoad;
import common.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
    private TestContext testContext;
    private ConfigReader configReader;
    
    public Hooks(TestContext Context) {
    	this.testContext = Context;
    	this.configReader = new ConfigReader();
    }

    @Before(order = 1)
    public void setUp() {
    	LoggerLoad.info("Initializing WebDriver");
        String browser = ConfigReader.getProperty("Browser");
        WebDriver driver =  testContext.getDriverConfig().initialiseBrowser(browser);
        testContext.setDriver(driver);
        LoggerLoad.info(browser + " Browser is opened");
        testContext.getDriver().get(configReader.getApplicationURL());
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
        	Screenshot.takeScreenshot(testContext.getDriver(),scenario);
            LoggerLoad.info("Screenshot captured for failed scenario: " + scenario.getName());
        }
        testContext.quitDriver();
        LoggerLoad.info("Browser is closed");
    }

    }
