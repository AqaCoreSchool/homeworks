package automation.exam.page;

import automation.exam.data.UserCredential;
import automation.exam.util.Application;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@class='btn_action']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class='inventory_list']")
    private WebElement inventoryList;

    public LoginPage() {
        PageFactory.initElements(Application.getDriver(), this);
    }

    public LoginPage loginIntoSystem() {
        usernameInput.sendKeys(UserCredential.USER_NAME);
        passwordInput.sendKeys(UserCredential.PASSWORD);
        loginButton.click();

        return new LoginPage();
    }

    public boolean verify() {
        return inventoryList.isDisplayed();
    }
}