package ua.biz.test.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.biz.test.entity.PunchData;
import ua.biz.test.utils.WaitUtil;
import ua.biz.test.base.BasePage;


import java.time.LocalDate;
import java.util.List;

public class MyRecordsPage extends BasePage {

    @FindBy(xpath ="//input[@id='attendance_date']")
    private  WebElement dateInput;

    @FindBy(id = "employeeRecordsForm")
    private WebElement recordsForm;

    @FindBy(xpath = "//form[@id='employeeRecordsForm']/table/tbody/tr[@class='odd' or @class='even']")
    private List<WebElement> recordsList;

    public boolean isRecordsListEmpty(LocalDate date) {
        showRecordListByDate(date);
        return recordsList.isEmpty();
    }

    private MyRecordsPage showRecordListByDate(LocalDate date){
        WaitUtil.waitAndClear(dateInput);
        dateInput.sendKeys(date.toString());
        dateInput.sendKeys(Keys.ENTER);
        return this;
    }

    public boolean isRecordPresent(PunchData punchData, LocalDate date) {
        System.out.println(recordsList.size());
        showRecordListByDate(date);
        return recordsList.stream().map(WebElement::getText).
                anyMatch(data->data.contains(punchData.getPunchInTime())&&
                        data.contains(punchData.getPunchInMessage())&&
                        data.contains(punchData.getPunchOutTime())&&
                        data.contains(punchData.getPunchOutMessage()));
    }
}
