package tests_sql;

import data.LoginInfo;
import data.Vacancy;
import org.testng.annotations.Test;
import pages.VacanciesPage;
import tests.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class SQLTest extends BaseTest {

    @Test
    public void testSQL(){
        Vacancy vacancy = new Vacancy();
        VacanciesPage vacanciesPage = loginPage
                .loginIntoSite(LoginInfo.LOGIN, LoginInfo.PASSWORD)
                .moveToVacanciesPage()
                .addNewVacancy(vacancy);

    }
}
