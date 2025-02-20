package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	WebDriver driver;
	
	public List<String> getTableHeaders(List<WebElement> headerElements) {
	    List<String> headers = new ArrayList<>();

	    for (WebElement element : headerElements) {
	        headers.add(element.getText().trim());
	        }
	    
	    return headers;
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
	

}
