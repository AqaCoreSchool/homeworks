package ua.biz.test.records;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.DataTest;

import java.time.LocalDate;
import java.util.List;

public class TomorrowRecordsListTest extends DataTest {

    @Test
    public void testTomorrowRecordsLisr() {
        List<WebElement> recordData = getAllRecordData(LocalDate.now().plusDays(1));
        Assert.assertTrue(recordData.isEmpty());
    }
}
