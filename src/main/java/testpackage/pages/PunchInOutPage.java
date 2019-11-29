package testpackage.pages;

import testpackage.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;

public class PunchInOutPage {

    private String input = "Test start";
    private String output = "Test finish";
    static String date = LocalDate.now().toString();

    @FindBy(xpath = "//input[@id='btnPunch']")
    private WebElement inOutBtn;

    @FindBy(xpath = "//textarea[@id='note']")
    private WebElement commentInputPunchInOut;

    @FindBy(xpath = "//span[@id='currentDate']")
    private WebElement currentDate;

    @FindBy(xpath = "//span[@id='currentTime']")
    private WebElement currentTime;

    public PunchInOutPage(){
        PageFactory.initElements(BasePage.getInstance().getDriver(), this);
    }

    public PunchInOutPage punchIn(){
        commentInputPunchInOut.sendKeys(input);
        inOutBtn.click();
        return new PunchInOutPage();
    }

    public MainPage punchOut(){
        commentInputPunchInOut.sendKeys(output);
        inOutBtn.click();
        return new MainPage();
    }
}
