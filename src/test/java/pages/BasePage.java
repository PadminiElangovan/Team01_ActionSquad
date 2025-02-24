package pages;


import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	static WebDriver driver;
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
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
		try {
			boolean status = element.isDisplayed();
			return status;
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean isSortingbuttonDisplayed(List<WebElement> elements) {
		boolean flag = true;
		if (elements.size() > 1) {
			for (int i = 1; i < elements.size(); i++) {
				WebElement element = elements.get(i);
				if (!element.isDisplayed()) {
					flag = false;
					break; }
			}
		} else {
			flag = false;
		}
		return flag;
	}
	
	
	public  boolean IsAlertPresent() {
    	try {
    		wait.until(ExpectedConditions.alertIsPresent());
    	return true;
    }catch (NoAlertPresentException e) {
    	return false;}
    }
	
    public String AlertText() {
    	if(IsAlertPresent()) {	
    		wait.until(ExpectedConditions.alertIsPresent());
    		Alert alert = driver.switchTo().alert();
    		return alert.getText();
    	}else {
    		System.out.println("Alert is not present");
    	}
		return null;
    }
    
    public void AcceptAlert() {
 	   Alert alert = driver.switchTo().alert();
     try {
     	wait.until(ExpectedConditions.alertIsPresent());
         alert.accept();
         System.out.println("Alert accepted successfully.");
     } catch (NoAlertPresentException e) {
     	alert.accept();
         System.out.println("No alert present. Exception: " + e.getMessage());
     } catch (UnhandledAlertException  e) {
     	alert.accept();
         System.out.println("An unexpected exception occurred: " + e.getMessage());
     }
 }
   

}
