package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Application;

public class LoginPage extends BasePage {

    @FindBy(id="user-name")
    private WebElement loginField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@class='btn_action']")
    private WebElement submitButton;

    public LoginPage() {
        super();
    }

    @Step("Login into system")
    public HomePage loginIntoSystem(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
        return new HomePage();
    }

    @Step("Check if user is logged")
    public boolean checkLogin(){
        return Application.getDriver().findElements(By.xpath("//div[@class='product_label']")).size() > 0;
    }
}
