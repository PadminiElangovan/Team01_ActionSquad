package appHook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestContext {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public TestContext() {
        // Initialize WebDriver from DriverConfig
        this.driver = DriverConfig.getDriver();
        // Initialize WebDriverWait with a timeout of 30 seconds
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        // Initialize Actions
        this.actions = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public Actions getActions() {
        return actions;
    }
}
