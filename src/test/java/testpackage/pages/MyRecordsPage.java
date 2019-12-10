package testpackage.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testpackage.base.BasePage;
import testpackage.manager.DriverManager;

import java.util.List;

public class MyRecordsPage extends BasePage {

    private WebDriver driver = DriverManager.getInstance().getDriver();
    private String input = "PurchaseTest start";
    private String output = "PurchaseTest finish";
    private String date = PunchInOutPage.date;

    @FindBy (className = "ui-datepicker-month")
    private  WebElement months;

    @FindBy (className = "ui-datepicker-trigger")
    private WebElement dateMyRecords;

    @FindBy (id = "noRecordsColumn")
    private  WebElement messagesNoAttendance;

    @FindBy(xpath = "//table[@class='table']//tbody")
    private List<WebElement> table;

    @Step
    public MyRecordsPage goToDate(String dayOfMonth){
        dateMyRecords.click();
        driver.findElement(By.linkText(dayOfMonth)).click();
        return this;
    }

    @Step
    public MyRecordsPage goToDateWithMonth(String dayOfMonth,String month){
        dateMyRecords.click();
        months.click();
        driver.findElement(By.xpath("//option[contains(text(),'"+month+"')]")).click();
        driver.findElement(By.linkText(dayOfMonth)).click();
        return this;
    }

    @Step
    public boolean filterTable(){
    boolean workInDate = table.stream()
            .map(WebElement::getText)
            .anyMatch(e->e.contains(date)
                    &e.contains(input)
                    &e.contains(output));
    return workInDate;
    }

    @Step
    public boolean getMessagesNoAttendance(){
        return messagesNoAttendance.isDisplayed();
    }
}
