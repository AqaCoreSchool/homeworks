package ua.biz.test.userData;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.DataTest;

public class CorrectUserDataTest extends DataTest {

    @Test
    public void testCorectUserData() {
        editEmployeeData();
        Assert.assertEquals(getUserLastName(),MY_TEST_EMPLOYEE.getLastName());
    }
}
