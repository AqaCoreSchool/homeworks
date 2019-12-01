package test;

import org.testng.annotations.Test;
import testpackage.pages.LoginPage;
import testpackage.pages.VacanciesPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AddVacanciesTest {

    private String login = "TestUser03";
    private String password = "Vfylhfujhf!1";
    private String hiringManager = "Danylo Alexandrovich Pazykov";
    private String vacancy = "Junior";
    private String jobTitle = "AQA";
    private String status = "Active";

    @Test
    public void vacanciesAddTest() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .openLoginPage()
                .loginToTheSystem(login, password)
                .moveToRecruitment()
                .moveToVacancies()
                .clickAddVacancy()
                .selectJobTitle()
                .inputVacancyName(vacancy)
                .inputHiringManager(hiringManager)
                .clickSaveVacancy()
                .moveToVacancies();
        assertThat(new VacanciesPage().filterVacancies(jobTitle,vacancy,hiringManager,status)).isTrue();
    }
}
