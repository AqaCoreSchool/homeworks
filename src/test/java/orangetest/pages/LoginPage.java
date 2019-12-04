package orangetest.pages;

import io.qameta.allure.Step;
import orangetest.utils.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = ("//input[@id='txtUsername']"))
    private WebElement loginField;

    @FindBy(xpath = ("//input[@id='txtPassword']"))
    private WebElement passwordField;

    @FindBy(xpath = ("//input[@id='btnLogin']"))
    private WebElement submitButton;

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
    public boolean checkLogin(){
        return Application.getDriver().findElements(By.xpath("//a[@id='welcome']")).size() > 0;
    }
}
