package testpackage.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testpackage.base.BasePage;

public class CheckoutPage extends BasePage {

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code" )
    private WebElement postalCode;

    @FindBy(className = "btn_primary cart_button")
    private WebElement continueBtn;

}
