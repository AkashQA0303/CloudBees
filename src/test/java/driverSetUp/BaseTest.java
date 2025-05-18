package driverSetUp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	 protected WebDriver driver;

	 public void initialize() {
	        DriverManager.initDriver();
	        driver = DriverManager.getDriver();
	        dismissCookiePopupIfPresent();
	 }

	 public void tearDown() {
	        DriverManager.quitDriver();
	 }   
	 
	 protected void dismissCookiePopupIfPresent() {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	            WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
	            if (cookieBtn.isDisplayed()) {
	                cookieBtn.click();
	            }
	        } catch (Exception e) {
	            // Log or silently ignore if not present
	        }
	    }

}
