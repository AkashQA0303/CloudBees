package locators;

import java.util.Map;

import org.openqa.selenium.By;

public class LocatorHelper {
	private static final String platform = System.getProperty("platform", "web").toLowerCase();

    public static By getLocator(Map<String, By> locatorMap) {
        if (!locatorMap.containsKey(platform)) {
            throw new RuntimeException("Locator not defined for platform: " + platform);
        }
        return locatorMap.get(platform);
    }
}
