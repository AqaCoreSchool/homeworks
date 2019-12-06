package orangetest.tests;

import orangetest.pages.EditUserPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EditUserTest extends BaseTest {
    private EditUserPage userPage;

    @Test
    public void editUserTest(){
        userPage = new EditUserPage();
        Assert.assertTrue(userPage.editUser().checkEditedUser(), "Such user has not been found");
    }
}
