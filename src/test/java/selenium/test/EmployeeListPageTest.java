package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.data.UserData;

public class EmployeeListPageTest extends BaseTest {

    @Test
    public void employeeListTest() {
        boolean userExists = getLoginPage()
                .fillUsername(UserData.USER_LOGIN_NAME)
                .fillPassword(UserData.USER_PASSWORD)
                .clickLoginButton()
                .moveToPimItem()
                .clickEmployeeListButton()
                .collectEmployees()
                .isUserExists();

        Assert.assertTrue(userExists);
    }
}
