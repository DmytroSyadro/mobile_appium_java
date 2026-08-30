package appiumTests;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;


public class AppiumBasics {
    @Test
    public void appiumTest() throws URISyntaxException, MalformedURLException {
        //AndroidDriver, IOSDriver, WindowsDriver, Mac2Driver
        //Appium code -> Appium Server -> Mobile Device
        AppiumDriverLocalService service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\User\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("CoolPhone"); //emulator name
        options.setApp("D:\\test_mobile\\mobile_appium_java\\src\\test\\java\\resources\\ApiDemos-debug(2).apk");

        AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        WebElement preference = driver.findElement(AppiumBy.accessibilityId("Preference"));

        preference.isEnabled();
        preference.click();


        //stop server
       if(driver != null || !driver.toString().contains("null") || !driver.toString().contains("NoSuchDriver")) {
           driver.quit();
           service.stop();
       }
    }
}
