package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	static WebDriver driver;
	
   	public static String getPageTitle(WebDriver driver) {
		return driver.getTitle();
   		}
   	
   	public String elementGetText(WebElement element) {
		String Readtext = element.getText();
		return Readtext;
	 }
   	
   	public static void elementClick(WebElement element) {
		element.click();
	 }
   	
   	public static void elementSendkeys(WebElement element, String data) {
		element.sendKeys(data);
	 }
   	
   	public static void elementSendkeysEnter(WebElement element, String data) {
		element.sendKeys(data, Keys.ENTER);
	 }
   	
   	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	 }

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	 }
   	public Point getLocation(WebElement element) {
		return element.getLocation();
	}
	
	public static boolean isElementPresent(WebElement element) {
		
			return element.isDisplayed();
	}

}