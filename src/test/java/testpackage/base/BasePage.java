package testpackage.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import testpackage.manager.DriverManager;
import testpackage.page.InventoryPage;
import testpackage.page.MainPage;

public class BasePage {

    public final WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(),'Open Menu')]")
    private WebElement openMenu;

    @FindBy(className = "svg-inline--fa")
    private WebElement inventoryBtn;

    public  BasePage(){
        PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
        wait = new WebDriverWait(DriverManager.getInstance().getDriver(), 10);
    }

    public MainPage moveToMenu(){
        openMenu.click();
        return new MainPage();
    }

    public InventoryPage moveToInventory(){
        inventoryBtn.click();
        return new InventoryPage();
    }
}
