package ua.biz.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ua.biz.test.utils.credentials.UICredHelper;
import ua.biz.test.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"txtUsername\"]")
    private WebElement loginField;
    @FindBy(xpath ="//*[@id=\"txtPassword\"]" )
    private  WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"btnLogin\"]")
    private  WebElement loginButton;

    public LoginPage(WebDriver browserInstance) {
    }

    public MainPage login() {
        UICredHelper helper = UICredHelper.getInstance();
        loginField.sendKeys(helper.getLogin());
        passwordField.sendKeys(helper.getPassword());
        loginButton.click();
        return new MainPage();
    }


}
