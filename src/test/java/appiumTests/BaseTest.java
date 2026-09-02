package appiumTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;
    protected AppiumDriverLocalService service;

    public static final int TIMEOUT = 10;


    @BeforeClass
    public void configureAppium() throws MalformedURLException, URISyntaxException {
        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("CoolPhone"); // Android emulator name - update as needed
        options.setApp("D:\\test_mobile\\mobile_appium_java\\src\\test\\java\\resources\\ApiDemos-debug(2).apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
    }

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

    protected void waitUntilClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}