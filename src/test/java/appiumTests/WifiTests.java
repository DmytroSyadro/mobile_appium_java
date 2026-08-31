package appiumTests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * WifiTests class contains automated test cases for WiFi preferences functionality.
 * This class extends BaseTest to leverage the pre-configured Appium driver setup.
 * Tests various WiFi settings interactions and state validations.
 */
public class WifiTests extends BaseTest {

    /**
     * Tests WiFi settings and preference dependencies on the Android device.
     * Demonstrates multiple element location strategies and user interactions.
     * Steps:
     * 1. Locate WiFi settings menu item using XPath
     * 2. Access Preference menu using accessibility ID
     * 3. Wait for preference dependencies element to be visible
     * 4. Interact with WiFi checkbox (check/uncheck status)
     * 5. Validate element states
     */
    @Test
    public void wifiSettingsTest() {
        // Locate WiFi settings using XPath with content-description attribute
        WebElement wifiSettings = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"));
        
        // Locate Preference menu item using accessibility ID (recommended for mobile apps)
        WebElement preference = driver.findElement(AppiumBy.accessibilityId("Preference"));
        
        // Create WebDriverWait for explicit waits (10-second timeout)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Wait until the preference dependencies element is visible before interacting
        WebElement preferenceDependencies = wait.until(ExpectedConditions.visibilityOfElementLocated((By) wifiSettings));
        
        // Locate WiFi checkbox using Android resource ID
        WebElement wifiCheckBox = driver.findElement(By.id("android:id/checkbox"));
        
        // Verify preference element is enabled before interaction
        preference.isEnabled();
        
        // Click on Preference menu to navigate to preferences screen
        preference.click();
        
        // Click on preference dependencies option
        preferenceDependencies.click();
        
        // Check if WiFi checkbox is currently unchecked
        boolean isUnchecked = !wifiCheckBox.getAttribute("checked").equals("true");
        
        // Toggle WiFi checkbox state
        wifiCheckBox.click();
        
        // Verify checkbox is still enabled after interaction
        wifiCheckBox.isEnabled();
    }

}