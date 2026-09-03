package appiumTests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LongPress extends BaseTest {

    @Test
    public void longPressTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewsElement = driver.findElement(AppiumBy.accessibilityId("Views"));
        viewsElement.click();

        WebElement expandableListsElement = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']"));
        expandableListsElement.click();
        WebElement peopleAttribute = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='People Names']")));
        driver.executeScript("mobile: longTimeGesture",
                ImmutableMap.of("elementId",
                        ((RemoteWebElement) peopleAttribute).getId(),
                        "duration", 2000));

    }

}
