package driverSetUp;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.ByteArrayInputStream;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class Hooks extends BaseTest {
	@Before
    public void beforeScenario(Scenario scenario) {
		 if (!scenario.getSourceTagNames().contains("@git")) {
	            initialize();
	        }
    }

    @After
    public void afterScenario(Scenario scenario) {
    	if (!scenario.getSourceTagNames().contains("@git")) {
            if (scenario.isFailed()) {
                try {
                    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                    Allure.addAttachment("Failed Scenario Screenshot", new ByteArrayInputStream(screenshot));
                    scenario.attach(screenshot, "image/png", "Failure Screenshot");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            tearDown();
        }
    }

}
