package pages;

import Data.CheckoutInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {
    @FindBy(id="first-name")
    private WebElement firstName;

    @FindBy(id="last-name")
    private WebElement lastName;

    @FindBy(id="postal-code")
    private WebElement postalCode;

    @FindBy(xpath = "//input[@class='btn_primary cart_button']")
    private WebElement continueBtn;

    @FindBy(xpath = "//a[@class='btn_action cart_button']")
    private WebElement finishButton;

    CheckoutInformation cred = new CheckoutInformation();

    public void fillInformation(){
        firstName.click();
        firstName.sendKeys(cred.getFirstName());
        lastName.click();
        lastName.sendKeys(cred.getLastName());
        postalCode.click();
        postalCode.sendKeys();
        continueBtn.click();
    }
}
