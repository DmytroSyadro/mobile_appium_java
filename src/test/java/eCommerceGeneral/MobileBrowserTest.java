package eCommerceGeneral;

import appiumTests.BaseTest;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BaseTest {
    @Test
    public void browserTest() {
        driver.get("https://www.google.com");

    }
}
