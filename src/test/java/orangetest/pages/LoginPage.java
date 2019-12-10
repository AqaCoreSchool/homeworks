package orangetest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(xpath = ("//input[@id='txtUsername']"))
    private WebElement loginField;

    @FindBy(xpath = ("//input[@id='txtPassword']"))
    private WebElement passwordField;

    @FindBy(xpath = ("//input[@id='btnLogin']"))
    private WebElement submitButton;

    @FindBy(id = "welcome")
    private List<WebElement> welcomeField;

    public LoginPage() {
        super();
    }

    @Step("Login into system")
    public AttendancePage loginIntoSystem(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
        return new AttendancePage();
    }

    @Step("Check if user is logged")
    public boolean isHomePageOpened() {
        return welcomeField.size() == 1;
    }
}
