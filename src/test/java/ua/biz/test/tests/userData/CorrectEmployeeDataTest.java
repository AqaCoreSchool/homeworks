package ua.biz.test.tests.userData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ua.biz.test.base.BaseTest;
import ua.biz.test.entity.Employee;
import ua.biz.test.pages.EmployeeListPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CorrectEmployeeDataTest extends BaseTest {

    private final Employee MY_TEST_EMPLOYEE = new Employee("Ivan", "Mosiychuk", 16);

    @Test
    public void testCorectUserData() {
        mainPage.openMyInfoPage().editEmployeeData(MY_TEST_EMPLOYEE);
        EmployeeListPage employeeListPage=mainPage.openEmployeeListPage();
        Assert.assertTrue(employeeListPage.isEmployeePresent(MY_TEST_EMPLOYEE),
                "Not found an employee with  this data:");
    }

}
