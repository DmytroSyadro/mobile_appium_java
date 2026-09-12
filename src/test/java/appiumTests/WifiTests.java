package appiumTests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
public class WifiTests extends AndroidBaseTest {


    @Test
    public void wifiSettingsTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement preference = wait.until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Preference")));
        preference.click();

        WebElement preferenceDependencies = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")));
        preferenceDependencies.click();

        WebElement wifiCheckBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("android:id/checkbox")));

        Assert.assertFalse(wifiCheckBox.isSelected(), "WiFi checkbox should be initially unchecked.");

        wifiCheckBox.click();
        Assert.assertTrue(wifiCheckBox.isSelected(), "WiFi checkbox should be checked after clicking.");
    }
    @Test
    public void wifiSetup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement preference = wait.until(
                ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Preference")));
        preference.click();

        WebElement preferenceDependencies = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")));
        preferenceDependencies.click();

        WebElement wifiCheckBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("android:id/checkbox")));

        wifiCheckBox.click();

        WebElement wifiField = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout")));
        wifiField.click();


        WebElement wifiNameField = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("android:id/edit")));

        wifiNameField.sendKeys("MyWiFiNetwork");

        WebElement okButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
        okButton.click();

    }





}