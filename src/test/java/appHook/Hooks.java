package appHook;

import common.ConfigReader;
import common.LoggerLoad;
import common.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    private TestContext testContext;

    @Before(order = 1)
    public void setUp() {
        String browser = ConfigReader.getProperty("Browser");
        DriverConfig.initializeDriver(browser);
        testContext = new TestContext();
        LoggerLoad.info(browser + " Browser is opened");
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
        	Screenshot.takeScreenshot(scenario);
            LoggerLoad.info("Screenshot captured for failed scenario: " + scenario.getName());
        }
        DriverConfig.quitDriver();
        LoggerLoad.info("Browser is closed");
    }

    public TestContext getTestContext() {
        return testContext;
    }
}
