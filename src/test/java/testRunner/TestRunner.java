package testRunner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import common.ConfigReader;
import common.LoggerLoad;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class) 
@CucumberOptions(
		plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", //Allure Report
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", //Extent Report
				"json:target/CucumberReports/LMSJson.json","html:target/CucumberReports/LMS.html", //Cucumber Report
				"com.aventstack.chaintest.plugins.ChainTestCucumberListener:", //ChainTest Report
				"rerun:target/rerun.txt"}, //Rerun failed Scenario
		monochrome=false,  //console output color
		tags="@Dash", //tags from feature file
		features = {"src/test/resources/Feature files"}, //location of feature files
		glue= {"stepDefinitions","appHook"}) //location of step definition files

	public class TestRunner extends AbstractTestNGCucumberTests{
		
	@BeforeTest
	@Parameters({"browser"})
	public void defineBrowser(String browser) throws Throwable {
		LoggerLoad.info(browser + " is Running");
		ConfigReader.properties.setProperty("Browser", browser);
	} 

	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
				
		return super.scenarios();
    } 
}