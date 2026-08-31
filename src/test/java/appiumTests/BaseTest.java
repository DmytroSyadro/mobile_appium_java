package appiumTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * BaseTest class provides common Appium setup and teardown for all test classes.
 * This class initializes the Appium local service, configures Android device options,
 * and ensures proper cleanup after test execution.
 */
public class BaseTest {
    protected AndroidDriver driver;
    protected AppiumDriverLocalService service;

    /**
     * Configures and starts the Appium service before each test class execution.
     * Sets up the AndroidDriver with specified device capabilities and APK configuration.
     *
     * @throws MalformedURLException if the Appium server URL is invalid
     * @throws URISyntaxException if the URI syntax is incorrect
     */
    @BeforeClass
    public void configureAppium() throws MalformedURLException, URISyntaxException {
        // Initialize the Appium local service builder with JavaScript main file path
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        // Start the Appium server
        service.start();

        // Configure Android device options using UiAutomator2 driver
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("CoolPhone"); // Android emulator name - update as needed
        options.setApp("D:\\test_mobile\\mobile_appium_java\\src\\test\\java\\resources\\ApiDemos-debug(2).apk");

        // Initialize the AndroidDriver with configured options
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
    }

    /**
     * Cleans up resources after test execution.
     * Closes the AndroidDriver session and stops the Appium service.
     */
    @AfterClass
    public void tearDown() {
        // Quit the driver session to close app and release device
        if (driver != null) {
            driver.quit();
        }
        // Stop the Appium service
        if (service != null) {
            service.stop();
        }
    }
}