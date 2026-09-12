package appiumTests;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class ScrollingTest extends AndroidBaseTest {
    private static final int SCROLL_TIMEOUT = 2000;

    @Test
    public void scrollTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        scrollToTheEnd();

    }
}
