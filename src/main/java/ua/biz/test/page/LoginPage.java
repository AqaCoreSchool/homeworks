package ua.biz.test.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.biz.test.data.LoginCredential;
import ua.biz.test.util.LocalDriver;

public class LoginPage {

    @FindBy(xpath = "//input[@id='txtUsername']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='txtPassword']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='btnLogin']")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(LocalDriver.getDriver(), this);
    }

    public HomePage loginIntoSystem() {
        usernameInput.sendKeys(LoginCredential.USER_NAME);
        passwordInput.sendKeys(LoginCredential.PASSWORD);
        loginButton.click();

        return new HomePage();
    }
}
