package orangetest.tests;

import pages.EditUserPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EditUserTest extends BaseTest {
    private static final String FIRST_NAME = "Mariana";
    private static final String LAST_NAME = "Mykytovych";
    private static final String MIDDLE_NAME = "Romanivna";
    private static final String BIRTHDAY = "1993-09-07";
    private EditUserPage userPage;

    @Test
    public void editUserTest() {
        userPage = new EditUserPage(driver);
        userPage.editUser(FIRST_NAME, LAST_NAME, MIDDLE_NAME, BIRTHDAY);
        boolean result = userPage.isUserEdited(FIRST_NAME, LAST_NAME, MIDDLE_NAME);
        Assert.assertTrue(result, "Such user has not been found");

    }

}
