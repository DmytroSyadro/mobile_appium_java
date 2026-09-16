package eCommerceGeneral;

import appiumFrameworkDesign.pages.CartPage;
import appiumFrameworkDesign.pages.FormPage;
import appiumFrameworkDesign.pages.MenuPage;
import appiumTests.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FillFormInTest extends AndroidBaseTest {

    private static final String NAME = "John Doe";
    private static final String GENDER = "Female";
    private static final String COUNTRY = "Argentina";
    private static int TIMEOUT = 10;

    @BeforeMethod
    public void beforeMethod(){
        FormPage formPage = new FormPage(driver);
        CartPage cartPage = new CartPage(driver);
        formPage.enterName(NAME)
                .selectGender(GENDER)
                .selectCountry(COUNTRY)
                .submitForm();
    }
    @Test(dataProvider = "getData")
    public void fillFormTest(int first, int second){
        MenuPage menuPage = new MenuPage(driver);
        CartPage cartPage = new CartPage(driver);
        menuPage.addItemToCartByIndex(first)
                .addItemToCartByIndex(second)
                .goToCart();
        double productSum = cartPage.getProductSum();
        double totalAmount = cartPage.getTotalAmountDisplayed();
        Assert.assertEquals(productSum, totalAmount, "The total amount does not match");
        cartPage.acceptTerms()
                .submitOrder();
        sleep(2000);
    }
    @DataProvider
    public Object [][] getData() {
        return new Object[][] {
                {1, 0}, {2,4} //second time
        };
    }
}
