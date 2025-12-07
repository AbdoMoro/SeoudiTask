package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By createAccountLink = By.cssSelector("div.no-account > a");
    private By genderMr = By.xpath("//*[@id=\"field-id_gender-1\"]");
    private By firstNameInput = By.name("firstname");
    private By lastNameInput = By.name("lastname");
    private By emailInput = By.name("email");
    private By passwordInput = By.name("password");
    private By birthdateInput = By.name("birthday");
    private By privacyCheckbox = By.name("customer_privacy");
    private By termsAndCondCheckbox = By.name("psgdpr");
    private By saveBtn = By.cssSelector("button[data-link-action='save-customer']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickCreateAccount() {
        click(createAccountLink);
        return this;
    }

    public HomePage fillRegistration(String fname, String lname, String email, String pass, String date) {
        clickViaJS(genderMr);
        type(firstNameInput, fname);
        type(lastNameInput, lname);
        type(emailInput, email);
        type(passwordInput, pass);
        type(birthdateInput, date);
        clickViaJS(termsAndCondCheckbox);
        clickViaJS(privacyCheckbox);
        click(saveBtn);
        return new HomePage(driver);
    }
}