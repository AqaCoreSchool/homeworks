package page;

import common.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCart extends BasePage {

    @FindBy(className = "cart_list")
    private WebElement cartList;

    @FindBy(className = "fa-layers-counter shopping_cart_badge")
    private WebElement cartSize;

    public String getCartSize() {
        Wait.waitForVisible(cartSize);
        return cartSize.getText();
    }
}
