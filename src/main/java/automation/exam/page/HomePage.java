package automation.exam.page;

import automation.exam.util.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    @FindBy(xpath = "//div[@class='inventory_list']//div[1]//div[3]//button[1]")
    private WebElement product1;

    @FindBy(xpath = "//body[@class='main-body']//div[@id='inventory_container']//div[@id='inventory_container']//div[2]//div[3]//button[1]")
    private WebElement product2;

    @FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
    private WebElement shoppingCartItem;

    @FindBy(xpath = "//div[@class='inventory_list']")
    private WebElement inventoryList;

    public HomePage() {
        PageFactory.initElements(Application.getDriver(), this);
    }

    public HomePage addProduct() {
        product1.click();
        product2.click();
        return this;
    }

    public CartPage switchToShoppingCart() {
        shoppingCartItem.click();
        return new CartPage();
    }

    public HomePage sortList() {
        List<WebElement> inventoryPriceList = inventoryList.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_price']"));
        List<WebElement> inventoryNameList = inventoryList.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item_name']"));
        List<String> inventoryName = inventoryNameList
                .stream()
                .map(WebElement::getText).collect(Collectors.toList());
        List<String> inventoryPrice = inventoryPriceList
                .stream()
                .map(WebElement::getText).collect(Collectors.toList());

        inventoryName.sort(Collections.reverseOrder());
        inventoryPrice.sort(Collections.reverseOrder());

        System.out.println(inventoryName);
        System.out.println(inventoryPrice);

        return this;
    }
}
