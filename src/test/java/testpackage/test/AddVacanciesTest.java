package testpackage.test;

import org.testng.annotations.Test;
import testpackage.base.BaseTest;
import testpackage.entity.Vacancy;
import testpackage.factory.VacancyFactory;
import testpackage.pages.LoginPage;
import testpackage.pages.VacanciesPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AddVacanciesTest extends BaseTest {

    private String login = "TestUser03";
    private String password = "Vfylhfujhf!1";

    @Test
    public void vacanciesAddTest() {
        Vacancy vacancy = new VacancyFactory().defaultVacancy();
        LoginPage loginPage = new LoginPage();
        loginPage
                .loginToTheSystem(login, password)
                .moveToVacancies()
                .createVacancy(vacancy)
                .moveToVacancies();
        assertThat(new VacanciesPage().filterVacancies(vacancy))
                .as("No created vacancy").isTrue();
    }
}
