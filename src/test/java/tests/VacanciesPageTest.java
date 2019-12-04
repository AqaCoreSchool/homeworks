package tests;

import data.UserInfo;
import data.VacancyInfo;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VacanciesPage;
import static org.assertj.core.api.Assertions.*;

public class VacanciesPageTest extends BaseTest {

    @Test
    public void testVacanciesPage() {
        loginPage
                .loginIntoSite(UserInfo.LOGIN, UserInfo.PASSWORD)
                .moveToVacanciesPage()
                .addNewVacancy(VacancyInfo.VACANCY, VacancyInfo.HIRING_MANAGER);

        assertThat(new VacanciesPage()
                .findVacancies(VacancyInfo.VACANCY, VacancyInfo.JOB_TITLE, VacancyInfo.HIRING_MANAGER, VacancyInfo.STATUS))
                .as("String should contain active vacancy").isNotEmpty();
    }

}
