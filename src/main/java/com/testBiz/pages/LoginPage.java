package com.testBiz.pages;


import com.testBiz.data.UserCreds;
import com.testBiz.util.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriverWait wait;

    @FindBy(id = "txtUsername")
    private WebElement usernameInputField;

    @FindBy(id = "txtPassword")
    private WebElement passwordInputField;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;


    public LoginPage() {
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
        wait = new WebDriverWait(Driver.getInstance().getDriver(), 10);
    }

    public void typeEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(usernameInputField));
        usernameInputField.sendKeys(UserCreds.USER_EMAIL);
    }

    public void typePassword() {
        wait.until(ExpectedConditions.elementToBeClickable(passwordInputField));
        passwordInputField.sendKeys(UserCreds.USER_PASS);
    }

    public void clickLogInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

}