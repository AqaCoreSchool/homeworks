package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Utils;

public class CheckoutPage extends BasePage{

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement zipCodeInput;

    @FindBy(xpath = "//input[@class='btn_primary cart_button']")
    private WebElement btnContinue;

    public CheckoutPage inputAllFields(String name, String lastName, String code){
        Utils.waitAndSendKeys(firstNameInput, name);
        Utils.waitAndSendKeys(lastNameInput, lastName);
        Utils.waitAndSendKeys(zipCodeInput, code);
        return this;
    }
    public CheckoutOverviewPage moveToCheckoutOverview(){
        Utils.waitAndClick(btnContinue);
        return new CheckoutOverviewPage();
    }
}
