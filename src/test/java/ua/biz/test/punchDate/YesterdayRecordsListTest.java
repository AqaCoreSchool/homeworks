package ua.biz.test.punchDate;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.DataTest;

import java.time.LocalDate;
import java.util.List;

public class YesterdayRecordsListTest extends DataTest {

    @Test
    public  void testYesterdayRecordsLisr() {
        List<WebElement> recordData = getAllRecordData(LocalDate.now().minusDays(1));
        Assert.assertTrue(recordData.size() > 1);
    }
}
