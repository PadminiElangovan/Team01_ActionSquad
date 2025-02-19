package common;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import driverFactory.DriverConfig;
import io.cucumber.java.Scenario;



		public class Screenshot {
        
	    public static void takeScreenshot(Scenario scenario) {
	        WebDriver driver = DriverConfig.getDriverInstance();
	        if (driver == null) {
	            LoggerLoad.warn("WebDriver instance is null. Cannot take screenshot.");
	            return;
	        } 
	        if (driver instanceof TakesScreenshot) {
	            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
	            File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
	            String screenshotName = scenario.getName().replaceAll("[\\\\/:*?\"<>|]", "_")  + ".png";
	            
	            
	            File destinationFile = new File("screenshots/" + screenshotName);
	            try {
	                FileUtils.copyFile(screenshot, destinationFile);
	                LoggerLoad.info("Screenshot saved to:" + destinationFile.getAbsolutePath());
	            } catch (IOException e) {
	            	LoggerLoad.error("Screenshot IOException" +e.getMessage());
	                e.printStackTrace();
	            }
	        } else {
	            LoggerLoad.warn("Driver is not supporting to take the Screenshot");
	        }

	        byte[] screenshot = ((TakesScreenshot) DriverConfig.getDriverInstance()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
			
	    }
	}
