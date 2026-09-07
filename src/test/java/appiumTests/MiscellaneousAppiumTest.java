package appiumTests;

import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

public class MiscellaneousAppiumTest extends BaseTest  {
    @Test
    public void miscellaneousTest() {
        DeviceRotation landscape = new DeviceRotation(0, 0, 90);
        driver.rotate(landscape);
    }

}
