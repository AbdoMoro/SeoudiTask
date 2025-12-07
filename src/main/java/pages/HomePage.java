package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // Locators
    private By signInBtn = By.cssSelector("div.user-info a");
    private By searchBox = By.cssSelector("input[name='s']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToSignIn() {
        click(signInBtn);
        return new LoginPage(driver);
    }

    public ProductPage searchForProduct(String productName) {
        type(searchBox, productName);
        driver.findElement(searchBox).submit();
        return new ProductPage(driver);
    }
}