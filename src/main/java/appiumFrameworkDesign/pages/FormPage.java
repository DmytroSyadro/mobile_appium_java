package appiumFrameworkDesign.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FormPage extends BasePage{

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement countyDropdown;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement letsShopButton;


    public FormPage(AndroidDriver driver) {
        super(driver);
    }

    public FormPage enterName(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
        return this;
    }

    public FormPage selectGender(String gender) {
        String xpath = String.format("//android.widget.RadioButton[@text='%s']", gender);
        WebElement genderRadioButton = driver.findElement(By.xpath(xpath));
        waitAndClick(genderRadioButton);
        return this;
    }

    public FormPage selectCountry(String country){
        waitAndClick(countyDropdown);
        String xpath = String.format("//android.widget.TextView[@text='%s']", country);
        WebElement countryOption = driver.findElement(By.xpath(xpath));
        scrollToElement(country);
        waitAndClick(countryOption);
        return this;
    }

    public MenuPage submitForm() {
        waitAndClick(letsShopButton);
        return new MenuPage(driver);
    }
}
