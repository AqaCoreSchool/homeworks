package testpackage.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testpackage.base.BasePage;

public class MainPage extends BasePage {


        @FindBy(id = "logout_sidebar_link")
        private WebElement logoutBtn;

        @FindBy(id = "about_sidebar_link")
        private WebElement aboutBtn;

        @FindBy(id = "inventory_sidebar_link")
        private WebElement allItemBtn;

        @FindBy(id = "reset_sidebar_link")
        private WebElement resetAppStateBtn;

    public boolean verifyLogoutInDisplay(){
        return  logoutBtn.isDisplayed();
    }

    public AllItemPage moveToAllItem(){
        allItemBtn.click();
        return new AllItemPage();
    }

}
