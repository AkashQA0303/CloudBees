package driverSetUp;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;

public class CapabilitiesManager {

	 public static UiAutomator2Options getAndroidOptions() {
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("Android");
	        options.setDeviceName("emulator-5554"); // Or read from env
	        options.setAppPackage("com.example.app");
	        options.setAppActivity("com.example.app.MainActivity");
	        options.setAutomationName("UiAutomator2");
	        return options;
	    }

	    public static XCUITestOptions getIOSOptions() {
	        XCUITestOptions options = new XCUITestOptions();
	        options.setPlatformName("iOS");
	        options.setDeviceName("iPhone 14 Pro");
	        options.setPlatformVersion("16.4");
	        options.setBundleId("com.example.iosapp");
	        options.setAutomationName("XCUITest");
	        return options;
	    }

}
