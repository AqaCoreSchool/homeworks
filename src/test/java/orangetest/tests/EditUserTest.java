package orangetest.tests;

import orangetest.data.User;
import orangetest.pages.EditUserPage;
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
        User user = new User();
        userPage = new EditUserPage();
        Assert.assertTrue(userPage.editUser(user.getFirstName(),
                                    user.getLastName(),
                                    user.getMiddleName(),
                                    user.getBirthday())
                        .isUserEdited(user.getFirstName(),
                                    user.getLastName(),
                                    user.getMiddleName()),
                "Such user has not been found");
    }
}
