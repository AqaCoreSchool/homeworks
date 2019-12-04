package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "txtUsername")
    private WebElement usernameField;

    @FindBy(id = "txtPassword")
    private WebElement passwordField;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    public LoginPage fillUsername(String name) {
        getWait().until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameField.sendKeys(name);
        return this;
    }

    public LoginPage fillPassword(String password) {
        getWait().until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton() {
        getWait().until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        return new HomePage();
    }
}
