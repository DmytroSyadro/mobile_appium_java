package appiumFrameworkDesign.pages;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected AndroidDriver driver;
    public static final int TIMEOUT = 10;
    protected BasePage(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
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
    protected void waitAndClick(WebElement element) {
        waitUntilClickable(driver, element);
        element.click();
    }
}
