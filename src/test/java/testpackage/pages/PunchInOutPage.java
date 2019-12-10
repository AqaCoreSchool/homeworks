package testpackage.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testpackage.base.BasePage;

import java.time.LocalDate;

public class PunchInOutPage extends BasePage {

    private String input = "PurchaseTest start";
    private String output = "PurchaseTest finish";
    static String date = LocalDate.now().toString();

    @FindBy(id = "btnPunch")
    private WebElement inOutBtn;

    @FindBy(id = "note")
    private WebElement commentInputPunchInOut;

    @FindBy(id = "currentDate")
    private WebElement currentDate;

    @FindBy(id = "currentTime")
    private WebElement currentTime;

    @Step
    public PunchInOutPage punchIn(){
        commentInputPunchInOut.sendKeys(input);
        inOutBtn.click();
        return this;
    }

    @Step
    public MainPage punchOut(){
        commentInputPunchInOut.sendKeys(output);
        inOutBtn.click();
        return new MainPage();
    }
}
