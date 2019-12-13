package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class InventoryPage extends BasePage{
    private final WebDriver driver;
    private WebElement firstItem;

    @FindBy(className = "inventory_item")
    private List<WebElement> itemsList;

    @FindBy(className = "product_sort_container")
    private WebElement filterMenu;



    public InventoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public InventoryPage sortByPriceDesc(){
        Select sort = new Select(filterMenu);
        sort.selectByValue("hilo");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return this;
    }

    public InventoryPage sortByNameDesc(){
        Select sort = new Select(filterMenu);
        sort.selectByValue("za");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return this;
    }

    public String getFirstElementName(){
        return itemsList.get(0).findElement(By.className("inventory_item_name")).getText();
    }

    public String getFirstElementPrice(){
        return itemsList.get(0).findElement(By.className("inventory_item_price")).getText();
    }

    public InventoryPage addItemToCart(int index){
        itemsList.get(index).findElement(By.cssSelector(".btn_primary.btn_inventory")).click();
        return this;
    }
}
