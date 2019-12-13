package com.company.vTests.pages;

import com.company.vTests.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath ="//input[@id='user-name']")
    private WebElement userName;
    @FindBy(xpath ="//input[@id='password']")
    private WebElement userPassword;
    @FindBy(xpath ="//div[@class='app_logo']")
    private WebElement logo;


    @Step("Login Into System")
    public MainMenuPage loginIntoSystem(String name, String password) {
        userName.sendKeys(name);
        userPassword.sendKeys(password, Keys.ENTER);
        return new MainMenuPage();
    }

    public boolean isLogoDisplayed(){
        return logo.isDisplayed();
    }

}
