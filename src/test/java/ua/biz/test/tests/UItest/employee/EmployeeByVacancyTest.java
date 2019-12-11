package ua.biz.test.tests.UItest.employee;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.biz.test.base.BaseTest;
import ua.biz.test.pages.EmployeeListPage;

public class EmployeeByVacancyTest extends BaseTest {

    @Test
    public void testCorectUserData() {
        EmployeeListPage employeeListPage = mainPage.openEmployeeListPage();
        Assert.assertTrue(employeeListPage.isEmployeePresentByVacancy(TEST_VACANCY));
    }

}
