
package stepDefinitions;

import driverSetUp.BaseTest;
import driverSetUp.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import locators.HomePage;

public class homePageSteps extends BaseTest{
	
	private HomePage homePage;
	
	
	@Given("user opens the application {string}")
	@Step("user opens the application {string}")
	public void user_opens_the_application(String url) {
	    // Write code here that turns the phrase above into concrete actions
		driver = DriverManager.getDriver(); // always use DriverManager for consistency
		driver.get(url);
		 dismissCookiePopupIfPresent();
		homePage = new HomePage(driver);
	}
	@When("user clicks top menu link {string}")
	@Step("user clicks top menu link {string}")
	public void user_clicks_top_menu_link(String menuLink) {
		    homePage.clickTopMenuLink(menuLink);
	}
	

	@When("user clicks sub link under top menu {string}")
	@Step("user clicks sub link under top menu {string}")
	public void user_clicks_sub_link_under_top_menu(String subLink) {
		homePage.clickSubMenuLink(subLink);
	}
}
