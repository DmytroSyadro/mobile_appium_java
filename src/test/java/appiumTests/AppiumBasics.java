package appiumTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics {
    @Test
    public void appiumTest(){
        //AndroidDriver, IOSDriver, WindowsDriver, Mac2Driver
        //Appium code -> Appium Server -> Mobile Device
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("CoolPhone");


        try {
            AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


    }
}
