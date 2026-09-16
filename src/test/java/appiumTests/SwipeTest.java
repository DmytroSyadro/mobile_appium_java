package appiumTests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeTest extends AndroidBaseTest {

    @Test
    public void swipeTest() {
        String direction = "left";
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Photos\"]")).click();
        WebElement firstImage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
        String firstImageFocusable = firstImage.getAttribute("focusable");
        Assert.assertEquals(firstImageFocusable, "true");
//
        swipeAction(
                firstImage,
                direction
        );

        String firstImageFocusableAfterSwipe = firstImage.getAttribute("focusable");
        Assert.assertEquals(firstImageFocusableAfterSwipe, "false");

    }
}
