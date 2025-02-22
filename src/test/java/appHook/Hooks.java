package appHook;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;

import common.ConfigReader;
import common.ExcelReader;
import common.Screenshot;
import common.LoggerLoad;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
    private TestContext testContext;
    private ConfigReader configReader;
    public static List<Map<String, String>> Login;
    public static List<Map<String, String>> Batch;

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
    
    @Before(order = 2)
    public void setUpExcel() {
        try {
            ExcelReader excelreader= new ExcelReader();
            Login = excelreader.getData("Login");
            Batch = excelreader.getData("Batch");
          } catch (Exception e) {
           e.printStackTrace();
           LoggerLoad.error("Error initializing Excel data: " + e.getMessage());
           throw new RuntimeException("Error initializing Excel data: " + e.getMessage());
       }
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