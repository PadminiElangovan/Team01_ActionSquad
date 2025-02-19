package appHook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class DriverConfig {
	 private WebDriver driver;
	 
	 
	 public WebDriver initialiseBrowser(String browserName) {
	        if (driver == null) {
	            switch (browserName.toLowerCase()) {
	                case "chrome":
	                    WebDriverManager.chromedriver().setup();
	                    driver = new ChromeDriver();
	                    break;
	                case "firefox":
	                    WebDriverManager.firefoxdriver().setup();
	                    driver = new FirefoxDriver();
	                    break;
	                case "edge":
	                    WebDriverManager.edgedriver().setup();
	                    driver = new EdgeDriver();
	                    break;
	                case "safari":
	                    WebDriverManager.safaridriver().setup();
	                    driver = new SafariDriver();
	                    break;
	                default:
	                    throw new IllegalArgumentException("Browser not supported: " + browserName);
	            }
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        }
	        return driver;
	    }
	 
	   public WebDriver getDriver() {
	        return driver;
	    }

	
    public  void quitDriver() {
    	if (driver != null) {
            driver.quit();
        }
    }
}
