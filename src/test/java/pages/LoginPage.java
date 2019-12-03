package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage{

    private WebDriver driver;
    private static final String USERNAME = "TestUser02";
    private static final String PASSWORD = "Vfylhfujhf!1";


    @FindBy(id = "txtUsername")
    private WebElement usernameField;

    @FindBy(id = "txtPassword")
    private WebElement passwordField;

    @FindBy(id = "btnLogin")
    private WebElement submitBtn;

    @FindBy(id = "welcome")
    private WebElement welcomeElement;


    public HomePage loginIntoSite(String login, String password){
        usernameField.sendKeys(login);
        passwordField.sendKeys(password);
        submitBtn.click();
        return  new HomePage();
    }
}
