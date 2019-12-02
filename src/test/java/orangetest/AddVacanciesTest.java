package orangetest;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddVacanciesTest extends BaseTest {
    private VacanciesPage vacanciesPage;
    private Faker faker = new Faker();
    private String vacancyNameStr = "AQA Junior" + faker.zipCode();
    private String hiringManagerStr = "Mariana Romanivna Mykytovych";

    @BeforeTest
    public void beforeClass() {
        loginPage = openLoginPage();
        loginPage.loginIntoSystem("TestUser05", "Vfylhfujhf!1");
        vacanciesPage = new VacanciesPage(driver);
    }

    @Test
    public void addVacanciesTest() {
        vacanciesPage.addVacancy(vacancyNameStr, hiringManagerStr);
        boolean result = vacanciesPage.checkAddedVacancy(vacancyNameStr, hiringManagerStr);
        Assert.assertTrue(result);
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
