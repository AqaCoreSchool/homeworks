package orangetest.tests;

import orangetest.pages.VacanciesPage;
import orangetest.sqltask.EmployeesDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckEmployeeByVacancyNameTest extends BaseTest {
    private String vacancyNameForSearch = "Administrator";

    @Test
    public void checkEmployeeByVacancyName() {
        EmployeesDataProvider employeesDataProvider = new EmployeesDataProvider();
        String vacancyHiringManager = employeesDataProvider.getEmployeeNameByVacancyName(vacancyNameForSearch);
        VacanciesPage vacanciesPage = new VacanciesPage();
        Assert.assertTrue(vacanciesPage.isHiringManagerPresent(vacancyNameForSearch, vacancyHiringManager),
                "Information about hiring manager for this Vacancy is different in UI and Database");
    }
}
