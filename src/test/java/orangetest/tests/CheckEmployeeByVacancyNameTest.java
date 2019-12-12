package orangetest.tests;

import orangetest.pages.VacanciesPage;
import orangetest.sqltask.SqlDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckEmployeeByVacancyNameTest extends BaseTest {
    private String vacancyNameForSearch = "Administrator";

    @Test
    public void checkEmployeeByVacancyName() {
        SqlDataProvider sqlDataProvider = new SqlDataProvider();
        String vacancyHiringManager = sqlDataProvider.getEmployeeNameByVacancyName(vacancyNameForSearch);
        VacanciesPage vacanciesPage = new VacanciesPage();
        Assert.assertTrue(vacanciesPage.isHiringManager(vacancyNameForSearch, vacancyHiringManager),
                "Information about hiring manager for this Vacancy is different in UI and Database");
    }
}
