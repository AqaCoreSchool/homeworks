package ua.biz.test.punch;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.DataTest;

public class PunchOutDateTest extends DataTest {
    @Test
    public void testPunchOutDate() {
        punchInOut();
        Assert.assertTrue(getRecordDataByPunchMessage(punchOutMessage, 4, 3).contains(punchOutTime));
    }
}
