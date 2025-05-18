package locators;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverSetUp.ConfigManager;
import utilities.WaitHelper;

public class HomePage {
	
	WebDriver driver;
	WaitHelper waitHelper;
	String platform = ConfigManager.getPlatform();
	
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver, 15);
    }
    
    private final Map<String, Map<String, By>> topMenuLinks = new HashMap<String, Map<String, By>>() {{
        put("web", new HashMap<String, By>() {{
            put("Products", By.xpath("//button[text()='Products']"));
            put("Resources", By.xpath("//button[text()='Resources']"));
            // Add more top menu options
        }});
        put("android", new HashMap<String, By>() {{ /* update if needed */ }});
        put("ios", new HashMap<String, By>() {{ /* update if needed */ }});
    }};
    
    

    private final Map<String, Map<String, By>> subMenuLinks = new HashMap<String, Map<String, By>>() {{
        put("web", new HashMap<String, By>() {{
            put("CloudBees CD/RO", By.xpath("//a[@href='/products/cloudbees-cdro']"));
            put("Documentation", By.xpath("//*[text()='Documentation']"));
            // Add more submenu options
        }});
        put("android", new HashMap<String, By>() {{ /* update if needed */ }});
        put("ios", new HashMap<String, By>() {{ /* update if needed */ }});
    }};

    public void clickTopMenuLink(String menuText) {
        By locator = topMenuLinks.get(platform).get(menuText);
        waitHelper.waitForElementToBeClickable(locator).click();
    }

    public void clickSubMenuLink(String subLinkText) {
        By locator = subMenuLinks.get(platform).get(subLinkText);
        waitHelper.waitForElementToBeClickable(locator).click();
    }
}
