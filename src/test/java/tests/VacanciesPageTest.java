package tests;

import data.LoginInfo;
import data.Vacancy;
import org.testng.annotations.Test;
import pages.VacanciesPage;

import static org.assertj.core.api.Assertions.assertThat;

public class VacanciesPageTest extends BaseTest {

    @Test
    public void testVacanciesPage() {
        Vacancy vacancy = new Vacancy();
        VacanciesPage vacanciesPage = loginPage
                .loginIntoSite(LoginInfo.LOGIN, LoginInfo.PASSWORD)
                .moveToVacanciesPage()
                .addNewVacancy(vacancy);

        assertThat(vacanciesPage.findVacancy(vacancy))
                .as("String should contain active vacancy").isNotEmpty();
    }

}
