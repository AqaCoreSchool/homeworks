package page;

import common.Common;
import common.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement userLoginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "btn_action")
    private WebElement loginButton;

    public LoginPage fillUserName() {
        Wait.waitForVisible(userLoginField);
        userLoginField.sendKeys(Common.getProperty("userName"));
        return this;
    }

    public LoginPage fillUserPassword() {
        Wait.waitForVisible(passwordField);
        passwordField.sendKeys(Common.getProperty("userPassword"));
        return this;
    }

    public HomePage clickLoginButton() {
        Wait.waitForElementToBeClickable(loginButton);
        loginButton.click();
        return new HomePage();
    }
}
