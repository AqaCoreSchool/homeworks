package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrangeAdminPage {
    private final WebDriver driver;
    private WebElement user;
    private List<WebElement> userRecord;

    @FindBy(id = "menu_admin_UserManagement")
    private WebElement userManagementMenu;

    @FindBy(id = "menu_admin_viewSystemUsers")
    private WebElement systemUsers;

    @FindBy(xpath = "//table[@id='resultTable']//tr[@class='odd' or @class='even']")
    private List<WebElement> usersList;

    public WebElement getUser() {
        return user;
    }

    public List<WebElement> getUserRecord() {
        return userRecord;
    }

    public OrangeAdminPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrangeAdminPage toUserManagement(){
        userManagementMenu.click();
        return this;
    }

    public OrangeAdminPage toSystemUsers(){
        systemUsers.click();
        return this;
    }

    public OrangeAdminPage findUser(String username){
        user = usersList.stream()
                .filter(o -> o.getText().contains(username))
                .findFirst()
                .orElse(null);
        userRecord = user != null ? user.findElements(By.xpath("./td")) : null;
        return this;
    }
}
