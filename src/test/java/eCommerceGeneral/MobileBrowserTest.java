package eCommerceGeneral;

import appiumTests.AndroidBaseTest;
import org.testng.annotations.Test;

public class MobileBrowserTest extends AndroidBaseTest {
    @Test
    public void browserTest() {
        driver.get("https://www.google.com");

    }
}
