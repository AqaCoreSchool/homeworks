package ua.biz.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.biz.test.CredentialsHelper;

public class LoginPage {

    @FindBy(xpath = "//*[@id=\"txtUsername\"]")
    private WebElement loginField;
    @FindBy(xpath ="//*[@id=\"txtPassword\"]" )
    private  WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"btnLogin\"]")
    private  WebElement loginButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public MainPage login(WebDriver driver) {
        CredentialsHelper helper = CredentialsHelper.getInstance();
        loginField.sendKeys(helper.getLogin());
        passwordField.sendKeys(helper.getPassword());
        loginButton.click();
        return new MainPage(driver);
    }


}
