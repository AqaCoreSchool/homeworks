package ua.biz.test.tests.punch;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ua.biz.test.base.BaseTest;
import ua.biz.test.entity.PunchData;
import ua.biz.test.pages.MyRecordsPage;
import ua.biz.test.pages.PunchPage;
import java.time.LocalDate;

public class PunchTimeTest extends BaseTest {

    private  String name = faker.firstName();
    private final PunchData TEST_PUNCH_DATA =
            new PunchData(name+" PunchIn",name+"PunchOut");

    @Test
    public void testPunchDate() {
        PunchPage punchPage = mainPage.openPunchPage();
        punchPage.punchInOut(TEST_PUNCH_DATA);
        MyRecordsPage myRecordsPage =mainPage.openMyRecordsPage();
        Assert.assertTrue(myRecordsPage.isRecordPresent(TEST_PUNCH_DATA, LocalDate.now()),"Not found a record with  this data");
    }
}
