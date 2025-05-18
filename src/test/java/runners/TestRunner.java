package runners;

import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue= {"stepDefinitions","driverSetUp"},
		tags = "@git",
		plugin = {
                "pretty",  // Prints detailed logs in the console
                "json:target/cucumber-report/cucumber.json",  // Generates JSON report
                "html:target/cucumber-report/cucumber.html", // Generates HTML report    
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" //Generate Allure report
        },
        monochrome = true)

public class TestRunner  extends AbstractTestNGCucumberTests{
	
	
}
