package test;

import data.PunchData;
import pages.OrangeTimePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckEmptyPunchesTest extends BaseTest{
    private PunchData punch = new PunchData();


    @Test
    public void recordsTableIsEmptyTest(){
        OrangeTimePage timePage = openLoginPage()
                .loginCorrect(USERNAME, PASSWORD)
                .toTimeModulePage()
                .checkEmptyRecordsTable(punch.getWeekAfter());
        Assert.assertTrue(timePage.noRecordsIsDisplayed(), "Record table isn't empty!");
    }
}
