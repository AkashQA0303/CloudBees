package utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

	    private WebDriver driver;
	    private WebDriverWait wait;

	    // Constructor
	    public WaitHelper(WebDriver driver, long timeoutInSeconds) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    }

	    public WebElement waitForElementToBeVisible(By locator) {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	    public WebElement waitForElementToBeClickable(By locator) {
	        return wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }

	    public boolean waitForTextToBePresentInElement(By locator, String text) {
	        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	    }

	    public boolean waitForPageTitle(String title) {
	        return wait.until(ExpectedConditions.titleIs(title));
	    }
	    
	   
	    
	    
}
