package locators;

import org.openqa.selenium.WebDriver;
import utilities.WaitHelper;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;


public class ProductPage {

	WebDriver driver;
	WaitHelper waitHelper;
	
	public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver, 15);
    }

    private final Map<String, By> costSavingsValue = new HashMap<String, By>() {{
        put("web", By.xpath("//p[contains(text(),'Cost Savings')]/following-sibling::div[@data-test='stat.primary']"));
        put("android", By.id(""));
        put("ios", By.id(""));
    }};

    private final Map<String, By> auditorsSecurityLink = new HashMap<String, By>() {{
        put("web", By.xpath("//*[text()='Auditors / Security']"));
        put("android", By.id("android_auditor_security_id"));
        put("ios", By.id("ios_auditor_security_id"));
    }};

    private final Map<String, By> releaseGovernanceText = new HashMap<String, By>() {{
        put("web", By.xpath("//*[text()='Release Governance']/following-sibling::h4"));
        put("android", By.id("android_release_governance_id"));
        put("ios", By.id("ios_release_governance_id"));
    }};

    public String getCostSavings() {
        By locator = LocatorHelper.getLocator(costSavingsValue);
        return waitHelper.waitForElementToBeVisible(locator).getText();
    }

    public void clickAuditorSecurity() {
        By locator = LocatorHelper.getLocator(auditorsSecurityLink);
        waitHelper.waitForElementToBeClickable(locator).click();
    }

    public String verifyReleaseGovernanceText() {
        By locator = LocatorHelper.getLocator(releaseGovernanceText);
        return waitHelper.waitForElementToBeVisible(locator).getText();
    }
}
