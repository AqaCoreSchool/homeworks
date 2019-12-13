package automation.exam.page;

import automation.exam.util.Application;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//input[@class='btn_primary cart_button']")
    private WebElement continueButton;

    public InformationPage() {
        PageFactory.initElements(Application.getDriver(), this);
    }

    public InformationPage fillInformation(){
        firstNameInput.sendKeys("Andrii");
        lastNameInput.sendKeys("Rybka");
        postalCodeInput.sendKeys("80700");
        return this;
    }

    public OverviewPage confirmInformation(){
        continueButton.click();
        return new OverviewPage();
    }

}
