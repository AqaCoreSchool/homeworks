package orangetest.tests;

import orangetest.data.Vacancy;
import orangetest.pages.VacanciesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddVacancyTest extends BaseTest {
    private VacanciesPage vacanciesPage;

    @Test
    public void addVacanciesTest() {
        Vacancy vacancy = new Vacancy();
        vacanciesPage = new VacanciesPage();
        Assert.assertTrue(vacanciesPage
                        .addVacancy(vacancy.getVacancyName(), vacancy.getHiringManager(), vacancy.getNumberOfPositions())
                        .isVacancyAdded(vacancy.getVacancyName(), vacancy.getHiringManager()),
                "Vacancy with such parameters has not been found");

    }
}
