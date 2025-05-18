package driverSetUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void initDriver() {
		String platform = ConfigManager.getPlatform();
	    String browser = ConfigManager.getBrowser(); 

        try {
            switch (platform) {
                case "web":
                    if (browser.equals("chrome")) {
                        driver.set(new ChromeDriver());
                    } else if (browser.equals("firefox")) {
                        driver.set(new FirefoxDriver());
                    }
                    driver.get().manage().window().maximize();
                    break;

                case "android":
                    URL androidUrl = new URL("http://localhost:4723/wd/hub");
                    driver.set(new AndroidDriver(androidUrl, CapabilitiesManager.getAndroidOptions()));
                    break;

                case "ios":
                    URL iosUrl = new URL("http://localhost:4723/wd/hub");
                    driver.set(new IOSDriver(iosUrl, CapabilitiesManager.getIOSOptions()));
                    break;

                default:
                    throw new RuntimeException("Invalid platform: " + platform);
            }

            driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize driver: " + e.getMessage());
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

   

}
