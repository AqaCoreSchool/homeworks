package ua.biz.test.tests.records;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ua.biz.test.base.BaseTest;
import ua.biz.test.pages.MyRecordsPage;

import java.time.LocalDate;
import java.util.List;

public class OtherDaysRecordsListTest extends BaseTest {

    @Test
    public void testRecordsLisr() {
        MyRecordsPage myRecordsPage = mainPage.openMyRecordsPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(myRecordsPage.isRecordsListEmpty(LocalDate.now().plusDays(1)),
                "Tomorrow's records list must be empty");
        softAssert.assertFalse(myRecordsPage.isRecordsListEmpty(LocalDate.now().minusDays(1)),
                "Yesterday's records list must not be empty");
        softAssert.assertAll();
    }
}
