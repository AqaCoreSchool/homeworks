package ua.biz.test.records;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ua.biz.test.BaseTest;
import ua.biz.test.pages.MyRecordsPage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OtherDaysRecordsListTest extends BaseTest {

    @Test
    public void testRecordsLisr() {
        SoftAssert softAssert = new SoftAssert();
        MyRecordsPage myRecordsPage = mainPage.openMyRecordsPage(driver);
        myRecordsPage.showRecordDataByDate(LocalDate.now().plusDays(1));
        List<WebElement> recordsDataList = driver.findElements(By.xpath("//table[@class='table']//tbody//tr[@class='odd' or @class='even']"));
        softAssert.assertTrue(recordsDataList.isEmpty());

        myRecordsPage.showRecordDataByDate(LocalDate.now().minusDays(1));
        recordsDataList = driver.findElements(By.xpath("//table[@class='table']//tbody//tr[@class='odd' or @class='even']"));
        softAssert.assertFalse(recordsDataList.isEmpty());
        softAssert.assertAll();
        System.out.println(recordsDataList.isEmpty());
    }
}
