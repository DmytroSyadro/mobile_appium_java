package eCommerceGeneral;

import appiumTests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FillFormInTest extends BaseTest {

    private static int TIMEOUT = 10;
    @Test
    public void fillFormTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        WebElement elementField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.androidsample.generalstore:id/nameField")));
        elementField.sendKeys("Test User");
        driver.hideKeyboard();
        WebElement femaleRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.androidsample.generalstore:id/radioFemale")));
        femaleRadioButton.click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        scrollToElement("Argentina");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        sleep(2000);

    }
}
