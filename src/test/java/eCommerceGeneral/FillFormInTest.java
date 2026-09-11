package eCommerceGeneral;

import appiumFrameworkDesign.pages.FormPage;
import appiumTests.BaseTest;
import org.testng.annotations.Test;

public class FillFormInTest extends BaseTest {

    private static final String NAME = "John Doe";
    private static final String GENDER = "Female";
    private static final String COUNTRY = "Argentina";
    private static int TIMEOUT = 10;
    @Test
    public void fillFormTest(){
        FormPage formPage = new FormPage(driver);
        formPage.enterName(NAME)
                .selectGender(GENDER)
                .selectCountry(COUNTRY)
                .submitForm();
        sleep(2000);
    }
}
