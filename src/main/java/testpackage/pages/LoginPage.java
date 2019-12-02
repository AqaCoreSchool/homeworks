package testpackage.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testpackage.base.BasePage;
import testpackage.manager.DriverManager;

public class LoginPage extends BasePage {

    private static   WebDriver driver = DriverManager.getInstance().getDriver() ;

    @FindBy(id = "txtUsername")
    private WebElement userNameInput;

    @FindBy(id = "txtPassword")
    private WebElement passwordInput;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    public MainPage loginToTheSystem(String name,String password) {
        userNameInput.sendKeys(name);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new MainPage();
    }


}