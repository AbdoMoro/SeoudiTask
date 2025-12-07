package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class ProductPage extends BasePage {

    private By productList = By.cssSelector(".product-miniature");
    private By mainImage = By.cssSelector(".product-cover img");
    private By productNameHeader = By.cssSelector("h1.h1");
    private By addToCartBtn = By.cssSelector("button.add-to-cart");
    private By cartModal = By.id("blockcart-modal");
    private By proceedCheckoutBtn = By.xpath("//*[text()='Proceed to checkout']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectFirstProduct() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productList, 0));
        List<WebElement> products = driver.findElements(productList);
        if (!products.isEmpty()) {
            products.get(0).click();
        } else {
            throw new RuntimeException("No products found in search results.");
        }
        return this;
    }

    public boolean isImageDisplayed() {
        WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(mainImage));
        return img.isDisplayed() && img.getAttribute("src") != null;
    }

    public String getProductName() {
        return getText(productNameHeader);
    }

    public CartPage addToCartAndProceed() {
        click(addToCartBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartModal));
        click(proceedCheckoutBtn);
        return new CartPage(driver);
    }
}