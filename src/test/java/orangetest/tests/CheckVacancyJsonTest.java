package orangetest.tests;

import orangetest.pages.VacanciesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckVacancyJsonTest extends BaseTest{
    VacanciesPage vacanciesPage;
    @Test
    public void checkVacancyJsonTest() {
        vacanciesPage = new VacanciesPage();
        boolean result = vacanciesPage.checkFromJSON();
        Assert.assertTrue(result);
    }
}
