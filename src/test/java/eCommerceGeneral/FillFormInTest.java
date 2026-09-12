package eCommerceGeneral;

import appiumFrameworkDesign.pages.CartPage;
import appiumFrameworkDesign.pages.FormPage;
import appiumTests.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FillFormInTest extends AndroidBaseTest {

    private static final String NAME = "John Doe";
    private static final String GENDER = "Female";
    private static final String COUNTRY = "Argentina";
    private static int TIMEOUT = 10;
    @Test
    public void fillFormTest(){
        CartPage cartPage = new CartPage(driver);
        FormPage formPage = new FormPage(driver);
        formPage.enterName(NAME)
                .selectGender(GENDER)
                .selectCountry(COUNTRY)
                .submitForm()
                .addItemToCartByIndex(1)
                .addItemToCartByIndex(0)
                .goToCart();
        double productSum = cartPage.getProductSum();
        double totalAmount = cartPage.getTotalAmountDisplayed();
        Assert.assertEquals(productSum, totalAmount, "The total amount does not match");
        cartPage.acceptTerms()
                .submitOrder();
        sleep(2000);
    }
}
