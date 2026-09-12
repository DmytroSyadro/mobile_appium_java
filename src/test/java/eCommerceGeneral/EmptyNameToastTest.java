package eCommerceGeneral;

import appiumTests.AndroidBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EmptyNameToastTest extends AndroidBaseTest {

    @Test
    public void emptyNameToastTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        WebElement femaleRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.androidsample.generalstore:id/radioFemale")));
        femaleRadioButton.click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        sleep(2000);
        String toastText = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(toastText, "Please enter your name", "Toast message should be 'Please enter your name' when name field is empty.");
    }

}
