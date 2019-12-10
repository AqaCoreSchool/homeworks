package orangetest;

import com.github.javafaker.Faker;
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
        Assert.assertTrue(result);
    }
}
