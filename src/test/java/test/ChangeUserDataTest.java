package test;

import data.UserData;
import pages.OrangeAdminPage;
import pages.OrangeMyInfoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeUserDataTest extends BaseTest{
    UserData userData = new UserData();

    @Test
    public void changeUserDataAndCheckUsersTest(){
        OrangeMyInfoPage infoPage = openLoginPage()
                .loginCorrect(USERNAME, PASSWORD)
                .toMyInfoPage()
                .editUserData(userData);
        OrangeAdminPage adminPage = infoPage.toAdminModulePage();
        Assert.assertTrue(adminPage.findUser(USERNAME, userData),
                "User name and surname in list is different!");
    }
}
