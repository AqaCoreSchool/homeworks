package orangetest.tests;

import orangetest.pages.VacanciesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddVacancyTest extends BaseTest {
    private VacanciesPage vacanciesPage;

    @Test
    public void addVacanciesTest() {
        vacanciesPage = new VacanciesPage();
        vacanciesPage.addVacancy();
        boolean result = vacanciesPage.checkAddedVacancy();
        Assert.assertTrue(result);
    }
}
