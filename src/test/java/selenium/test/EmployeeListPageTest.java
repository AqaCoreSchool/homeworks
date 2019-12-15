package selenium.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeeListPageTest extends BaseTest {

    @Test
    public void employeeListTest() {
        boolean userExists = getLoginPage()
                .fillUsername(getCredentials().getUserLoginName())
                .fillPassword(getCredentials().getUserPassword())
                .clickLoginButton()
                .moveToPimItem()
                .clickEmployeeListButton()
                .collectEmployees()
                .isUserExists();

        Assert.assertTrue(userExists, "Employee is not exist");
    }
}
