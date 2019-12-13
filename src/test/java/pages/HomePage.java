package pages;

import com.google.gson.internal.$Gson$Preconditions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage {

/*    @FindBy(xpath = "//div[@class='inventory_list']//div[1]//div[2]")
    private WebElement inventoryList;*/

    @FindBy(id = "inventory_container")
    private List<WebElement> addButtons;

    @FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
    private WebElement openShoppingCart;

    @FindBy(xpath = "//div[@class='inventory_list']//div[1]//div[3]//button[1]")
    private WebElement firstItem;

    @FindBy(xpath = "//body[@class='main-body']//div[@id='inventory_container']//div[@id='inventory_container']//div[2]//div[3]//button[1]")
    private WebElement secondItem;

    @FindBy(xpath = "//div[@class='inventory_list']")
    private WebElement inventoryList;

    Wait wait = new Wait();

    @Step("add 2 items to shopping cart")
    public HomePage addItemsToCart() {
        firstItem.click();
        secondItem.click();
        return this;
    }

    @Step("open shopping cart")
    public ShoppingCartPage openShoppingCart() {
        wait.waitUntilIsClickable(openShoppingCart);
        openShoppingCart.click();
        return new ShoppingCartPage();
    }

    public void sorting(){
        List<WebElement> allItems = inventoryList.findElements(By.className("inventory_item_name"));
        allItems.stream().sorted().collect(Collectors.toList());
    }

}
