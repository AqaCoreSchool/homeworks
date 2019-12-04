package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeListPageTest extends BaseTest {

    @Test
    public void employeeListTest() {
        boolean userExists = getLoginPage()
                .fillUsername(getUser().getUserLoginName())
                .fillPassword(getUser().getUserPassword())
                .clickLoginButton()
                .moveToPimItem()
                .clickEmployeeListButton()
                .collectEmployees()
                .isUserExists();

        Assert.assertTrue(userExists);
    }
}
