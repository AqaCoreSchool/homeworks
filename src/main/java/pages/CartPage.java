package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

import static java.lang.Thread.sleep;

public class CartPage extends BasePage{

    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    private WebElement btnCheckout;

    @FindBy(xpath = "//a[@class='btn_secondary']")
    private WebElement btnContinueShopping;

    public CheckoutPage moveToCheckoutPage(){
        Utils.waitAndClick(btnCheckout);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CheckoutPage();
    }
}
