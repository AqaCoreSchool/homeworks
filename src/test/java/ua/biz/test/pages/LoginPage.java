package ua.biz.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ua.biz.test.utils.credentials.UICredHelper;
import ua.biz.test.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement loginField;
    @FindBy(xpath ="//input[@id='password']" )
    private  WebElement passwordField;
    @FindBy(xpath = "//input[@class='btn_action']")
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
