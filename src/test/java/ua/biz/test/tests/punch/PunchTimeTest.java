package ua.biz.test.tests.punch;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ua.biz.test.base.BaseTest;
import ua.biz.test.entity.PunchData;
import ua.biz.test.pages.PunchPage;
import java.time.LocalDate;

public class PunchTimeTest extends BaseTest {

    private final PunchData TEST_PUNCH_DATA =
            new PunchData("IMO In8","IMO Out8");

    @Test
    public void testPunchDate() {
        PunchPage punchPage = mainPage.openPunchPage();
        punchPage.punchInOut(TEST_PUNCH_DATA);
        mainPage.openMyRecordsPage().isRecordsListEmpty(LocalDate.now());
        Assert.assertTrue(punchPage.isRecordPresent(TEST_PUNCH_DATA),"Not found a record with  this data");
    }
}
