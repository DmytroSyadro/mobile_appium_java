package eCommerceGeneral;

import appiumTests.BaseTest;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class JordanDisplayTest extends BaseTest {


    private static int TIMEOUT = 10;

    @Test
    public void jordanDisplayTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        WebElement elementField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.androidsample.generalstore:id/nameField")));
        elementField.sendKeys("Test User");
        driver.hideKeyboard();
        WebElement femaleRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.androidsample.generalstore:id/radioFemale")));
        femaleRadioButton.click();
        scrollToElement("Argentina");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        scrollToElement("Jordan 6 Rings");
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for (int iii = 0; iii < productCount; iii++) {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(iii).getText();
            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(iii).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        int productCount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for(int iii = 0; iii < productCount2; iii++){
            String productName2 = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(iii).getText();
            if(productName2.equalsIgnoreCase("Jordan 6 Rings")){
                Assert.assertEquals(productName2, "Jordan 6 Rings", "Product name in cart should be 'Jordan 6 Rings'.");
                break;
            } else {
               throw new RuntimeException("Product 'Jordan 6 Rings' not found in the cart. Actual product name: " + productName2);
            }
        }
        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(ele);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        sleep(2000);
    }
    @Test(priority = 1)
    public void priceValidationTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        WebElement elementField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.androidsample.generalstore:id/nameField")));
        elementField.sendKeys("Test User");
        driver.hideKeyboard();
        WebElement femaleRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.androidsample.generalstore:id/radioFemale")));
        femaleRadioButton.click();
        scrollToElement("Argentina");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        scrollToElement("Jordan 6 Rings");
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int iii = 0; iii < productCount; iii++) {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(iii).getText();
            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(iii).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));
        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrices.size();
        double totalSum = 0;
        for(int iii = 0; iii < count; iii++) {
            String amountString = productPrices.get(iii).getText();
            double price = Double.parseDouble(amountString.substring(1));
            totalSum += price;
        }

    }

}
