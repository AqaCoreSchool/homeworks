package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@class='btn_action']")
    private WebElement submitBtn;

    @Step
    public MainPage loginIntoSite(String login, String password){
        usernameField.sendKeys(login);
        passwordField.sendKeys(password);
        submitBtn.click();
        return  new MainPage();
    }
}
