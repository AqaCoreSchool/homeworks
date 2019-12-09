package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{

    @FindBy(id = "txtUsername")
    private WebElement usernameField;

    @FindBy(id = "txtPassword")
    private WebElement passwordField;

    @FindBy(id = "btnLogin")
    private WebElement submitBtn;

    @FindBy(id = "welcome")
    private WebElement welcomeElement;

    @Step
    public MainPage loginIntoSite(String login, String password){
        usernameField.sendKeys(login);
        passwordField.sendKeys(password);
        submitBtn.click();
        return  new MainPage();
    }
}
