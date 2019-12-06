package ua.testbiz.page;

import data.UserCredential;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Application;

public class LoginPage {

    @FindBy(xpath = "//input[@id='txtUsername']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='txtPassword']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='btnLogin']")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(Application.getDriver(), this);
    }

    public void loginIntoSystem() {
        usernameInput.sendKeys(UserCredential.USER_NAME);
        passwordInput.sendKeys(UserCredential.PASSWORD);
        loginButton.click();
    }
}
