package appiumTests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WifiTests extends BaseTest {

    @Test
    public void wifiSettingsTest() {
        //tag name, class name, id, accessibility id, xpath, css selector
        WebElement wifiSettings = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"));
        WebElement preference = driver.findElement(AppiumBy.accessibilityId("Preference"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement preferenceDependencies = wait.until(ExpectedConditions.visibilityOfElementLocated((By) wifiSettings));
        WebElement wifiCheckBox = driver.findElement(By.id("android:id/checkbox"));
        preference.isEnabled();
        preference.click();
        preferenceDependencies.click();
        boolean isUnchecked = !wifiCheckBox.getAttribute("checked").equals("true");
        wifiCheckBox.click();
        wifiCheckBox.isEnabled();


    }

}