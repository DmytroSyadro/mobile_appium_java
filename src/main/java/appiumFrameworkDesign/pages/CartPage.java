package appiumFrameworkDesign.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.List;

public class CartPage extends BasePage {
    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    private List<WebElement> productPrices;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmountLabel;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
    private WebElement termsButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    private WebElement proceedButton;

    @AndroidFindBy(className = "android.widget.Checkbox")
    private WebElement checkBox;

    //driver.findElement(By.id("android:id/button1")).click();

    @AndroidFindBy(id = "android:id/button1")
    private WebElement closeButton;

    public CartPage(AndroidDriver driver) {
        super(driver);
    }

    public List<WebElement> getProductPrices() {
        return productPrices;
    }

    public double getProductSum(){
        int size = productPrices.size();
        double totalSum = 0.00;
        for(int iii = 0; iii < size; iii++) {
            String amount = productPrices.get(iii).getText();
            double price = getFormattedDouble(amount);
            totalSum += price;
        }
        return totalSum;
    }

    private Double getFormattedDouble(String number){
        return Double.parseDouble(number.substring(1));
    }
    public CartPage acceptTerms(){
        longPressAction(termsButton);
        waitAndClick(closeButton);
        return this;
    }
    public GoogleMenuPage submitOrder() {
        waitAndClick(proceedButton);
        return new GoogleMenuPage(driver);
    }

    public double getTotalAmountDisplayed(){
        return getFormattedDouble(totalAmountLabel.getText());
    }

}
