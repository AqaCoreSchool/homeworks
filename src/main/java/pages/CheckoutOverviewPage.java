package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

import static java.lang.Thread.sleep;

public class CheckoutOverviewPage extends BasePage{

    @FindBy(xpath = "//a[@class='btn_action cart_button']")
    private WebElement btnContinue;

    public ConfirmOrderPage moveToConfirmOrderPage(){
        Utils.waitAndClick(btnContinue);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ConfirmOrderPage();
    }
}
