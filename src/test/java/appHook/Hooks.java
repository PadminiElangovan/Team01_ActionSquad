package appHook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import common.ConfigReader;
import common.LoggerLoad;
import common.Screenshot;
import driverFactory.DriverConfig;


	public class Hooks {
			  
		    @Before(order = 1)
		    public  void setUpDriver() {
		    	
		    		String browser = ConfigReader.getProperty("Browser");
		            DriverConfig.getdriver(browser);
		            LoggerLoad.info(browser + " Browser is opened" );		        
		    }
		    	
		 	    
		    @After(order=2)		   
		    public void screenshot(Scenario scenario) {
		    	
				if(scenario.isFailed()) 
				{	
				Screenshot.takeScreenshot(scenario);	
				LoggerLoad.info("ScreenShot is captured for Failure Scenarios");
				}
		    }
		    
		    
		   @After(order=1)
		  public static void tearDown() {
			   
			   LoggerLoad.info("Closing the WebDriver instance");
		       DriverConfig.quitdriver();
		       
		     }

		}
