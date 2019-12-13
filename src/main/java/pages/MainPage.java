package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.Utils;

import java.util.List;

public class MainPage extends BasePage{

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement logoElement;

    @FindBy(xpath = "//div[contains(text(),'Sauce Labs Backpack')]")
    private WebElement backPack;

    @FindBy(xpath = "//div[contains(text(),'Sauce Labs Fleece Jacket')]")
    private WebElement jacket;

    @FindBy(xpath = "//button[@class='btn_primary btn_inventory']")
    private WebElement btnAddToCart;

    @FindBy(xpath = "//button[@class='inventory_details_back_button']")
    private WebElement btnBack;

    @FindBy(xpath = "//*[contains(@class,'svg-inline--fa fa-shopping-cart fa-w-18 fa-3x')]")
    private WebElement btnCart;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectSorting;

    @FindBy(xpath = "//div[@class='inventory_list']")
    private List<WebElement> elements;

    public List<WebElement> getElements() {
        return elements;
    }

    public WebElement getLogoElement() {
        return logoElement;
    }

    public WebElement getBackPack() {
        return backPack;
    }

    public WebElement getJacket() {
        return jacket;
    }

    public MainPage addProductToCart(WebElement element){
        Utils.waitAndClick(element);
        Utils.waitAndClick(btnAddToCart);
        Utils.waitAndClick(btnBack);
        return this;
    }

    public CartPage moveToCartPage(){
        Utils.waitAndClick(btnCart);
        return new CartPage();
    }

    public MainPage selectSorting(String sorting){
        Select select = new Select(selectSorting);
        select.selectByVisibleText(sorting);
        return this;
    }


}
