package orangetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class LoginPage {
    protected WebDriver driver;

    @FindBy(xpath = ("//input[@id='txtUsername']"))
    private WebElement loginField;

    @FindBy(xpath = ("//input[@id='txtPassword']"))
    private WebElement passwordField;

    @FindBy(xpath = ("//input[@id='btnLogin']"))
    private WebElement submitButton;

    @FindBy(id = "welcome")
    private List<WebElement> welcomeField;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public HomePage loginIntoSystem(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
        return new HomePage(driver);
    }

    public boolean isHomePageOpened() {
        return welcomeField.size() == 1;
    }
}
