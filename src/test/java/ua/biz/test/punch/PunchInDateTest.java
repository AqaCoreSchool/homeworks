package ua.biz.test.punch;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.DataTest;

public class PunchInDateTest extends DataTest {
    @Test
    public  void testPunchInDate() {
        punchInOut();
        Assert.assertTrue(getRecordDataByPunchMessage(punchInMessage, 2, 1).contains(punchInTime));
    }
}
