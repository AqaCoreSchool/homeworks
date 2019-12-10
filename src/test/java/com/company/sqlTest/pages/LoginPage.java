package com.company.sqlTest.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath ="//input[@id='txtUsername']")
    private WebElement userName;
    @FindBy(xpath ="//input[@id='txtPassword']")
    private WebElement userPassword;

    public MainMenuPage loginIntoSystem(String name, String password) {
        userName.sendKeys(name);
        userPassword.sendKeys(password, Keys.ENTER);
        return new MainMenuPage();
    }
}
