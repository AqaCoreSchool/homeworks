package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.common.Wait;

public class LoginPage extends BasePage {

    @FindBy(id = "txtUsername")
    private WebElement usernameField;

    @FindBy(id = "txtPassword")
    private WebElement passwordField;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    public LoginPage fillUsername(String name) {
        Wait.waitForElementToBeClickable(usernameField);
        usernameField.sendKeys(name);
        return this;
    }

    public LoginPage fillPassword(String password) {
        Wait.waitForElementToBeClickable(passwordField);
        passwordField.sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton() {
        Wait.waitForElementToBeClickable(loginButton);
        loginButton.click();

        return new HomePage();
    }
}
