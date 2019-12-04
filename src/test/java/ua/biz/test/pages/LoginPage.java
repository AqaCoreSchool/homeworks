package ua.biz.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import ua.biz.test.utils.CredentialsHelper;
import ua.biz.test.base.BasePage;
import ua.biz.test.utils.WaitUtil;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"txtUsername\"]")
    private WebElement loginField;
    @FindBy(xpath ="//*[@id=\"txtPassword\"]" )
    private  WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"btnLogin\"]")
    private  WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super();
    }

    public MainPage login() {
        CredentialsHelper helper = CredentialsHelper.getInstance();
        loginField.sendKeys(helper.getLogin());
        passwordField.sendKeys(helper.getPassword());
        loginButton.click();
        return new MainPage();
    }


}
