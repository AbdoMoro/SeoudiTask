package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    // Locators
    private By cartItemName = By.cssSelector(".product-line-info a.label");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartItemName() {
        return getText(cartItemName);
    }
}