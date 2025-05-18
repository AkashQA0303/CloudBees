package stepDefinitions;

import org.testng.Assert;

import driverSetUp.BaseTest;
import driverSetUp.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import locators.DocumentationPage;
import locators.ProductPage;

public class documentationPageSteps extends BaseTest{
	
	private DocumentationPage documentationpage;
	public documentationPageSteps() {
        this.driver = DriverManager.getDriver(); // Always ensure the driver is obtained from DriverManager  
        this.documentationpage = new DocumentationPage(driver);
    }
	
	@When("user clicks in the text field")
	@Step("user clicks in the text field")
	public void user_clicks_in_the_text_field() {
	    // Write code here that turns the phrase above into concrete actions
		documentationpage.clickSearchField();  
	}
	
	
	@Then("user verifies a new page is opened in same tab")
	@Step("user verifies a new page is opened in same tab")
	public void user_verifies_a_new_page_is_opened_in_same_tab() {
		boolean isModalVisible = documentationpage.isnewTabOpened();
	    Assert.assertTrue(isModalVisible, "Modal dialog was not visible after interaction.");
	}
	
	
	@When("user searches for word {string}")
	@Step("user searches for word {string}")
	public void user_searches_for_word(String searchtext) {
	    documentationpage.enterSearchText(searchtext);
	}
	
	
	@Then("user verifies pagination options are visible at the bottom")
	@Step("user verifies pagination options are visible at the bottom")
	public void user_verifies_pagination_options_are_visible_at_the_bottom() {
		Assert.assertTrue(documentationpage.isPaginationVisible(), "Pagination is not visible.");
	}

}
