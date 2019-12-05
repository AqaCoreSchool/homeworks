package test;

import data.PunchData;
import pages.OrangeTimePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreatePunchRecordTest extends  BaseTest {
    private PunchData punch = new PunchData();

    @Test
    public void createPunchAndCheckRecordDataTest(){
        OrangeTimePage timePage = openLoginPage().loginCorrect(USERNAME, PASSWORD).toTimeModulePage();
        timePage.createPunch(punch.getPunchInMessage());
        timePage.createPunch(punch.getPunchOutMessage());
        timePage.checkPunchInRecordsTable(punch.getTodayDate());
        Assert.assertEquals(timePage.getLatestRecordPunchIn(), timePage.getPunchInDateTime(),
                "record Punch In datetime is different then actual Punch In datetime!");
        Assert.assertEquals(timePage.getLatestRecordPunchInNote(), punch.getPunchInMessage(),
                "record Punch In note is different then actual Punch In note!");
        Assert.assertEquals(timePage.getLatestRecordPunchOut(), timePage.getPunchOutDateTime(),
                "record Punch Out datetime is different then actual Punch Out datetime!");
        Assert.assertEquals(timePage.getLatestRecordPunchOutNote(), punch.getPunchOutMessage(),
                "record Punch Out datetime is different then actual Punch Out datetime!");
    }
}
