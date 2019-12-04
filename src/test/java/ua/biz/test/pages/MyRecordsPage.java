package ua.biz.test.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.biz.test.utils.WaitUtil;
import ua.biz.test.base.BasePage;


import java.time.LocalDate;
import java.util.List;

public class MyRecordsPage extends BasePage {

    @FindBy(xpath ="//input[@id='attendance_date']")
    private  WebElement dateInput;

    @FindBy(id = "employeeRecordsForm")
    private WebElement recordsForm;

    @FindBy(xpath = "//table[@class='table']//tbody//tr[@class='odd' or @class='even']")
    private List<WebElement> recordsList;


    public MyRecordsPage() {
        super();
    }

    public boolean isRecordsListEmpty(LocalDate date) {
        WaitUtil.waitAndClear(dateInput);
        dateInput.sendKeys(date.toString());
        dateInput.sendKeys(Keys.ENTER);
        return recordsList.isEmpty();
    }
}
