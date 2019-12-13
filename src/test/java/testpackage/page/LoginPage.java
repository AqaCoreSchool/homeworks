package testpackage.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testpackage.base.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "btn_action")
    private WebElement loginButton;

    @Step
    public MainPage loginToTheSystem(String name,String password) {
        userNameInput.sendKeys(name);//standard_user
        passwordInput.sendKeys(password);//secret_sauce
        loginButton.click();
        return new MainPage();
    }
}
