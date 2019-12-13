package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Wait;

import java.util.List;

public class ShoppingCartPage {
    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    private WebElement checkout;

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    Wait wait = new Wait();

    public boolean isTwoItems(){
        System.out.println(cartItems.size());
        return cartItems.size()==2;
    }

}
