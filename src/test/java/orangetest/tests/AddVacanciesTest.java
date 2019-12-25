package orangetest.tests;

import com.github.javafaker.Faker;
import pages.VacanciesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddVacanciesTest extends BaseTest {
    private VacanciesPage vacanciesPage;
    private Faker faker = new Faker();
    private String vacancyNameStr = "AQA Junior" + faker.zipCode();
    private String hiringManagerStr = "Mariana Romanivna Mykytovych";

    @Test
    public void addVacanciesTest() {
        vacanciesPage = new VacanciesPage(driver);
        vacanciesPage.addVacancy(vacancyNameStr, hiringManagerStr);
        boolean result = vacanciesPage.isVacancyAdded(vacancyNameStr, hiringManagerStr);
        Assert.assertTrue(result, "Vacancy with such parameters has not been found");
    }
}
