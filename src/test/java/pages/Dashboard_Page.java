package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Page {
	WebDriver driver;
	
	public Dashboard_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
