package ua.biz.test.tests.UItest.userData;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.biz.test.base.BaseTest;
import ua.biz.test.entity.Employee;
import ua.biz.test.pages.EmployeeListPage;

public class CorrectEmployeeDataTest extends BaseTest {

    private final Employee MY_TEST_EMPLOYEE = new Employee("Ivan","", "Mosiychuk", 16);

    @Test
    public void testCorectUserData() {
        mainPage.openMyInfoPage().editEmployeeData(MY_TEST_EMPLOYEE);
        EmployeeListPage employeeListPage=mainPage.openEmployeeListPage();
        Assert.assertTrue(employeeListPage.isEmployeePresent(MY_TEST_EMPLOYEE),
                "Not found an employee with  this data:");
    }

}
