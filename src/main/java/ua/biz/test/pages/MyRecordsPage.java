package ua.biz.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.util.List;

public class MyRecordsPage {

    @FindBy(xpath ="//input[@id='attendance_date']")
    private  WebElement dateInput;

    public MyRecordsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void showRecordDataByDate(LocalDate date) {
        dateInput.click();
        dateInput.clear();
        dateInput.sendKeys(date.toString());
        dateInput.sendKeys(Keys.ENTER);
    }
}
