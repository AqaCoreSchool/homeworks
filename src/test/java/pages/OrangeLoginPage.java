package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeLoginPage {
    private final WebDriver driver;

    @FindBy(id = "txtUsername")
    private WebElement usernameFld;

    @FindBy(id = "txtPassword")
    private WebElement passwordFld;

    @FindBy(id = "btnLogin")
    private WebElement loginBtn;

    public OrangeLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrangeLoginPage enterUsername(String username){
        usernameFld.sendKeys(username);
        return this;
    }

    public OrangeLoginPage enterPassword(String password){
        passwordFld.sendKeys(password);
        return this;
    }

    public OrangeDashboardPage clickLoginBtn(){
        loginBtn.click();
        return new OrangeDashboardPage(driver);
    }

    public OrangeDashboardPage loginCorrect(String username, String password){
        return enterUsername(username).enterPassword(password).clickLoginBtn();
    }
}
