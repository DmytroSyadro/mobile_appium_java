package appiumTests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LongPressTest extends AndroidBaseTest {

    @Test
    public void longPressTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement viewsElement = driver.findElement(AppiumBy.accessibilityId("Views"));
        viewsElement.click();

        WebElement expandableListsElement = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']"));
        expandableListsElement.click();
        WebElement customAdapterButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")));
        customAdapterButton.click();
        WebElement peopleAttribute = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='People Names']")));

        longPressAction(peopleAttribute);

        WebElement sampleMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/title")));
        sampleMenu.getText();
        Assert.assertEquals(sampleMenu.getText(), "Sample menu", "Sample Menu text should be 'Sample menu' after long press.");
        Assert.assertTrue(sampleMenu.isDisplayed(), "Sample Menu should be displayed after long press.");
    }
}
