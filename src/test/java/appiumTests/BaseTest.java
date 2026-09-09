package appiumTests;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
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
        options.setDeviceName("Pixel 8 Pro"); // Android emulator name - update as needed
        // options.setApp("D:\\test_mobile\\mobile_appium_java\\src\\test\\java\\resources\\ApiDemos-debug(2).apk");
        options.setApp("D:\\test_mobile\\mobile_appium_java\\src\\test\\java\\resources\\General-Store.apk");
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
    protected void longPressAction(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",
                        ((RemoteWebElement) element).getId(),
                        "duration", 2000));
    }
    protected void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    protected void scrollToElement(String elementText) {
        waitE().until(ExpectedConditions.presenceOfElementLocated(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))" +
                                ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"));"
                ))
        );
    }
    protected void scrollToTheEnd() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 400,
                    "direction", "down",
                    "percent", 0.75
            ));
        } while (canScrollMore);
    }
    protected void swipeAction(WebElement element,String direction){ {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direction,
                "percent", 0.75
        ));

        }
    }

    private WebDriverWait waitE(){
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

}