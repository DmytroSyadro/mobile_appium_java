package appiumFrameworkDesign.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCartButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartButton;

    public MenuPage(AndroidDriver driver) {
        super(driver);
    }

    public MenuPage addItemToCartByIndex(int index) {
        if(index >= 0 && index < addToCartButton.size()) {
            waitAndClick(addToCartButton.get(index));
        }
        return this;
    }

    public CartPage goToCart() {
        waitAndClick(cartButton);
        sleep(2000);
        return new CartPage(driver);
    }
}
