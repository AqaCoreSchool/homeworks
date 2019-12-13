package testpackage.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testpackage.base.BasePage;

public class AllItemPage extends BasePage {
    @FindBy(xpath = "//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")
    private WebElement tShirtPage;

    @FindBy(className = "btn_primary")
    private WebElement addBtn;

    @FindBy(xpath = "//div[contains(text(),'Sauce Labs Fleece Jacket')]")
    private WebElement jacketPage;

    public AllItemPage addTShirtInInventory(){
        tShirtPage.click();
        addBtn.click();
        return this;
    }

    public AllItemPage addJacketInInventory(){
        jacketPage.click();
        addBtn.click();
        return this;
    }
}
