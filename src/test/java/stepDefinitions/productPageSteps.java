package stepDefinitions;

import org.testng.Assert;

import driverSetUp.BaseTest;
import driverSetUp.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import locators.ProductPage;

public class productPageSteps extends BaseTest {
	
	private ProductPage productpage;
	public productPageSteps() {
	        this.driver = DriverManager.getDriver(); // Always ensure the driver is obtained from DriverManager
	        this.productpage = new ProductPage(driver);
	    }

	@Then("user verifies Cost Savings is {string}")
	@Step("user verifies Cost Savings is {string}")
	public void user_verifies_Cost_Savings(String expectedsavings) {
	    // Write code here that turns the phrase above into concrete actions
		String actualvalue= productpage.getCostSavings();
		System.out.println("Actual Value : "+ actualvalue);
		Assert.assertEquals(actualvalue, expectedsavings);
	    
	}
	
	@And("user scrolls down and clicks link")
	@Step("user scrolls down and clicks link")
	public void user_scrolls_down_and_clicks_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    productpage.clickAuditorSecurity();
	}
	
	
	@Then("user verifies text under {string} section is {string}")
	@Step("user verifies text under {string} section is {string}")
	public void verifyTextUnderSection(String sectionHeader, String expectedText) {
		String actualText = productpage.verifyReleaseGovernanceText();
		System.out.println("Text under Release Governance : " + actualText);
		Assert.assertEquals(actualText, expectedText);
	}
	 
}
