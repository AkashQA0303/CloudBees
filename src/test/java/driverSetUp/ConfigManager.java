package driverSetUp;

public class ConfigManager {

	private static final String DEFAULT_PLATFORM = "web";
    private static final String DEFAULT_BROWSER = "chrome";

    public static String getPlatform() {
        return System.getProperty("platform", System.getenv().getOrDefault("PLATFORM", DEFAULT_PLATFORM)).toLowerCase();
    }

    public static String getBrowser() {
        return System.getProperty("browser", System.getenv().getOrDefault("BROWSER", DEFAULT_BROWSER)).toLowerCase();
    }
}
