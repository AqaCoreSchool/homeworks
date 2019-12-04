package orangetest.tests;

import orangetest.pages.CandidatesPage;
import orangetest.pages.VacanciesPage;
import orangetest.utils.Application;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddEmptyVacancyTest extends BaseTest {
    private VacanciesPage vacanciesPage;

    @Test
    public void addEmptyVacancyTest() {
        vacanciesPage = new VacanciesPage();
        Assert.assertTrue(vacanciesPage.addEmptyVacancy(), "Should be 3 error messages");
    }
}
