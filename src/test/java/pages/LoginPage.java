package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    private final WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameFld;

    @FindBy(id = "password")
    private WebElement passwordFld;

    @FindBy(className = "btn_action")
    private WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoginPage enterUsername(String username){
        usernameFld.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        passwordFld.sendKeys(password);
        return this;
    }

    public InventoryPage clickLoginBtn(){
        loginBtn.click();
        return new InventoryPage(driver);
    }

    public InventoryPage loginCorrect(String username, String password){
        return enterUsername(username).enterPassword(password).clickLoginBtn();
    }
}
