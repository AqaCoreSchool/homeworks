package testpackage.pages;

import org.testng.Assert;
import testpackage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class MyRecordsPage {

    private WebDriver driver = BasePage.getInstance().getDriver();
    private String input = "Test start";
    private String output = "Test finish";
    private String date = PunchInOutPage.date;

    @FindBy (xpath = "//select[@class='ui-datepicker-month']")
    private  WebElement months;

    @FindBy (xpath = "//img[@class='ui-datepicker-trigger']")
    private WebElement dateMyRecords;

    @FindBy (xpath = " //td[@id='noRecordsColumn']")
    private  WebElement messagesNoAttendance;

    public MyRecordsPage(){
        PageFactory.initElements(BasePage.getInstance().getDriver(), this);
    }

    public MyRecordsPage goToDate(String dayOfMonth){
        dateMyRecords.click();
        BasePage.getInstance().getDriver().findElement(By.linkText(dayOfMonth)).click();
        return new MyRecordsPage();
    }

    public MyRecordsPage goToDateWithMonth(String dayOfMonth,String month){
        dateMyRecords.click();
        months.click();
        driver.findElement(By.xpath("//option[contains(text(),'"+month+"')]")).click();
        driver.findElement(By.linkText(dayOfMonth)).click();
        return new MyRecordsPage();
    }

    public String filterTable(){
        List<WebElement> tableRows = driver.findElements(By.xpath(
            "//form[@id='employeeRecordsForm']//table//tbody//tr[@class='odd' or @class='even']"));
    String workInDate = tableRows.stream()
            .map(WebElement::getText)
            .filter(e->e.contains(date)
                    &e.contains(input)
                    &e.contains(output))
            .collect(Collectors.joining(" "));
    return workInDate;
    }

    public MyRecordsPage verifyAttendance(){
        Assert.assertTrue(messagesNoAttendance.isDisplayed());
        return new MyRecordsPage();
    }
}
