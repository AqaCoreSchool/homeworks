package com.company.verifytests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    @FindBy(xpath ="//input[@id='txtUsername']")
    private WebElement userName;
    @FindBy(xpath ="//input[@id='txtPassword']")
    private WebElement userPassword;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public MainMenuPage loginIntoSystem(String name, String password) {
        userName.sendKeys(name);
        userPassword.sendKeys(password, Keys.ENTER);
        return new MainMenuPage(driver);
    }
}
