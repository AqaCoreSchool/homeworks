package ua.biz.test.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.biz.test.entity.Product;
import ua.biz.test.utils.WaitUtil;
import ua.biz.test.base.BasePage;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[contains(text(),'Open Menu')]")
    private WebElement menuButton;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectField;

    @FindBy(xpath = "//div[@class='inventory_list']")
    private List<WebElement> goodsList;

    @FindBy(xpath = "//div[@class='product_label']")
    private WebElement pageTitle;

    @FindBy(xpath = "//*[contains(@class,'svg-inline--fa fa-shopping-cart fa-w-18 fa-3x')]")
    private WebElement cartButton;


    public boolean isOpened() {
        return pageTitle.isDisplayed();
    }

    public Product getProduct(){
        Product product = new Product();
        WebElement element =goodsList.get(0);

        product.setName(element.findElement(By.className("inventory_item_name")).getText());
        product.setPrice(element.findElement(By.className("inventory_item_price")).getText());
        product.setElement(element);
        return  product;
    }

    public MainPage addProductToCart(Product product) {
        WebElement element = product.getElement();
        WaitUtil.waitAndClick(element.findElement(By.className("btn_primary")));
        return this;
    }

    public CartPage openCartPage() {
        WaitUtil.waitAndClick(cartButton);
        return new CartPage();
    }
}
