package ua.testbiz.page;

import data.UserCredential;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@id='txtUsername']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='txtPassword']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='btnLogin']")
    private WebElement loginButton;

    private WebDriver webDriver;

    public LoginPage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage loginIntoSystem() {
        usernameInput.sendKeys(UserCredential.USER_NAME);
        passwordInput.sendKeys(UserCredential.PASSWORD);
        loginButton.click();

        return new HomePage(webDriver);
    }
}
