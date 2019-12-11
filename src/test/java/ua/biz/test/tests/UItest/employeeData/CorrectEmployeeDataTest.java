package ua.biz.test.tests.UItest.employeeData;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.biz.test.base.BaseTest;
import ua.biz.test.pages.EmployeeListPage;

public class CorrectEmployeeDataTest extends BaseTest {


    @Test
    public void testCorectUserData() {
        mainPage.openMyInfoPage().editEmployeeData(MY_TEST_EMPLOYEE);
        EmployeeListPage employeeListPage=mainPage.openEmployeeListPage();
        Assert.assertTrue(employeeListPage.isEmployeePresent(MY_TEST_EMPLOYEE),
                "Not found an employee with  this data:");
    }

}
