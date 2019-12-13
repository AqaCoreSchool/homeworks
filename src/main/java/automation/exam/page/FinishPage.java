package automation.exam.page;

import automation.exam.util.Application;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishPage {
    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeLabel;

    public FinishPage() {
        PageFactory.initElements(Application.getDriver(), this);
    }

    public boolean isOrderComplete() {
        return completeLabel.isDisplayed();
    }
}
