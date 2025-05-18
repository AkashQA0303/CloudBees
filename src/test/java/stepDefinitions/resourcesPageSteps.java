package stepDefinitions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverSetUp.BaseTest;
import driverSetUp.DriverManager;
import io.cucumber.java.en.Then;
import io.qameta.allure.Step;
import locators.ProductPage;

public class resourcesPageSteps extends BaseTest {
	
	public resourcesPageSteps() {
        this.driver = DriverManager.getDriver(); // Always ensure the driver is obtained from DriverManager
        
    }
	
	@Then("user verifies a new tab is opened")
	@Step("user verifies a new tab is opened")
	public void user_verifies_a_new_tab_is_opened() {
	    // Write code here that turns the phrase above into concrete actions
		String originalWindow = driver.getWindowHandle();
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(driver1 -> driver1.getWindowHandles().size() > 1);
		
		Set<String> windowHandles = driver.getWindowHandles();

	    // Switch to the new window
	    for (String handle : windowHandles) {
	        if (!handle.equals(originalWindow)) {
	            driver.switchTo().window(handle);
	            break;
	        }
	    }
	    
	    String currentURL = driver.getCurrentUrl();
	    System.out.println("New tab URL: " + currentURL);
	    Assert.assertNotEquals(currentURL, "", "New tab URL should not be empty");
	}

}
