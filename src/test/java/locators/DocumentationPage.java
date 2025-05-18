package locators;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.WaitHelper;

public class DocumentationPage {
	
	WebDriver driver;
	WaitHelper waitHelper;
	
	public DocumentationPage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver, 15);
    }
	
	private final Map<String, By> searchFields = new HashMap<String, By>() {{
        put("web", By.xpath("//input[@placeholder='Search all CloudBees Resources']"));
        put("android", By.id("android_search_field"));
        put("ios", By.id("ios_search_field"));
    }};
    
    private final Map<String, By> modalDialogLocator = new HashMap<String, By>() {{
        put("web", By.xpath("//*[@class='modal-dialog modal-fullscreen  ']"));
        put("android", By.id("")); // add if applicable
        put("ios", By.id(""));     // add if applicable
    }};
    
    
    private final Map<String, By> searchTextbox = new HashMap<String, By>() {{
        put("web", By.xpath("//input[@placeholder='Search']"));
        put("android", By.id("android_search_field"));
        put("ios", By.id("ios_search_field"));
    }};
    
    public void clickSearchField() {
        By locator = searchFields.get("web"); // use dynamic platform if you integrated ConfigManager
        WebElement searchField = waitHelper.waitForElementToBeClickable(locator);
        searchField.click();
    }
    
    private final Map<String, By> pagination = new HashMap<String, By>() {{
        put("web", By.xpath("//ul[contains(@class,'pagination')]"));
        put("android", By.id("android_pagination"));
        put("ios", By.id("ios_pagination"));
    }};
    
    public boolean isnewTabOpened() {
        By locator = LocatorHelper.getLocator(modalDialogLocator);
        try {
            return waitHelper.waitForElementToBeVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void enterSearchText(String text) {
        By locator = searchTextbox.get("web");
        WebElement searchField = waitHelper.waitForElementToBeVisible(locator);
        searchField.clear();
        searchField.sendKeys(text);
    }
    
    public boolean isPaginationVisible() {
        By locator = pagination.get("web");
        try {
            return waitHelper.waitForElementToBeVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
