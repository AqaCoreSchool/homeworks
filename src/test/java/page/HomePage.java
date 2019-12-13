package page;

import common.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(className = "app_logo")
    private WebElement appLogo;

    @FindBy(className = "inventory_container")
    private WebElement container;

    @FindBy(className = "inventory_item")
    private List<WebElement> elements;

    @FindBy(className = "shopping_cart_container")
    private WebElement cart;

    public boolean isAppLogoVisible() {
        Wait.waitForVisible(appLogo);
        return appLogo.isDisplayed();
    }

    public void selectButton(String name) {
         WebElement button = elements.stream()
                .filter(element -> element.getText().contains(name))
                .findFirst().get();
         button.findElement(By.xpath("//button[contains(@class, 'btn_primary btn_inventory')]")).click();

    }

    public HomePage addToCart(String name) {
        selectButton(name);
        return this;
    }

    public ShoppingCart goToShoppingCart() {
        Wait.waitForElementToBeClickable(cart);
        cart.click();
        return new ShoppingCart();
    }
}
