package ua.biz.test.punchDate;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.DataTest;

public class PunchInDateTest extends DataTest {
    @Test
    public  void testPunchInDate() {
        punchIn();
        System.out.println(punchInTime);
        Assert.assertTrue(getRecordDataByPunchMessage(punchInMessage, 2, 1).contains(punchInTime));
    }
}
