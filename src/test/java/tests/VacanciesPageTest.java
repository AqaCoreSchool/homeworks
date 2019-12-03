package tests;

import data.UserInfo;
import data.VacancyInfo;
import org.testng.annotations.Test;
import pages.VacanciesPage;
import static org.assertj.core.api.Assertions.*;

public class VacanciesPageTest extends BaseTest {

    @Test
    public void testVacanciesPage() {
        loginPage
                .loginIntoSite(UserInfo.LOGIN, UserInfo.PASSWORD)
                .clickRecruitmentBtn()
                .clickVacanciesBtn()
                .clickAddBtn()
                .selectJobTittle()
                .vacancyNameInput(VacancyInfo.VACANCY)
                .hiringManagerInput(VacancyInfo.HIRING_MANAGER)
                .clickSaveBtn()
                .clickBackBtn();

        assertThat(new VacanciesPage()
                .findVacancies(VacancyInfo.VACANCY, VacancyInfo.JOB_TITLE, VacancyInfo.HIRING_MANAGER, VacancyInfo.STATUS))
                .as("String should contain active vacancy").isNotEmpty();
    }

}
