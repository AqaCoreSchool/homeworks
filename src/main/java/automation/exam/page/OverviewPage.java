package automation.exam.page;

import automation.exam.util.Application;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {
    @FindBy(xpath = "//a[@class='btn_action cart_button']")
    private WebElement finishButton;

    public OverviewPage() {
        PageFactory.initElements(Application.getDriver(), this);
    }

    public FinishPage continuePayment() {
        finishButton.click();
        return new FinishPage();
    }
}
