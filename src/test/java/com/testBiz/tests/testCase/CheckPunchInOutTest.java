package com.testBiz.tests.testCase;

import com.sun.xml.internal.bind.v2.model.core.MaybeElement;
import com.testBiz.pages.LoginPage;
import com.testBiz.pages.MainPage;
import com.testBiz.pages.MyRecordsPage;
import com.testBiz.pages.PunchInOutPage;
import com.testBiz.util.driver.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class CheckPunchInOutTest {
    @BeforeMethod
    public void setup(){Driver.getInstance().getDriver();}

    @Test
    public void checkPunchInOut(){
            LoginPage loginPage = new LoginPage();
            MainPage mainPage = new MainPage();
            PunchInOutPage punchInOutPage = new PunchInOutPage();
            MyRecordsPage myRecordsPage = new MyRecordsPage();

            loginPage.typeEmail();
            loginPage.typePassword();
            loginPage.clickLogInButton();
            mainPage.clickTimeBtnHeader();
            mainPage.clickAttendanceBtn();
            mainPage.clickPunchInOutBtn();
            punchInOutPage.setCommentTextPunchInOut("OVlsaenko Punch In");
            String date = punchInOutPage.getCurrentDate();
            punchInOutPage.clickInOutBtn();
            punchInOutPage.setCommentTextPunchInOut("OVlsaenko Punch Out");
            punchInOutPage.clickInOutBtn();
            mainPage.clickAttendanceBtn();
            mainPage.clickMyRecordsBtn();
            myRecordsPage.setDate(date);
            myRecordsPage.checkTextPunchIn();
            myRecordsPage.checkTextPunchOut();
        }


    @AfterMethod
    public void closeBrowser() {
        Driver.getInstance().quitDriver();
    }
}
