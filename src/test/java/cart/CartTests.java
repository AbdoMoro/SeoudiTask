package cart;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import java.util.UUID;

public class CartTests extends BaseTest {

    @Test
    public void testUserCanCreateAccountAndPurchaseNotebook() {

        HomePage homePage = new HomePage(driver);
        homePage = homePage.goToSignIn()
                .clickCreateAccount()
                .fillRegistration("Abdo", "Moro", "test_" + UUID.randomUUID() + "@test.com", "Paks*uu!#942$L", "04/10/2000");
        ProductPage productPage = homePage.searchForProduct("notebook");
        productPage.selectFirstProduct();
        Assert.assertTrue(productPage.isImageDisplayed(), "Image missing!");
        String expectedName = productPage.getProductName();
        CartPage cartPage = productPage.addToCartAndProceed();
        Assert.assertEquals(cartPage.getCartItemName().toLowerCase(), expectedName.toLowerCase());
    }
}