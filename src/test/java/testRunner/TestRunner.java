package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class) 
@CucumberOptions(
		plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", //Allure Report
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", //Extent Report
				"json:target/CucumberReports/DSAlgoJson.json","html:target/CucumberReports/DSAlgoHtml.html", //Cucumber Report
				"com.aventstack.chaintest.plugins.ChainTestCucumberListener:", //ChainTest Report
				"rerun:target/rerun.txt"}, //Rerun failed Scenario
		monochrome=false,  //console output color
		tags="@LMS", //tags from feature file
		features = {"src/test/resources/Feature files"}, //location of feature files
		glue= {"stepDefinitions","appHook"}) //location of step definition files

	public class TestRunner extends AbstractTestNGCucumberTests{
		
		
}