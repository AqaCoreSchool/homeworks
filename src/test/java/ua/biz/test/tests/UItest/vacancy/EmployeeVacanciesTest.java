package ua.biz.test.tests.UItest.vacancy;


import org.testng.Assert;
import org.testng.annotations.Test;
import ua.biz.test.base.BaseTest;
import ua.biz.test.pages.VacanciesListPage;

public class EmployeeVacanciesTest extends BaseTest {
    @Test
    public void testEmployeeVacancies(){
        VacanciesListPage vacanciesListPage = mainPage.openVacanciesListPage();
        Assert.assertTrue(vacanciesListPage.isAllEmployeeVacanciesPresent(MY_TEST_EMPLOYEE),
                "Vacancies Data from UI does not equals vacancies data from DB");
    }
}
